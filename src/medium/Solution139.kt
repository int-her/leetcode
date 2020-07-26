package medium

import Solution
import java.util.*

class Solution139 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair("", listOf("a", "b", "c")),
            Pair("a", listOf("a", "b", "c")),
            Pair("d", listOf("a", "b", "c")),
            Pair("leetcode", listOf("leet", "code")),
            Pair("applepenapple", listOf("apple", "pen")),
            Pair("catsandog", listOf("cats", "dog", "sand", "and", "cat"))
        )
        input.forEach { println(wordBreak(it.first, it.second)) }
    }

    fun wordBreak(s: String, wordDict: List<String>): Boolean {
        val dict = wordDict.toSortedSet()
        val dp = mutableSetOf<String>()
        return helper(s, dict, dp)
    }

    fun helper(s: String, dict: SortedSet<String>, dp: MutableSet<String>): Boolean {
        return if (s.isEmpty()) {
            true
        } else {
            (1..s.length).forEach {
                if (s.substring(0, it) in dict && s.substring(it) !in dp && helper(s.substring(it), dict, dp)) {
                    return true
                }
            }
            dp.add(s)
            false
        }
    }
}