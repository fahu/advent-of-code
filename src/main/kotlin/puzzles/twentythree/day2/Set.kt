package puzzles.twentythree.day2

data class Set(val setInformation: String) {
    val red: Int
    val green: Int
    val blue: Int

    init {
        val colors = setInformation.split(",")
        red = colors.filter { it.contains("red") }.sumOf { it.split(" ")[1].toInt() }
        green = colors.filter { it.contains("green") }.sumOf { it.split(" ")[1].toInt() }
        blue = colors.filter { it.contains("blue") }.sumOf { it.split(" ")[1].toInt() }
    }
}
