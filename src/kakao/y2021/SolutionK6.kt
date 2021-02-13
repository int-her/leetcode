package kakao.y2021

import main.Solution

class SolutionK6 : Solution() {
    override fun test() {
        val input = arrayOf(
            Triple(arrayOf(intArrayOf(1, 0, 0, 3), intArrayOf(2, 0, 0, 0), intArrayOf(0, 0, 0, 2), intArrayOf(3, 0, 1, 0)), 1, 0),
            Triple(arrayOf(intArrayOf(3, 0, 0, 2), intArrayOf(0, 0, 1, 0), intArrayOf(0, 1, 0, 0), intArrayOf(2, 0, 0, 3)), 0, 1)
        )
        input.forEach { println(solution(it.first, it.second, it.third)) }
    }

    fun solution(board: Array<IntArray>, r: Int, c: Int): Int {
        val characters = board.fold(listOf<Int>()) { acc, it -> acc + it.toList()}.distinct().filter { it != 0 }
        val order = mutableListOf<List<Int>>()
        helper(characters, mutableListOf(), order)
        return order.map {
            val copy = board.clone()
            helper2(copy, it, Pair(r, c))
        }.min()!!
    }

    fun helper(n: List<Int>, picked: List<Int>, result: MutableList<List<Int>>) {
        when (n.size) {
            0 -> result.add(picked)
            else -> n.indices.forEach {
                helper(n.subList(0, it) + n.subList(it + 1, n.size), picked + n[it], result)
            }
        }
    }

    fun helper2(board: Array<IntArray>, order: List<Int>, start: Pair<Int, Int>): Int {
        return if (order.isEmpty()) {
            0
        } else {
            var t1 = Pair(-1, -1)
            var t2 = Pair(-1, -1)
            board.indices.forEach { i ->
                board[i].indices.forEach { j ->
                    if (board[i][j] == order.first()) {
                        if (t1.first == -1) t1 = Pair(i, j) else t2 = Pair(i, j)
                    }
                }
            }
            val d1 = helper3(board, start, t1)
            val d2 = helper3(board, t1, t2)
            val d3 = helper3(board, start, t2)
            val d4 = helper3(board, t2, t1)
            board[t1.first][t1.second] = 0
            board[t2.first][t2.second] = 0
            val d5 = helper2(board, order.subList(1, order.size), t2)
            val d6 = helper2(board, order.subList(1, order.size), t1)
            board[t1.first][t1.second] = order.first()
            board[t2.first][t2.second] = order.first()
//            println("$order $start $d1 $d2 $d3 $d4 $d5 $d6")
            (d1 + d2 + d5).coerceAtMost(d3 + d4 + d6) + 2
        }
    }

    fun helper3(board: Array<IntArray>, start: Pair<Int, Int>, end: Pair<Int, Int>): Int {
        val set = mutableSetOf(start)
        var temp = setOf(start)
        var distance = 0
        while (end !in set) {
            val temp2 = mutableSetOf<Pair<Int, Int>>()
            temp.forEach { (r, c) ->
                if (r > 0) temp2.add(Pair(r - 1, c))
                if (c > 0) temp2.add(Pair(r, c - 1))
                if (r < 3) temp2.add(Pair(r + 1, c))
                if (c < 3) temp2.add(Pair(r, c + 1))
                ((c + 1..3).firstOrNull { board[r][it] != 0 } ?: 3).let { temp2.add(Pair(r, it)) }
                ((0 until c).lastOrNull { board[r][it] != 0 } ?: 0).let { temp2.add(Pair(r, it)) }
                ((r + 1..3).firstOrNull { board[it][c] != 0 } ?: 3).let { temp2.add(Pair(it, c)) }
                ((0 until r).lastOrNull { board[it][c] != 0 } ?: 0).let { temp2.add(Pair(it, c)) }
            }
            temp2.removeIf { it in set }
            temp = temp2
            set.addAll(temp)
            distance++
        }
        return distance
    }
}