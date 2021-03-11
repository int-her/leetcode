package kakao.y2020

import main.Solution
import java.lang.Exception

class SolutionK2 : Solution() {
  override fun test() {
    val input = arrayOf(
            "(()())()",
            ")(",
            "()))((()"
    )
    input.forEach { println(solution(it)) }
  }

  fun solution(p: String): String {
    return if (solution_b(p)) {
      p
    } else {
      val (u, v) = solution_a(p)
      if (solution_b(u)) {
        "$u${solution(v)}"
      } else {
        "(${solution(v)})${solution_c(u)}"
      }
    }
  }

  fun solution_a(p: String): Pair<String, String> {
    var t = 0
//  println("[solution_2_b] p: $p")
    (p.indices).forEach {
      if (p[it] == '(') t++ else t--
      if (t == 0) {
//      println("[solution_2_b] u: ${p.substring(0, it + 1)}, v: ${p.substring(it + 1)}\n--------------------------")
        return Pair(p.substring(0, it + 1), p.substring(it + 1))
      }
    }
    throw Exception()
  }

  fun solution_b(p: String): Boolean {
    var t = 0
    (p.indices).forEach {
      if (p[it] == '(') t++ else t--
      if (t < 0)
        return false
    }
    return p.isBlank() || t == 0
  }

  fun solution_c(p: String): String {
    return p.substring(1, p.length - 1).map {
      if (it == '(') ')' else '('
    }.joinToString(separator = "")
  }
}