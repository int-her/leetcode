package medium

import Solution

class Solution54 : Solution() {
    override fun test() {
        val input = arrayOf(
            arrayOf(),
            arrayOf(intArrayOf()),
            arrayOf(intArrayOf(1)),
            arrayOf(intArrayOf(1, 2, 3, 4)),
            arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9)),
            arrayOf(intArrayOf(1, 2, 3, 4), intArrayOf(5, 6, 7, 8), intArrayOf(9, 10, 11, 12))
        )
        input.forEach { println(spiralOrder(it)) }
    }

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        return helper(0, 0, matrix)
    }

    fun helper(i: Int, j: Int, matrix: Array<IntArray>): List<Int> {
        return if (matrix.isEmpty() || matrix.first().isEmpty()) {
            emptyList()
        } else if (i * 2 >= matrix.size || j * 2 >= matrix.first().size) {
            emptyList()
        } else if (i * 2 + 1 == matrix.size) {
            matrix[i].copyOfRange(i, matrix[i].size - i).toList()
        } else if (j * 2 + 1 == matrix.first().size) {
            matrix.copyOfRange(j, matrix.size - j).map { it[j] }.toList()
        } else {
            matrix[i].copyOfRange(i, matrix[i].lastIndex - i).toList() +
                    matrix.copyOfRange(i, matrix.lastIndex - i).map { it[matrix[i].lastIndex - i] }.toList() +
                    matrix[matrix.lastIndex - i].copyOfRange(i + 1, matrix[i].size - i).reversed() +
                    matrix.copyOfRange(i + 1, matrix.size - i).map { it[i] }.reversed() +
                    helper(i + 1, j + 1, matrix)
        }
    }
}