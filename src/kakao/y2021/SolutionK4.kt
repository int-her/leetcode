package kakao.y2021

import main.Solution

class SolutionK4 : Solution() {
  override fun test() {
    val input = arrayOf(
            Pair(arrayOf(6, 4, 6, 2), arrayOf(intArrayOf(4, 1, 10), intArrayOf(3, 5, 24), intArrayOf(5, 6, 2), intArrayOf(3, 1, 41), intArrayOf(5, 1, 24), intArrayOf(4, 6, 50), intArrayOf(2, 4, 66), intArrayOf(2, 3, 22), intArrayOf(1, 6, 25))),
            Pair(arrayOf(7, 3, 4, 1), arrayOf(intArrayOf(5, 7, 9), intArrayOf(4, 6, 4), intArrayOf(3, 6, 1), intArrayOf(3, 2, 3), intArrayOf(2, 1, 6))),
            Pair(arrayOf(6, 4, 5, 6), arrayOf(intArrayOf(2,6,6), intArrayOf(6,3,7), intArrayOf(4,6,7), intArrayOf(6,5,11), intArrayOf(2,5,12), intArrayOf(5,3,20), intArrayOf(2,4,8), intArrayOf(4,3,9))),
    )
    input.forEach { println(solution(it.first[0], it.first[1], it.first[2], it.first[3], it.second)) }
  }

  fun solution(n: Int, s: Int, a: Int, b: Int, fares: Array<IntArray>): Int {
    val adjacency = Array(n) { IntArray(n) { Int.MAX_VALUE } }
    fares.map { fare ->
      adjacency[fare[0] - 1][fare[1] - 1] = fare[2]
      adjacency[fare[1] - 1][fare[0] - 1] = fare[2]
    }
    (0 until n).forEach { adjacency[it][it] = 0 }
    (0 until n).forEach { i ->
      (0 until n).forEach { j ->
        (0 until n).forEach { k ->
          if (adjacency[j][i] != Int.MAX_VALUE && adjacency[i][k] != Int.MAX_VALUE) {
            adjacency[j][k] = adjacency[j][k].coerceAtMost(adjacency[j][i] + adjacency[i][k])
          }
        }
      }
    }
    return (0 until n).map { c ->
      if (listOf(adjacency[s - 1][c], adjacency[c][a - 1], adjacency[c][b - 1]).any { it == Int.MAX_VALUE }) {
        Int.MAX_VALUE
      } else {
        adjacency[s - 1][c] + adjacency[c][a - 1] + adjacency[c][b - 1]
      }
    }.minOrNull() ?: Int.MAX_VALUE
  }
}