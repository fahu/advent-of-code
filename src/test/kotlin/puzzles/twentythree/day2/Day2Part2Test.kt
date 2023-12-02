package puzzles.twentythree.day2

import common.readInput
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Day2Part2Test {
    @Test
    fun `The example is correctly solved`() {
        val input = listOf(
            "Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green",
            "Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue",
            "Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red",
            "Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red",
            "Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green"
        )

        assertEquals(2286, Day2Part2(input).solve())
    }

    @Test
    fun `The real puzzle is correctly solved`() {
        assertEquals(70387, Day2Part1("/day2/day2-part2.txt".readInput()).solve())
    }
}
