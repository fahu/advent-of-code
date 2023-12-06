package puzzles.twentythree.day4

import common.readInput

class Day4Part2(private val cards: List<String>) {
    fun solve(): Int {
        val cardStack = cards.toMutableList()
        val cardsToBeProcessed = cardStack.toMutableList()

        while (cardsToBeProcessed.isNotEmpty()) {
            val newCardsToBeProcessed = mutableListOf<String>()

            cardsToBeProcessed.forEach { card ->
                val cardId = card.split(":").first().split(" ").last().toInt()
                val cardNumbers = card.split(":").last().split("|")
                val winningNumbers = cardNumbers.first().split(" ").filter { it.isNotEmpty() }.map { it.toInt() }
                val ownedNumbers = cardNumbers.last().split(" ").filter { it.isNotEmpty() }.map { it.toInt() }

                ownedNumbers.filter { it in winningNumbers }.forEachIndexed { index, _ ->
                    val cardToAdd = cards.find { it.contains("${cardId + index + 1}:") }

                    if (cardToAdd != null) {
                        newCardsToBeProcessed.add(cardToAdd)
                        cardStack.add(cardToAdd)
                    }
                }
            }

            cardsToBeProcessed.clear()
            cardsToBeProcessed.addAll(newCardsToBeProcessed)
        }

        return cardStack.size
    }
}

fun main() {
    println(Day4Part2("/day4/day4-part2.txt".readInput()).solve())
}

