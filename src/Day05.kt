import java.lang.StringBuilder

fun main() {
    fun executeMoves(
        numToMove: Int, stackToMoveFrom: Int, stackToMoveTo: Int, map: MutableMap<Int, MutableList<String>>
    ) {
        for (i in 0 until numToMove) {
            val valueToMove = map[stackToMoveFrom]!!.last()
            map.getOrPut(stackToMoveFrom, ::mutableListOf).removeLast()
            map.getOrPut(stackToMoveTo, ::mutableListOf).add(valueToMove)
        }
    }

    fun part1(input: List<String>): String {
        val blankLineIndex: Int
        val commandsList = mutableListOf<String>()
        val stackMap = mutableMapOf<Int, MutableList<String>>()

        for (i in input.indices) {
            if (input[i].isEmpty()) {
                blankLineIndex = i
                commandsList.addAll(input.takeLast(input.size - blankLineIndex - 1))
                val stackLines = input.take(blankLineIndex - 1)
                val regex = Regex("[^A-Za-z0-9 ]")

                for (n in stackLines.size - 1 downTo 0) {
                    val stackLine = regex.replace(stackLines[n], "")
                    var currentStack = 1
                    var spaceCounter = 0
                    for (m in stackLine.indices) {
                        if (stackLine[m] == ' ' && spaceCounter == 0) {
                            currentStack++
                            spaceCounter++
                        } else if (stackLine[m] == ' ' && (spaceCounter in 1..3)) {
                            spaceCounter++
                        } else if (stackLine[m] == ' ' && spaceCounter >= 4) {
                            currentStack++
                            spaceCounter = 1
                        } else if (stackLine[m] != ' ') {
                            stackMap.getOrPut(currentStack, ::mutableListOf).add(stackLine[m].toString())
                            spaceCounter = 0
                        } else {
                            spaceCounter++
                        }
                    }
                }
                break
            }
        }

        for (i in commandsList) {
            val str = i.substringAfter("move ")
            val numMoves = str.substringBefore(" from").toInt()
            val moveFrom = str.substringAfter(" from ").substringBefore(" to").toInt()
            val moveTo = str.substringAfter("to ").toInt()
            executeMoves(numMoves, moveFrom, moveTo, stackMap)
        }

        val finalStacks = stackMap.values.toList()
        val finalString = StringBuilder()
        finalStacks.forEach {
            finalString.append(it.last())
        }
        return finalString.toString()
    }

    fun executeMovesPart2(
        numToMove: Int, stackToMoveFrom: Int, stackToMoveTo: Int, map: MutableMap<Int, MutableList<String>>
    ) {
        if (numToMove == 1) {
            val valueToMove = map[stackToMoveFrom]!!.last()
            map.getOrPut(stackToMoveFrom, ::mutableListOf).removeLast()
            map.getOrPut(stackToMoveTo, ::mutableListOf).add(valueToMove)
        } else {
            for (i in 0 until numToMove) {
                val indexToRemove = map[stackToMoveFrom]!!.size - numToMove + i
                val valueToMove = map[stackToMoveFrom]!!.get(indexToRemove)
                map.getOrPut(stackToMoveFrom, ::mutableListOf).removeAt(indexToRemove)
                map.getOrPut(stackToMoveTo, ::mutableListOf).add(valueToMove)
            }
        }
    }

    fun part2(input: List<String>): String {
        val blankLineIndex: Int
        val commandsList = mutableListOf<String>()
        val stackMap = mutableMapOf<Int, MutableList<String>>()

        for (i in input.indices) {
            if (input[i].isEmpty()) {
                blankLineIndex = i
                commandsList.addAll(input.takeLast(input.size - blankLineIndex - 1))
                val stackLines = input.take(blankLineIndex - 1)
                val regex = Regex("[^A-Za-z0-9 ]")

                for (n in stackLines.size - 1 downTo 0) {
                    val stackLine = regex.replace(stackLines[n], "")
                    var currentStack = 1
                    var spaceCounter = 0
                    for (m in stackLine.indices) {
                        if (stackLine[m] == ' ' && spaceCounter == 0) {
                            currentStack++
                            spaceCounter++
                        } else if (stackLine[m] == ' ' && (spaceCounter in 1..3)) {
                            spaceCounter++
                        } else if (stackLine[m] == ' ' && spaceCounter >= 4) {
                            currentStack++
                            spaceCounter = 1
                        } else if (stackLine[m] != ' ') {
                            stackMap.getOrPut(currentStack, ::mutableListOf).add(stackLine[m].toString())
                            spaceCounter = 0
                        } else {
                            spaceCounter++
                        }
                    }
                }
                break
            }
        }

        for (i in commandsList) {
            val str = i.substringAfter("move ")
            val numMoves = str.substringBefore(" from").toInt()
            val moveFrom = str.substringAfter(" from ").substringBefore(" to").toInt()
            val moveTo = str.substringAfter("to ").toInt()
            executeMovesPart2(numMoves, moveFrom, moveTo, stackMap)
        }

        val finalStacks = stackMap.values.toList()
        val finalString = StringBuilder()


        finalStacks.forEach {
            if (it.isNotEmpty()) {
                finalString.append(it.last())
            }
        }


        return finalString.toString()
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day05Sample")
    //println(part1(testInput))
    //println(part2(testInput))

    val input = readInput("Day05")
    //println(part1(input))
    println(part2(input))
}