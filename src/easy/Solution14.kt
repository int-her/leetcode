package easy

import main.Solution

class Solution14 : Solution() {
    override fun test() {
        val input = arrayOf(
            arrayOf("flower", "flow", "flight"),
            arrayOf("dog", "racecar", "car")
        )
        input.forEach { println(longestCommonPrefix(it)) }
    }

    fun longestCommonPrefix(strs: Array<String>): String {
        var prefix = strs.firstOrNull() ?: ""
        strs.forEach {
            for (i in prefix.indices) {
                if (i == it.length || prefix[i] != it[i]) {
                    prefix = prefix.substring(0, i)
                    break
                }
            }
        }
        return prefix
    }
}