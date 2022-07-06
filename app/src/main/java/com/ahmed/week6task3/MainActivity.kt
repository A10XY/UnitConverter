package com.ahmed.week6task3

import android.os.Bundle
import android.view.MenuInflater
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editText: EditText = findViewById(R.id.From_EditText)
        editText.showSoftInputOnFocus = false
        editText.requestFocus()
    }

    private var selectedTypeId = R.id.DataSize
    fun showPopup(v: View) {
        val selectedText: Button = findViewById(R.id.Type_Chooser_Button)
        val popup = PopupMenu(this, v)
        val inflater: MenuInflater = popup.menuInflater
        inflater.inflate(R.menu.types_menu, popup.menu)
        popup.setOnMenuItemClickListener {
            shortToast(this, it.title.toString())
            selectedTypeId = it.itemId
            selectedText.text = it.title.toString()
            true
        }
        popup.show()
    }

    private var currentFromUnit = R.id.Bit
    private var currentFromUnitTitle = "Bit (bit)"
    fun showFromUnitMenu(v: View) {
        val fromButton: Button = findViewById(R.id.From_Unit_Button)
        val popup = PopupMenu(this, v)
        val inflater: MenuInflater = popup.menuInflater
        when (selectedTypeId) {
            R.id.DataSize -> {
                inflater.inflate(R.menu.data_sizes_menu, popup.menu)
                popup.menu.removeItem(currentFromUnit)
                popup.menu.removeItem(currentToUnit)
            }
        }
        popup.setOnMenuItemClickListener {
            currentFromUnit = it.itemId
            currentFromUnitTitle = it.title.toString()
            fromButton.text = it.title.toString()
            true
        }
        popup.show()
    }

    private var currentToUnit = R.id.Byte
    private var currentToUnitTitle = "Byte (B)"
    fun showToUnitMenu(v: View) {
        val toButton: Button = findViewById(R.id.To_Unit_Button)
        val popup = PopupMenu(this, v)
        val inflater: MenuInflater = popup.menuInflater
        when (selectedTypeId) {
            R.id.DataSize -> {
                inflater.inflate(R.menu.data_sizes_menu, popup.menu)
                popup.menu.removeItem(currentToUnit)
                popup.menu.removeItem(currentFromUnit)
            }
        }
        popup.setOnMenuItemClickListener {
            currentToUnit = it.itemId
            currentToUnitTitle = it.title.toString()
            toButton.text = it.title.toString()
            true
        }
        popup.show()
    }

    private var numberString = ""
    fun typeThis(v: View) {
        val button = v as Button
        val editText: EditText = findViewById(R.id.From_EditText)
        if (numberString == "" && button.text.toString() == ".") return
        if (numberString == "" && button.text.toString() == "00") return
        numberString += button.text.toString()
        editText.text = convertStringToEditable(numberString)
        val from = currentFromUnitTitle.split(" ")[0]
        val to = currentToUnitTitle.split(" ")[0]
        val textView: TextView = findViewById(R.id.To_TextView)
        textView.text = convertDataSizes(numberString.toDouble(), from, to).toString()
    }

    fun delete(v: View) {
        val editText: EditText = findViewById(R.id.From_EditText)
        if (numberString != "") {
            numberString = numberString.subSequence(0, numberString.lastIndex).toString()
        }
        editText.text = convertStringToEditable(numberString)
        val textView: TextView = findViewById(R.id.To_TextView)
        val from = currentFromUnitTitle.split(" ")[0]
        val to = currentToUnitTitle.split(" ")[0]
        if (numberString == "" || numberString == "." || numberString == "00") {
            textView.text = "0"
        } else {
            textView.text = convertDataSizes(numberString.toDouble(), from, to).toString()
        }
    }

    fun clear(v: View) {
        val editText: EditText = findViewById(R.id.From_EditText)
        numberString = ""
        editText.text = convertStringToEditable(numberString)
        val textView: TextView = findViewById(R.id.To_TextView)
        textView.text = "0"
    }

    fun swap(v: View) {
        val currentFrom = currentFromUnit
        val currentTo = currentToUnit
        currentFromUnit = currentTo
        currentToUnit = currentFrom

        val currentFromTitle = currentFromUnitTitle
        val currentToTitle = currentToUnitTitle
        currentFromUnitTitle = currentToTitle
        currentToUnitTitle = currentFromTitle

        val fromButton: Button = findViewById(R.id.From_Unit_Button)
        fromButton.text = currentToUnitTitle
        val toButton: Button = findViewById(R.id.To_Unit_Button)
        toButton.text = currentFromUnitTitle

        val textView: TextView = findViewById(R.id.To_TextView)
        val from = currentFromUnitTitle.split(" ")[0]
        val to = currentToUnitTitle.split(" ")[0]
        if (numberString == "" || numberString == "." || numberString == "00") {
            textView.text = "0"
        } else {
            textView.text = convertDataSizes(numberString.toDouble(), from, to).toString()
        }
    }
}