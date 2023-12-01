package puzzles.twentythree.day1

import common.readInput

fun main() {
    println(Day1Part1().solve())
}

class Day1Part1 {
    fun solve(): Int {
        return "/day1/day1-part1.txt"
            .readInput()
            .map {
                it.filter { c -> c.isDigit() }
            }
            .sumOf { numbersOnly -> "${numbersOnly.first()}${numbersOnly.last()}".toInt() }
    }
}

