package puzzles.twentythree.day3

import common.readInput

class Day3Part1(private val puzzleInput: List<String>) {
    fun solve(): Int {
        val partNumbers = mutableListOf(0)

        puzzleInput.forEachIndexed() { rowIndex, line ->
            var foundNumber = ""
            // apparently any number adjacent to a symbol, even diagonally, is a "part number"
            var isPartNumber = false

            line.forEachIndexed() { columnIndex, char ->
                if (!char.isDigit() && !isPartNumber) {
                    foundNumber = ""
                }
                if (!char.isDigit() && isPartNumber) {
                    isPartNumber = false
                    println("Found part number: $foundNumber")
                    partNumbers.add(foundNumber.toInt())
                    foundNumber = ""
                }
                if (char.isDigit()) {
                    foundNumber += char.toString().toInt()

                    if (puzzleInput.isNextToSymbol(rowIndex, columnIndex)) {
                        isPartNumber = true
                    }
                }
            }

            // end of row
            if (isPartNumber) {
                isPartNumber = false
                println("Found part number: $foundNumber")
                partNumbers.add(foundNumber.toInt())
                foundNumber = ""
            }
        }

        return partNumbers.sum()
    }
}

private fun List<String>.isNextToSymbol(positionX: Int, positionY: Int): Boolean {
    if (this.getOrNull(positionX - 1)?.getOrNull(positionY - 1)?.isSymbol() == true) {
        return true
    }

    if (this.getOrNull(positionX - 1)?.getOrNull(positionY)?.isSymbol() == true) {
        return true
    }

    if (this.getOrNull(positionX - 1)?.getOrNull(positionY + 1)?.isSymbol() == true) {
        return true
    }

    if (this.getOrNull(positionX)?.getOrNull(positionY - 1)?.isSymbol() == true) {
        return true
    }

    if (this.getOrNull(positionX)?.getOrNull(positionY + 1)?.isSymbol() == true) {
        return true
    }

    if (this.getOrNull(positionX + 1)?.getOrNull(positionY - 1)?.isSymbol() == true) {
        return true
    }

    if (this.getOrNull(positionX + 1)?.getOrNull(positionY)?.isSymbol() == true) {
        return true
    }

    if (this.getOrNull(positionX + 1)?.getOrNull(positionY + 1)?.isSymbol() == true) {
        return true
    }

    return false
}

private fun Char.isSymbol(): Boolean {
    if (this.isDigit()) {
        return false
    }

    if (this == '.') {
        return false
    }

    return true
}

fun main() {
    println(Day3Part1("/day3/day3-part1.txt".readInput()).solve())
}

