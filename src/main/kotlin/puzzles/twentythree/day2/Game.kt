package puzzles.twentythree.day2

class Game(input: String) {
    val gameId: Int = input.split(":").first().split(" ").last().toInt()

    val sets: List<Set> = input.split(":").last().split(";").map { Set(it) }
}
