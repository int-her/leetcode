package medium

import Solution

class Solution79 : Solution() {
    override fun test() {
        val board = arrayOf(
            charArrayOf('A', 'B', 'C', 'E'),
            charArrayOf('S', 'F', 'C', 'S'),
            charArrayOf('A', 'D', 'E', 'E')
        )
        val words = listOf("ABCCED", "SEE", "ABCB")
        words.forEach { println(exist(board, it)) }
        println(exist(arrayOf(charArrayOf('A')), "A"))
        board[1][2] = 'E'
        println(exist(board, "ABCESEEEFS"))
    }

    fun exist(board: Array<CharArray>, word: String): Boolean {
        val m = board.size
        val n = board.first().size
        return if (word.isEmpty()) {
            true
        } else {
            (0 until m).forEach { i ->
                (0 until n).forEach { j ->
                    if (helper(i, j, board, Array(m) { BooleanArray(n) { false } }, word)) {
                        return true
                    }
                }
            }
            false
        }
    }

    fun helper(i: Int, j: Int, board: Array<CharArray>, isVisited: Array<BooleanArray>, word: String): Boolean {
        return when {
            board[i][j] == word.first() -> {
                isVisited[i][j] = true
                val nextWord = word.substring(1)
                val result = nextWord.isEmpty() ||
                        (if (i > 0 && !isVisited[i - 1][j]) helper(i - 1, j, board, isVisited, nextWord) else false) ||
                        (if (i < board.size - 1 && !isVisited[i + 1][j]) helper(i + 1, j, board, isVisited, nextWord) else false) ||
                        (if (j > 0 && !isVisited[i][j - 1]) helper(i, j - 1, board, isVisited, nextWord) else false) ||
                        (if (j < board.first().size - 1 && !isVisited[i][j + 1]) helper(i, j + 1, board, isVisited, nextWord) else false)
                isVisited[i][j] = false
                result
            }
            else -> {
                false
            }
        }
    }
}