fun main() {
    fun IntRange.containsAll(valueList: List<Int>) = valueList.all { value ->
        this.contains(value)
    }

    fun IntRange.containsAny(valueList: List<Int>) = valueList.any { value ->
        this.contains(value)
    }

    fun part1(input: List<String>): Int {
        var overlapCount = 0

        input.forEach {
            val assignments = it.split(",")
            val assignmentOne = assignments[0]
            val assignmentTwo = assignments[1]
            val assignmentOneRanges = assignmentOne.split("-")
            val assignmentTwoRanges = assignmentTwo.split("-")

            val rangeOne = assignmentOneRanges[0].toInt() ..assignmentOneRanges[1].toInt()
            val rangeTwo = assignmentTwoRanges[0].toInt()..assignmentTwoRanges[1].toInt()

            if (rangeOne.containsAll(rangeTwo.toList()) || rangeTwo.containsAll(rangeOne.toList())) {
                overlapCount++
            }
        }

        return overlapCount
    }

    fun part2(input: List<String>): Int {
        var overlapCount = 0

        input.forEach {
            val assignments = it.split(",")
            val assignmentOne = assignments[0]
            val assignmentTwo = assignments[1]
            val assignmentOneRanges = assignmentOne.split("-")
            val assignmentTwoRanges = assignmentTwo.split("-")

            val rangeOne = assignmentOneRanges[0].toInt() ..assignmentOneRanges[1].toInt()
            val rangeTwo = assignmentTwoRanges[0].toInt()..assignmentTwoRanges[1].toInt()

            if (rangeOne.containsAny(rangeTwo.toList()) || rangeTwo.containsAny(rangeOne.toList())) {
                overlapCount++
            }
        }

        return overlapCount
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day04Sample")
    //println(part1(testInput))
    //println(part2(testInput))

    val input = readInput("Day04")
    //println(part1(input))
    println(part2(input))
}