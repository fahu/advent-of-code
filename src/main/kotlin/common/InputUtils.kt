package common

import java.nio.file.Path
import kotlin.io.path.bufferedReader

fun String.readInput(): List<String> {
    return Path.of("src/main/resources", this)
        .bufferedReader()
        .readLines()
}
