fun main() {
    fun isDistinct(str: String) = str.toList().size == str.toList().toHashSet().size

    fun part1(input: List<String>): Int {
        val charList = input[0]
        var marker = 0
        var counter = 2
        var listStart = 0
        while (counter < charList.length) {
            val window = charList.substring(listStart, counter + 2)
            if (isDistinct(window)) {
                marker = counter + 2
                break
            } else {
                counter++
                listStart++
            }
        }

        return marker
    }

    fun part2(input: List<String>): Int {
        val charList = input[0]
        var marker = 0
        var counter = 12
        var listStart = 0
        while (counter < charList.length) {
            val window = charList.substring(listStart, counter + 2)
            if (isDistinct(window)) {
                marker = counter + 2
                break
            } else {
                counter++
                listStart++
            }
        }

        return marker
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day06Sample")
    //println(part1(testInput))
    //println(part2(testInput))

    val input = readInput("Day06")
    //println(part1(input))
    println(part2(input))
}