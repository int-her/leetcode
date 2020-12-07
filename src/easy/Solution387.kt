package easy

import main.Solution

class Solution387 : Solution() {
  override fun test() {
    val input = listOf(
      "leetcode",
      "loveleetcode"
    )
    input.forEach { println(firstUniqChar(it)) }
  }

  fun firstUniqChar(s: String): Int {
    val map = s.groupBy { it }.mapValues { it.value.size }
    s.forEachIndexed { index, char ->
      if (map[char] == 1) {
        return index
      }
    }
    return -1
  }
}