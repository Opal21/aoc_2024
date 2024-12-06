import kotlin.math.abs

fun main() {

    fun prepareList(input: List<String>): Pair<MutableList<Int>, MutableList<Int>> {
        val list1: MutableList<Int> = mutableListOf()
        val list2: MutableList<Int> = mutableListOf()

        for (line in input) {
            val num1 = line.split(' ').first()
            val num2 = line.split(' ').last()

            list1.add(num1.toInt())
            list2.add(num2.toInt())
        }

        list1.sort()
        list2.sort()

        return Pair(list1, list2)
    }

    fun part1(input: List<String>): Int {
        val (list1, list2) = prepareList(input)

        var totalDistance = 0

        for (i in list1.indices) {
            totalDistance += abs(list1[i] - list2[i])
        }

        return totalDistance
    }

    fun part2(input: List<String>): Int {
        val (list1, list2) = prepareList(input)

        var similarityScore = 0

        for (num1 in list1) {
            var repetitions = 0
            for (num2 in list2) {
                if (num1 == num2) {
                    repetitions++
                }
            }
            similarityScore += repetitions  * num1
        }

        return similarityScore
    }


    // Or read a test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
//    println(testInput)
//    part1(testInput).println()
    part2(testInput).println()

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
//    part1(input).println()
    part2(input).println()
}
