package hard

import Solution

class Solution212 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(arrayOf(charArrayOf('o', 'a', 'a', 'n'), charArrayOf('e','t','a','e'), charArrayOf('i','h','k','r'), charArrayOf('i','f','l','v')), arrayOf("oath","pea","eat","rain"))
        )
        input.forEach { println(findWords(it.first, it.second)) }
    }

    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
        val m = board.size
        val n = board.first().size
        val result = mutableListOf<String>()
        words.forEach loop@{ word ->
            (0 until m).forEach { i ->
                (0 until n).forEach { j ->
                    if (helper(i, j, board, Array(m) { BooleanArray(n) { false } }, word)) {
                        result.add(word)
                        return@loop
                    }
                }
            }
        }
        return result
    }

    fun helper(i: Int, j: Int, board: Array<CharArray>, isVisited: Array<BooleanArray>, word: String): Boolean {
        return when {
            word.isEmpty() -> true
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
            else -> false
        }
    }
}