package puzzles.twentythree.day3

import common.readInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day3Part1Test {

    @Test
    fun `The example is correctly solved`() {
        val input = listOf(
            "467..114..",
            "...*......",
            "..35..633.",
            "......#...",
            "617*......",
            ".....+.58.",
            "..592.....",
            "......755.",
            "...$.*....",
            ".664.598..",
        )

        assertEquals(4361, Day3Part1(input).solve())
    }

    @Test
    fun `The real puzzle is correctly solved`() {
        assertEquals(514969, Day3Part1("/day3/day3-part1.txt".readInput()).solve())
    }
}
