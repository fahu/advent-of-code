package puzzles.twentythree.day1

import common.readInput

fun main() {
    println(Day1Part2().solve())
}

class Day1Part2 {
    fun solve(): Int {
        return "/day1/day1-part1.txt".readInput().map {
            var digits = ""

            for (i in it.indices) {
                if (it[i].isDigit()) {
                    digits += it[i]
                }

                if (it.substring(i).indexOf("one") == 0) {
                    digits += "1"
                }

                if (it.substring(i).indexOf("two") == 0) {
                    digits += "2"
                }

                if (it.substring(i).indexOf("three") == 0) {
                    digits += "3"
                }

                if (it.substring(i).indexOf("four") == 0) {
                    digits += "4"
                }

                if (it.substring(i).indexOf("five") == 0) {
                    digits += "5"
                }

                if (it.substring(i).indexOf("six") == 0) {
                    digits += "6"
                }

                if (it.substring(i).indexOf("seven") == 0) {
                    digits += "7"
                }

                if (it.substring(i).indexOf("eight") == 0) {
                    digits += "8"
                }

                if (it.substring(i).indexOf("nine") == 0) {
                    digits += "9"
                }
            }

            digits
        }.sumOf {
            "${it.first()}${it.last()}".toInt()
        }
    }
}
