fun main() {
    fun getAlphabetList(): List<Char> {
        val alphabetList = mutableListOf<Char>()

        var lowerChar = 'a'
        while (lowerChar <= 'z') {
            alphabetList.add(lowerChar)
            ++lowerChar
        }

        var capChar = 'A'
        while (capChar <= 'Z') {
            alphabetList.add(capChar)
            ++capChar
        }

        return alphabetList.toList()
    }

    fun part1(input: List<String>): Int {
        var totalSum = 0
        val alphabetList = getAlphabetList()
        var priority = 0
        val alphabetPriorityMap = mutableMapOf<String, Int>()

        alphabetList.forEach {
            alphabetPriorityMap.put(it.toString(), ++priority)
        }

        input.forEach {
            val halfPoint = it.length / 2
            val compartments = it.chunked(halfPoint)
            val compartmentOne = compartments[0]
            val compartmentTwo = compartments[1]
            val repeatedMap = mapOf<String, Int>()

            for (i in alphabetList) {
                if (compartmentOne.contains(i.toString()) && compartmentTwo.contains(i.toString())) {
                    totalSum += alphabetPriorityMap.get(i.toString()) ?: 0
                }
            }

            totalSum += repeatedMap.values.sum()
        }

        return totalSum
    }

    fun part2(input: List<String>): Int {
        var totalSum = 0
        val alphabetList = getAlphabetList()
        var priority = 0
        val alphabetPriorityMap = mutableMapOf<String, Int>()
        var counter = 0

        alphabetList.forEach {
            alphabetPriorityMap.put(it.toString(), ++priority)
        }

        while (counter < input.size - 2) {
            val compartmentOne = input[counter]
            val compartmentTwo = input[counter + 1]
            val compartmentThree = input[counter + 2]
            val repeatedMap = mapOf<String, Int>()

            for (i in alphabetList) {
                if (compartmentOne.contains(i.toString()) &&
                    compartmentTwo.contains(i.toString()) &&
                    compartmentThree.contains(i.toString())
                ) {
                    totalSum += alphabetPriorityMap.get(i.toString()) ?: 0
                }
            }

            totalSum += repeatedMap.values.sum()
            counter += 3
        }

        return totalSum
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day03Sample")
    //println(part1(testInput))
    //println(part2(testInput))

    val input = readInput("Day03")
    //println(part1(input))
    println(part2(input))
}