package hard

import main.Solution

class Solution37 : Solution() {
    override fun test() {
        val input = arrayOf(
            arrayOf(
                charArrayOf('5','3','.','.','7','.','.','.','.'),
                charArrayOf('6','.','.','1','9','5','.','.','.'),
                charArrayOf('.','9','8','.','.','.','.','6','.'),
                charArrayOf('8','.','.','.','6','.','.','.','3'),
                charArrayOf('4','.','.','8','.','3','.','.','1'),
                charArrayOf('7','.','.','.','2','.','.','.','6'),
                charArrayOf('.','6','.','.','.','.','2','8','.'),
                charArrayOf('.','.','.','4','1','9','.','.','5'),
                charArrayOf('.','.','.','.','8','.','.','7','9')
            ),
            arrayOf(
                charArrayOf('.','.','.','.','.','.','.','.','.'),
                charArrayOf('.','.','.','.','.','.','.','.','.'),
                charArrayOf('.','.','.','.','.','.','.','.','.'),
                charArrayOf('.','.','.','.','.','.','.','.','.'),
                charArrayOf('.','.','.','.','.','.','.','.','.'),
                charArrayOf('.','.','.','.','.','.','.','.','.'),
                charArrayOf('.','.','.','.','.','.','.','.','.'),
                charArrayOf('.','.','.','.','.','.','.','.','.'),
                charArrayOf('.','.','.','.','.','.','.','.','.')
            )
        )
        input.forEach {
            solveSudoku(it)
            println(it.joinToString { itt -> itt.joinToString() })
        }
    }

    fun solveSudoku(board: Array<CharArray>): Unit {
        val rows = IntArray(9) { 0 }
        val cols = IntArray(9) { 0 }
        val squares = IntArray(9) { 0 }
        val rest = IntArray(1) { 0 }
        board.forEachIndexed { i, row ->
            row.forEachIndexed { j, char ->
                if (char != '.') {
                    val value = 1.shl(char - '1')
                    rows[i] = rows[i].or(value)
                    cols[j] = cols[j].or(value)
                    squares[i / 3 * 3 + j / 3] = squares[i / 3 * 3 + j / 3].or(value)
                } else {
                    rest[0]++
                }
            }
        }
        helper(board, rows, cols, squares, rest)
    }

    fun helper(board: Array<CharArray>, rows: IntArray, cols: IntArray, squares: IntArray, rest: IntArray): Boolean {
        return if (rest[0] == 0) {
            true
        } else {
            val (i, j) = board.indexOfFirst { row -> row.any { char -> char == '.' } }.let { i -> Pair(i, board[i].indexOfFirst { char -> char == '.' }) }
            val candidates = 511.xor(rows[i].or(cols[j]).or(squares[i / 3 * 3 + j / 3])).toString(2).reversed().mapIndexedNotNull { index, c -> if (c == '0') null else index + 1 }
            candidates.forEach {
                val value = 1.shl(it - 1)
                board[i][j] = '0' + it
                rows[i] = rows[i].or(value)
                cols[j] = cols[j].or(value)
                squares[i / 3 * 3 + j / 3] = squares[i / 3 * 3 + j / 3].or(value)
                rest[0]--
                if (helper(board, rows, cols, squares, rest)) {
                    return true
                } else {
                    board[i][j] = '.'
                    rows[i] -= value
                    cols[j] -= value
                    squares[i / 3 * 3 + j / 3] -= value
                    rest[0]++
                }
            }
            return false
        }
    }
}