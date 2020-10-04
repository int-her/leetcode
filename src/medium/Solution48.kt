package medium

import main.Solution

class Solution48 : Solution() {
    override fun test() {
        val input1 = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
        rotate(input1)
        println(input1.joinToString(separator = "/") { it.joinToString() })
        val input2 = arrayOf(intArrayOf(5, 1, 9, 11), intArrayOf(2, 4, 8, 10), intArrayOf(13, 3, 6, 7), intArrayOf(15, 14, 12, 16))
        rotate(input2)
        println(input2.joinToString(separator = "/") { it.joinToString() })
        val input3 = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        rotate(input3)
        println(input3.joinToString(separator = "/") { it.joinToString() })
    }

    fun rotate(matrix: Array<IntArray>): Unit {
        (0 until (matrix.size / 2)).forEach { step ->
            (0 until (matrix.size - 1 - step * 2)).forEach {
                val temp = matrix[matrix.size - step - it - 1][matrix.size - step - 1]
                matrix[matrix.size - step - it - 1][matrix.size - step - 1] = matrix[step][matrix.size - step - it  - 1]
                matrix[step][matrix.size - step - it  - 1] = matrix[step + it][step]
                matrix[step + it][step] = matrix[matrix.size - step - 1][step + it]
                matrix[matrix.size - step - 1][step + it] = temp
            }
        }
    }
}