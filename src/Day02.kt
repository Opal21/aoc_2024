import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val reports: List<List<Int>> = input.map { it.split(' ').map { number -> number.toInt() } }
        val reportSafetyList: MutableList<Boolean> = mutableListOf()

        for (report in reports) {
            reportSafetyList.add(isReportSafe(report))
        }

        return reportSafetyList.count { it }
    }

    fun part2(input: List<String>): Int {
        val reports = input.map { it.split(' ').map(String::toInt) } // Parse input into list of lists of integers
        val reportSafetyList = mutableListOf<Boolean>() // Stores the safety status of each report

        for (report in reports) {
            // Check if the original report is safe
            if (isReportSafe(report)) {
                reportSafetyList.add(true)
                continue
            }

            // If the original report is not safe, check all possible new reports
            var foundSafe = false
            for (index in report.indices) {
                // Create a new list with the element at `index` removed
                val newReport = report.filterIndexed { i, _ -> i != index }
                if (isReportSafe(newReport)) {
                    reportSafetyList.add(true)
                    foundSafe = true
                    break
                }
            }

            // If no safe newReport is found, mark the report as unsafe
            if (!foundSafe) {
                reportSafetyList.add(false)
            }
        }

        return reportSafetyList.count { it } // Count and return the number of safe reports
    }


    // Read a test input from the `src/Day02_test.txt` file:
    val testInput = readInput("Day02_test")
//    println(testInput)
    part1(testInput).println()
    part2(testInput).println()

    // Read the input from the `src/Day02.txt` file.
    val input = readInput("Day02")
    part1(input).println()
    part2(input).println()
}


fun isIncreasing(numbers: List<Int>): Boolean {
    return numbers.zipWithNext().all { (a, b) -> a <= b }
}

fun isDecreasing(numbers: List<Int>): Boolean {
    return numbers.zipWithNext().all { (a, b) -> a >= b }
}

fun isReportSafe(report: List<Int>): Boolean {
    val isReportIncreasing = isIncreasing(report)
    val isReportDecreasing = isDecreasing(report)

    return if (!isReportIncreasing && !isReportDecreasing) {
        false
    } else {
        report.zipWithNext().all { (a, b) -> abs(a - b) in 1..3 }
    }
}
