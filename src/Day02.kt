fun main() {
    fun part1(input: List<String>): Int {
        val firstRowMap = mapOf("A" to "rock", "B" to "paper", "C" to "scissors")
        val secondRowMap = mapOf("X" to "rock", "Y" to "paper", "Z" to "scissors")
        val winningMap = mapOf("scissors" to "rock", "rock" to "paper", "paper" to "scissors")
        val pointsMap = mapOf("win" to 6, "lose" to 0, "draw" to 3, "X" to 1, "Y" to 2, "Z" to 3)
        var totalScore = 0

        for (i in input) {
            val handOne = i[0].toString()
            val handTwo = i[2].toString()

            if (firstRowMap[handOne] == secondRowMap[handTwo]) {
                totalScore += pointsMap["draw"]!! + pointsMap[handTwo]!!
            } else if (winningMap[firstRowMap[handOne]!!] == secondRowMap[handTwo]) {
                totalScore += pointsMap["win"]!! + pointsMap[handTwo]!!
            } else {
                totalScore += pointsMap[handTwo]!!
            }
        }

        return totalScore
    }

    fun part2(input: List<String>): Int {
        val outcomeMap = mapOf("X" to "lose", "Y" to "draw", "Z" to "win")
        val firstRowMap = mapOf("A" to "rock", "B" to "paper", "C" to "scissors")
        val secondRowMap = mapOf("X" to "rock", "Y" to "paper", "Z" to "scissors")
        val oppositeSecondRowMap = mapOf("rock" to "X", "paper" to "Y", "scissors" to "Z")
        val winningMap = mapOf("scissors" to "rock", "rock" to "paper", "paper" to "scissors")
        val oppositeWinningMap = mapOf("rock" to "scissors", "paper" to "rock", "scissors" to "paper")
        val pointsMap = mapOf("win" to 6, "lose" to 0, "draw" to 3, "X" to 1, "Y" to 2, "Z" to 3)


        var totalScore = 0

        for (i in input) {
            val handOne = i[0].toString()
            val handTwo = i[2].toString()
            var realHandTwo = ""

            if (outcomeMap[handTwo] == "win") {
                realHandTwo = oppositeSecondRowMap[winningMap[firstRowMap[handOne]!!]!!]!!
            } else if (outcomeMap[handTwo] == "draw") {
                realHandTwo = oppositeSecondRowMap[firstRowMap[handOne]!!]!!
            } else {
                realHandTwo = oppositeSecondRowMap[oppositeWinningMap[firstRowMap[handOne]!!]!!]!!
            }

            if (firstRowMap[handOne] == secondRowMap[realHandTwo]) {
                totalScore += pointsMap["draw"]!! + pointsMap[realHandTwo]!!
            } else if (winningMap[firstRowMap[handOne]!!] == secondRowMap[realHandTwo]) {
                totalScore += pointsMap["win"]!! + pointsMap[realHandTwo]!!
            } else {
                totalScore += pointsMap[realHandTwo]!!
            }
        }

        return totalScore
    }


    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day02Sample")
    //println(part1(testInput))

    val input = readInput("Day02")
    //println(part1(input))
    println(part2(input))
}