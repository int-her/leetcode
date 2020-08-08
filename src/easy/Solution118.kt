package easy

import Solution

class Solution118 : Solution() {
    override fun test() {
        val input = arrayOf(
            0, 1, 2, 3, 4, 5, 6
        )
        input.forEach { println(generate(it)) }
    }

    fun generate(numRows: Int): List<List<Int>> {
        return when (numRows) {
            0 -> emptyList()
            1 -> listOf(listOf(1))
            2 -> listOf(listOf(1), listOf(1, 1))
            else -> {
                val result = mutableListOf(listOf(1), listOf(1, 1))
                (3..numRows).forEach { i ->
                    val subList = mutableListOf(1)
                    (1..i - 2).forEach { j ->
                        subList.add(result[i - 2][j - 1] + result[i - 2][j])
                    }
                    subList.add(1)
                    result.add(subList)
                }
                result
            }
        }
    }
}