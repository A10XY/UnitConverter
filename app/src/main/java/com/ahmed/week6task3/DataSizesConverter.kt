package com.ahmed.week6task3

fun convertDataSizes(value: Double, from: String, to: String): Any {
    return when (from) {
        "Bit" -> {
            when (to) {
                "Byte" -> value * 0.125
                "KiloByte" -> value * 0.000_610_352
                "MegaByte" -> value * 0.000_000_596
                "GigaByte" -> value * 0.000_000_000_6
                "TeraByte" -> value * 0.000_000_000_000_11
                else -> 0
            }
        }
        "Byte" -> {
            when (to) {
                "Bit" -> value * 8
                "KiloByte" -> value * 0.000_976_562
                "MegaByte" -> value * 0.000_000_953_7
                "GigaByte" -> value * 0.000_000_000_9
                "TeraByte" -> value * 0.000_000_000_001
                else -> 0
            }
        }
        "KiloByte" -> {
            when (to) {
                "Bit" -> value * 8192
                "Byte" -> value * 1024
                "MegaByte" -> value * 0.000_976_562
                "GigaByte" -> value * 0.000_000_953_7
                "TeraByte" -> value * 0.000_000_000_9
                else -> 0
            }
        }
        "MegaByte" -> {
            when (to) {
                "Bit" -> value * 8_388_608
                "Byte" -> value * 1_048_576
                "KiloByte" -> value * 1024
                "GigaByte" -> value * 0.000_976_562
                "TeraByte" -> value * 0.000_000_953_7
                else -> 0
            }
        }
        "GigaByte" -> {
            when (to) {
                "Bit" -> value * 8_589_934_592
                "Byte" -> value * 1_073_741_824
                "KiloByte" -> value * 1_048_576
                "MegaByte" -> value * 1024
                "TeraByte" -> value * 0.000_976_562
                else -> 0
            }
        }
        "TeraByte" -> {
            when (to) {
                "Bit" -> value * 8_796_093_022_208
                "Byte" -> value * 1_099_511_627_776
                "KiloByte" -> value * 1_073_741_824
                "MegaByte" -> value * 1_048_576
                "GigaByte" -> value * 1024
                else -> 0
            }
        }
        else -> 0
    }
}