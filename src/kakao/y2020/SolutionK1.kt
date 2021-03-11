package kakao.y2020

import main.Solution

class SolutionK1 : Solution() {
  override fun test() {
    val input = arrayOf("aaaaaaaaaaa")
  }

  fun solution(s: String): Int {
    var minLength = s.length
    (1 until s.length).forEach { u ->
      var length = s.length
      var flag = 0
      (1 until s.length / u).map { index ->
        if (s.substring(u * index, u * (index + 1)) == s.substring(u * (index - 1), u * index)) {
          println("u: $u, index: $index, length: $length, flag: $flag")
          length -= (u - if (flag > 0) 1 else 0)
          if (flag > 10) length++
          if (flag > 100) length++
          flag++
        } else {
          flag = 0
        }
      }
      minLength = if (minLength > length) length else minLength
      println("minLength: $minLength, u: $u")
    }
    return minLength
  }

  fun solution_other(s: String): Int {
    var minLength = s.length
    (1 until s.length).forEach { u ->
      val a = mutableListOf<String>()
      var length = s.length
      (0 until s.length / u).forEach { index ->
        a.add(s.substring(index * u, (index + 1) * u))
      }
      a.forEachIndexed { index, b ->
        var flag = false
        if (b.isNotEmpty()) {
          for (index2 in (index + 1 until s.length / u)) {
            if (b == a[index2]) {
              a[index2] = ""
              length -= u
              flag = true
            } else {
              break
            }
          }
        }
        if (flag) length++
      }
      minLength = if (minLength > length) length else minLength
    }

    return minLength
  }
}
