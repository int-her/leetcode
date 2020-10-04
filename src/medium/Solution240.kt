package medium

import main.Solution

class Solution240 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(arrayOf(intArrayOf(1, 4, 7, 11, 15), intArrayOf(2, 5, 8, 12, 19), intArrayOf(3, 6, 9, 16, 22), intArrayOf(10, 13, 14, 17, 24), intArrayOf(18, 21, 23, 26, 30)), 5),
            Pair(arrayOf(intArrayOf(1, 4, 7, 11, 15), intArrayOf(2, 5, 8, 12, 19), intArrayOf(3, 6, 9, 16, 22), intArrayOf(10, 13, 14, 17, 24), intArrayOf(18, 21, 23, 26, 30)), 20),
            Pair(arrayOf(intArrayOf(-1, 3)), 3)
        )
        input.forEach { println(searchMatrix(it.first, it.second)) }
    }

    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        return if (matrix.isEmpty() || matrix.first().isEmpty()) {
            false
        } else {
            val n = matrix.first().size
            var x = matrix.map { it.first() }.binarySearch(target)
            if (x >= 0) {
                true
            } else {
                x = -x - 2
                var y = 0
                while (x >= 0 && y < n) {
                    y = matrix[x].binarySearch(target, y)
                    if (y >= 0) {
                        return true
                    } else {
                        y = -y - 1
                    }
                    x--
                }
                false
            }
        }
    }
}