package medium

import main.Solution

class Solution131 : Solution() {
  override fun test() {
    val input = listOf("aab", "a")
    input.forEach { println(partition(it)) }
  }

  fun partition(s: String): List<List<String>> {
    val dp = List<MutableList<List<String>>>(s.length) { mutableListOf() }
    dp[0].add(listOf(s.substring(0, 1)))
    (1 until s.length).forEach { end ->
      (0..end).forEach { start ->
        val substring = s.substring(start, end + 1)
        println(substring)
        if (isPalindrome(substring)) {
          dp[end].addAll(
            if (start > 0) dp[start - 1].map { it + listOf(substring) } else listOf(listOf(substring))
          )
        }
      }
    }
    return dp.last()
  }

  fun isPalindrome(s: String) = (0..s.length / 2).all { s[it] == s[s.lastIndex - it] }
}