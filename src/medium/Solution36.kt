package medium

import Solution
import kotlin.math.pow

class Solution36 : Solution() {
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
                charArrayOf('8','3','.','.','7','.','.','.','.'),
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
        input.forEach { println(isValidSudoku(it)) }
    }

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = IntArray(9) { 0 }
        val cols = IntArray(9) { 0 }
        val squares = IntArray(9) { 0 }
        board.forEachIndexed { i, row ->
            row.forEachIndexed { j, char ->
                if (char != '.') {
                    val value = 1.shl(char - '1')
                    if (value.and(rows[i].or(cols[j]).or(squares[i / 3 * 3 + j / 3])) == value) {
                        return false
                    }
                    rows[i] = rows[i].or(value)
                    cols[j] = cols[j].or(value)
                    squares[i / 3 * 3 + j / 3] = squares[i / 3 * 3 + j / 3].or(value)
                }
            }
        }
        return true
    }
}