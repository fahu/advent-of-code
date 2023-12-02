package puzzles.twentythree.day2

import common.readInput

class Day2Part2(private val puzzleInput: List<String>) {
    fun solve(): Int {
        return puzzleInput
            .map { Game(it) }
            .map {
                val red = it.sets.maxBy { set -> set.red }.red
                val green = it.sets.maxBy { set -> set.green }.green
                val blue = it.sets.maxBy { set -> set.blue }.blue

                red * green * blue
            }
            .sumOf { it }
    }
}

fun main() {
    println(Day2Part2("/day2/day2-part2.txt".readInput()).solve())
}
