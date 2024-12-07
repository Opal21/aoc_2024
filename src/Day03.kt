fun main() {
    fun part1(input: List<String>): Int {
        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Read a test input from the `src/Day03_test.txt` file:
    val testInput = readInput("Day03_test")
    println(testInput)
    part1(testInput).println()
    part2(testInput).println()

    // Read the input from the `src/Day03.txt` file.
    val input = readInput("Day03")
    part1(input).println()
    part2(input).println()
}
