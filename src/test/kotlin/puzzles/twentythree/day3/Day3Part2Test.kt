package puzzles.twentythree.day3

import common.readInput
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Day3Part2Test {
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

        assertEquals(467835, Day3Part2(input).solve())
    }

    @Test
    fun `The real puzzle is correctly solved`() {
        assertEquals(78915902, Day3Part2("/day3/day3-part2.txt".readInput()).solve())
    }
}

