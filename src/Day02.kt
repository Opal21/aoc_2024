fun main() {
    fun part1(input: List<String>): Int {
        val reports: List<List<Int>> = input.map { it.split(' ') }
        val isReportSafe: MutableList<Boolean>

        for (report in reports) {

        }

        return input.size
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    // Or read a test input from the `src/Day02_test.txt` file:
    val testInput = readInput("Day02_test")
    println(testInput)
    part1(testInput).println()
//    part2(testInput).println()

    // Read the input from the `src/Day02.txt` file.
    val input = readInput("Day02")
//    part1(input).println()
//    part2(input).println()
}
