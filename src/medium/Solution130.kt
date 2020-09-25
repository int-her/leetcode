package medium

import Solution
import java.util.*

class Solution130 : Solution() {
    override fun test() {
        val input = arrayOf(
            arrayOf(
                charArrayOf('X', 'X', 'X', 'X'),
                charArrayOf('X', 'O', 'O', 'X'),
                charArrayOf('X', 'X', 'O', 'X'),
                charArrayOf('X', 'O', 'X', 'X')
            )
        )
        input.forEach { data ->
            solve(data)
            println(data.joinToString(separator = "\n") { it.joinToString() })
        }
    }

    fun solve(board: Array<CharArray>): Unit {
        val dxy = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))
        val groups: MutableList<List<Pair<Int, Int>>> = mutableListOf(listOf())
        board.indices.forEach { i ->
            board[i].indices.forEach { j ->
                if (board[i][j] == 'O') {
                    val queue = LinkedList<Pair<Int, Int>>(listOf(Pair(i, j)))
                    val group = mutableListOf(Pair(i, j))
                    board[i][j] = 'X'
                    while (queue.isNotEmpty()) {
                        val (x, y) = queue.poll()
                        dxy.forEach { (dx, dy) ->
                            if (x + dx in board.indices && y + dy in board[i].indices && board[x + dx][y + dy] == 'O') {
                                queue.add(Pair(x + dx, y + dy))
                                group.add(Pair(x + dx, y + dy))
                                board[x + dx][y + dy] = 'X'
                            }
                        }
                    }
                    groups.add(group)
                }
            }
        }
        groups.forEach { group ->
            if (group.any { it.first == 0 || it.first == board.lastIndex || it.second == 0 || it.second == board.first().lastIndex }) {
                group.forEach { (x, y) -> board[x][y] = 'O' }
            }
        }
    }
}