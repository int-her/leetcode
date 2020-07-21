package medium

import Solution

class Solution49 : Solution() {
    override fun test() {
        println(groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")))
    }

    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val anagrams = mutableMapOf<String, List<String>>()
        strs.forEach { str ->
            val counts = IntArray(26) { 0 }
            str.forEach { counts[it.toInt() - 97]++ }
            val key = counts.joinToString()
            anagrams[key] = (anagrams[key] ?: emptyList()) + str
        }
        return anagrams.map { it.value }
    }
}