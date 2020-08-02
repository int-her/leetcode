package medium

import Solution

class Solution438 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair("cbaebabacd", "abc"),
            Pair("abab", "ab")
        )
        input.forEach { println(findAnagrams(it.first, it.second)) }
    }

    fun findAnagrams(s: String, p: String): List<Int> {
        val count = IntArray(26) { 0 }
        val result = mutableListOf<Int>()
        if (s.length >= p.length) {
            p.indices.forEach {
                count[p[it].toInt() - 97]--
                count[s[it].toInt() - 97]++
            }
            var count2 = count.count { it == 0 }
            if (count2 == 26) {
                result.add(0)
            }
            (0 until s.length - p.length).forEach {
                when (count[s[it].toInt() - 97]) {
                    0 -> count2--
                    1 -> count2++
                }
                count[s[it].toInt() - 97]--
                when (count[s[it + p.length].toInt() - 97]) {
                    0 -> count2--
                    -1 -> count2++
                }
                count[s[it + p.length].toInt() - 97]++
                if (count2 == 26) {
                    result.add(it + 1)
                }
            }
        }
        return result
    }
}