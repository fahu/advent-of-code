package puzzles.twentythree.day4

import common.readInput

class Day4Part1(private val puzzleInput: List<String>) {
    fun solve(): Int {
        return this.puzzleInput
            .sumOf { card ->
                val cardNumbers = card
                    .split(":").last()
                    .split("|")

                val winningNumbers = cardNumbers
                    .first()
                    .split(" ")
                    .filter { it.isNotEmpty() }
                    .map { it.toInt() }

                val ownedNumbers = cardNumbers
                    .last()
                    .split(" ")
                    .filter { it.isNotEmpty() }
                    .map { it.toInt() }

                var score = 0
                repeat(
                    ownedNumbers
                        .filter { it in winningNumbers }
                        .size
                ) {
                    if (score == 0) {
                        score = 1
                    } else {
                        score *= 2
                    }
                }

                score
            }
    }
}

fun main() {
    println(Day4Part1("/day4/day4-part1.txt".readInput()).solve())
}

