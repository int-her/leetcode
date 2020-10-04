package medium

import main.Solution

class Solution73 : Solution() {
    override fun test() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // Follow up: Could you devise a constant space solution?
    fun setZeroes(matrix: Array<IntArray>): Unit {
        var isFirstColumnZero = matrix[0][0] == 0
        if (matrix.isNotEmpty() && matrix.first().isNotEmpty()) {
            matrix.indices.forEach { i ->
                if (matrix[i][0] == 0) {
                    isFirstColumnZero = true
                }
                (1 until matrix[i].size).forEach { j ->
                    if (matrix[i][j] == 0) {
                        matrix[i][0] = 0
                        matrix[0][j] = 0
                    }
                }
            }

            (1 until matrix.size).forEach { i ->
                if (matrix[i][0] == 0) {
                    matrix[i].indices.forEach { j -> matrix[i][j] = 0 }
                }
            }
            (1 until matrix.first().size).forEach { j ->
                if (matrix[0][j] == 0) {
                    matrix.indices.forEach { i -> matrix[i][j] = 0 }
                }
            }
            if (matrix[0][0] == 0) {
                matrix[0].indices.forEach { j -> matrix[0][j] = 0 }
            }
            if (isFirstColumnZero) {
                matrix.indices.forEach { i -> matrix[i][0] = 0 }
            }
        }
    }
}