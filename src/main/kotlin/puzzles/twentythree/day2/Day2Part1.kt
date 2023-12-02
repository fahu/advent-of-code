package puzzles.twentythree.day2

import common.readInput

class Day2Part1(private val puzzleInput: List<String>) {
    fun solve(): Int {
        return puzzleInput
            .map { Game(it) }
            .filter {
                it.sets.all { set -> set.red <= 12 && set.green <= 13 && set.blue <= 14 }
            }.sumOf { it.gameId }
    }
}

fun main() {
    println(Day2Part1("/day2/day2-part1.txt".readInput()).solve())
}
