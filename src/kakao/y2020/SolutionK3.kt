package kakao.y2020

import main.Solution

class SolutionK3 : Solution() {
  override fun test() {
    val input = arrayOf(
            Pair(
                    arrayOf(intArrayOf(0, 0, 0), intArrayOf(1, 0, 0), intArrayOf(0, 1, 1)),
                    arrayOf(intArrayOf(1, 1, 1), intArrayOf(1, 1, 0), intArrayOf(1, 0, 1))
            )
    )
    input.forEach { println(solution(it.first, it.second)) }
  }

  fun solution(key: Array<IntArray>, lock: Array<IntArray>): Boolean {
    val m = key.size
    val key2 = solution_b(key)
    val key3 = solution_b(key2)
    val key4 = solution_b(key3)
    (0 until 60 - m).forEach { i ->
      (0 until 60 - m).forEach { j ->
        val start = Pair(i, j)
        if (solution_a(key, lock, start)) return true
        if (solution_a(key2, lock, start)) return true
        if (solution_a(key3, lock, start)) return true
        if (solution_a(key4, lock, start)) return true
      }
    }
    return false
  }

  fun solution_a(key: Array<IntArray>, lock: Array<IntArray>, start: Pair<Int, Int>): Boolean {
    val t = Array(60) { IntArray(60) { 0 } }
    val m = key.size
    val n = lock.size

    (0 until m).forEach { i ->
      (0 until m).forEach { j ->
        t[start.first + i][start.second + j] = key[i][j]
      }
    }

    (0 until n).forEach { i ->
      (0 until n).forEach { j ->
        t[20 + i][20 + j] += lock[i][j]
      }
    }

    (20 until 20 + n).forEach { i ->
      (20 until 20 + n).forEach { j ->
        if (t[i][j] != 1) return false
      }
    }

    println("[solution_3_a] start: (${start.first}, ${start.second})")
    return true
  }

  fun solution_b(key: Array<IntArray>): Array<IntArray> {
    val m = key.size
    val right90 = Array(m) { IntArray(m) { 0 } }
    (0 until m).forEach { i ->
      (0 until m).forEach { j ->
        right90[j][m - i - 1] = key[i][j]
      }
    }
    return right90
  }
}