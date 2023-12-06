package puzzles.twentythree.day3

import common.readInput

class Day3Part2(private val puzzleInput: List<String>) {
    fun solve(): Int {
        val partNumbers = mutableListOf(0)
        val symbols = mutableMapOf<Pair<Int, Int>, MutableSet<Int>>()

        puzzleInput.forEachIndexed() { rowIndex, line ->
            var foundNumber = ""
            // apparently any number adjacent to a symbol, even diagonally, is a "part number"
            var isPartNumber = false
            var foundNearbySymbols = mutableSetOf<Pair<Int, Int>>()

            line.forEachIndexed() { columnIndex, char ->
                if (!char.isDigit() && !isPartNumber) {
                    foundNumber = ""
                }
                if (!char.isDigit() && isPartNumber) {
                    foundNearbySymbols.forEach {
                        symbols[it] = symbols.getOrDefault(it, mutableSetOf()).apply { add(foundNumber.toInt()) }
                    }

                    isPartNumber = false
                    partNumbers.add(foundNumber.toInt())
                    foundNumber = ""


                    foundNearbySymbols = mutableSetOf()
                }
                if (char.isDigit()) {
                    foundNumber += char.toString().toInt()
                    val nearbySymbols = puzzleInput.findNearbyGearSymbol(rowIndex, columnIndex)

                    if (nearbySymbols.isNotEmpty()) {
                        isPartNumber = true
                        foundNearbySymbols.addAll(nearbySymbols)
                    }
                }
            }

            // end of row
            if (isPartNumber) {
                foundNearbySymbols.forEach {
                    symbols[it] = symbols.getOrDefault(it, mutableSetOf()).apply { add(foundNumber.toInt()) }
                }

                isPartNumber = false
                partNumbers.add(foundNumber.toInt())
                foundNumber = ""
            }
        }

        return symbols.filter { it.value.size == 2 }.map { it.value.reduce { acc, i -> acc * i } }.sumOf { it }
    }
}

private fun List<String>.findNearbyGearSymbol(positionX: Int, positionY: Int): Set<Pair<Int, Int>> {
    val closeSymbols = mutableSetOf<Pair<Int, Int>>()

    if (this.getOrNull(positionX - 1)?.getOrNull(positionY - 1) == '*') {
        closeSymbols.add(Pair(positionX - 1, positionY - 1))
    }

    if (this.getOrNull(positionX - 1)?.getOrNull(positionY) == '*') {
        closeSymbols.add(Pair(positionX - 1, positionY))
    }

    if (this.getOrNull(positionX - 1)?.getOrNull(positionY + 1) == '*') {
        closeSymbols.add(Pair(positionX - 1, positionY + 1))
    }

    if (this.getOrNull(positionX)?.getOrNull(positionY - 1) == '*') {
        closeSymbols.add(Pair(positionX, positionY - 1))
    }

    if (this.getOrNull(positionX)?.getOrNull(positionY + 1) == '*') {
        closeSymbols.add(Pair(positionX, positionY + 1))
    }

    if (this.getOrNull(positionX + 1)?.getOrNull(positionY - 1) == '*') {
        closeSymbols.add(Pair(positionX + 1, positionY - 1))
    }

    if (this.getOrNull(positionX + 1)?.getOrNull(positionY) == '*') {
        closeSymbols.add(Pair(positionX + 1, positionY))
    }

    if (this.getOrNull(positionX + 1)?.getOrNull(positionY + 1) == '*') {
        closeSymbols.add(Pair(positionX + 1, positionY + 1))
    }

    return closeSymbols
}

fun main() {
    println(Day3Part2("/day3/day3-part2.txt".readInput()).solve())
}

