fun main() {
    fun part1(input: List<String>): Int {
        var mostCalories = 0
        var calorieCount = 0
        for (i in input) {
            if (i.isNotEmpty()) {
                calorieCount += i.toInt()
            } else {
                if (calorieCount > mostCalories) {
                    mostCalories = calorieCount
                    calorieCount = 0
                } else {
                    calorieCount = 0
                }
            }
        }
        return mostCalories
    }

    fun part2(input: List<String>): Int {
        val calorieList = mutableListOf<Int>()
        var calorieCount = 0

        for (i in input.indices) {
            if (input[i].isNotEmpty()) {
                calorieCount += input[i].toInt()
                if (i == input.size - 1) {
                    calorieList.add(calorieCount)
                }
            }  else {
                calorieList.add(calorieCount)
                calorieCount = 0
            }
        }

        calorieList.sort()
        val lastThree = calorieList.takeLast(3)
        return lastThree.sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01Sample")
    //println(part1(testInput))
    //println(part2(testInput))

    val input = readInput("Day01")
    //println("RUNNING PART 1")
    //println(part1(input))
    println("RUNNING PART 2")
    println(part2(input))
}
