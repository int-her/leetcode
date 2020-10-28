package medium

import main.Solution

class Solution371 : Solution() {
  override fun test() {
    val input = arrayOf(
      Pair(1, 2),
      Pair(0, 5),
      Pair(-5, 0),
      Pair(123, 494),
      Pair(-1, -2),
      Pair(-443, 212),
      Pair(1442, -442)
    )
    input.forEach { println(getSum(it.first, it.second)) }
  }

  fun getSum(a: Int, b: Int): Int {
    val aa = convert(a)
    val bb = convert(b)

    var flag = 0
    val sum = (0 until 32).reversed().map {
      when (aa[it] + bb[it] + flag) {
        0 -> {
          flag = 0
          0
        }
        1 -> {
          flag = 0
          1
        }
        2 -> {
          flag = 1
          0
        }
        else -> {
          flag = 1
          1
        }
      }
    }.reversed()
    var result = 0
    var multiplier = 1
    flag = sum.first()
    sum.reversed().map { it ->
      result += if (flag == 1) {
        multiplier * (1 - it)
      } else {
        multiplier * it
      }
      multiplier *= 2
    }
    return if (flag == 1) -(result + 1) else result
  }

  fun convert(x: Int): IntArray {
    return when {
      x >= 0 -> x.toString(2).padStart(32, '0')
      x == -1 -> "".padEnd(33, '1')
      else -> {
        val xx = (-(x+1)).toString(2).padStart(32, '0')
        xx.map { ('1' - it + '0'.toInt()).toChar() }.joinToString(separator = "")
      }
    }.map { it - '0' }.toIntArray()
  }
}