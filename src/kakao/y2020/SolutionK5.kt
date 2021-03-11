package kakao.y2020

import main.Solution

class SolutionK5 : Solution() {
  override fun test() {
    val input = arrayOf(
            Pair(5, arrayOf(intArrayOf(1, 0, 0, 1), intArrayOf(1, 1, 1, 1), intArrayOf(2, 1, 0, 1), intArrayOf(2, 2, 1, 1), intArrayOf(5, 0, 0, 1), intArrayOf(5, 1, 0, 1), intArrayOf(4, 2, 1, 1), intArrayOf(3, 2, 1, 1))),
    )
    input.forEach { println(solution(it.first, it.second).joinToString("\n") { itt -> itt.joinToString(",") }) }
  }

  data class A(
          var a: Boolean,
          var b: Boolean
  )

  fun solution(n: Int, build_frame: Array<IntArray>): Array<IntArray> {
    val map = Array(n + 1) { Array(n + 1) { A(a = false, b = false) } }
    build_frame.map {
      val x = it[0]
      val y = it[1]
      when (it[2]) {
        0 -> when (it[3]) {
          0 -> if ((y == n - 1 || (!map[x][y + 1].a || (x > 0 && map[x - 1][y + 1].b || map[x][y + 1].b)))
                  && (!map[x][y + 1].b || (map[x + 1][y].a || (x > 0 && map[x - 1][y + 1].b && map[x + 1][y + 1].b)))
                  && (!(x > 0 && map[x - 1][y + 1].b) || (map[x - 1][y].a || (x > 1 && map[x - 2][y + 1].b && map[x][y + 1].b)))) map[x][y].a = false
          1 -> if (y == 0 || map[x][y - 1].a || map[x][y].b || (x > 0 && map[x - 1][y].b)) map[x][y].a = true
        }
        1 -> when (it[3]) {
          0 -> if ((!(x > 0 && map[x - 1][y].b) || (map[x - 1][y - 1].a || map[x][y - 1].a))
                  && (!map[x + 1][y].b || (map[x + 1][y - 1].a || map[x + 2][y - 1].a))
                  && (!map[x][y].a || (map[x][y - 1].a || (x > 0 && map[x - 1][y].b)))
                  && (!map[x + 1][y].a || (map[x + 1][y - 1].a || (x < n && map[x + 1][y].b)))) map[x][y].b = false
          1 -> if (map[x][y - 1].a || map[x + 1][y - 1].a || ((x > 0 && map[x - 1][y].b) && (x < n && map[x + 1][y].b))) map[x][y].b = true
        }
      }
    }
    var answer = arrayOf<IntArray>()
    (0 until n + 1).forEach { i ->
      (0 until n + 1).forEach { j ->
        if (map[i][j].a) answer = answer.plus(intArrayOf(i, j, 0))
        if (map[i][j].b) answer = answer.plus(intArrayOf(i, j, 1))
      }
    }
    return answer
  }
}