package medium

import main.Solution

class Solution221 : Solution() {
    override fun test() {
        val input = arrayOf(
            arrayOf(charArrayOf('1', '0', '1', '0', '0'), charArrayOf('1', '0', '1', '1', '1'), charArrayOf('1', '1', '1', '1', '1'), charArrayOf('1', '0', '0', '1', '0'))
        )
        input.forEach { println(maximalSquare(it)) }
    }

    fun maximalSquare(matrix: Array<CharArray>): Int {
        return if (matrix.isEmpty()) {
            0
        } else {
            val m = matrix.size
            val n = matrix.first().size
            var max = 0
            val dp = mutableMapOf<Pair<Int, Int>, Pair<Int, Int>>()
            (0 until m + n - 1).forEach { sum ->
                (0..sum).forEach { i ->
                    val j = sum - i
                    if (i < m && j < n && matrix[i][j] == '1') {
                        var x = i
                        var y = j
                        var left = 0
                        var up = 0
                        while (x > -1 && matrix[x][j] == '1') {
                            left++
                            x--
                        }
                        while (y > -1 && matrix[i][y] == '1') {
                            up++
                            y--
                        }
                        dp[Pair(i, j)] = Pair(left, up)
                        max = max.coerceAtLeast(1)

                        x = i - 1
                        while (x > -1 && matrix[x][j] == '1') {
                            up = up.coerceAtMost(dp[Pair(x, j)]!!.second)
                            if (i - x + 1 <= up) {
                                max = max.coerceAtLeast((i - x + 1) * (i - x + 1))
                            } else {
                                break
                            }
                            x--
                        }
                        y = j - 1
                        while (y > -1 && matrix[i][y] == '1') {
                            left = left.coerceAtMost(dp[Pair(i, y)]!!.first)
                            if (j - y + 1 <= left) {
                                max = max.coerceAtLeast((j - y + 1) * (j - y + 1))
                            } else {
                                break
                            }
                            y--
                        }
                    }
                }
            }
            max
        }
    }
}