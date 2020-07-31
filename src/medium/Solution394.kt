package medium

import Solution

class Solution394 : Solution() {
    override fun test() {
        val input = arrayOf(
            "3[a]2[bc]",
            "3[a2[c]]",
            "2[abc]3[cd]ef",
            "abc3[cd]xyz"
        )
        input.forEach { println(decodeString(it)) }
    }

    fun decodeString(s: String): String {
        val numberStart = s.indices.firstOrNull { s[it] in '0'..'9' }
        val numberEnd = s.indices.firstOrNull { s[it] == '[' }
        return numberStart?.let {
            var count = 1
            var bracketEnd = -1
            for (i in numberEnd!! + 1 until s.length) {
                when (s[i]) {
                    '[' -> count++
                    ']' -> count--
                }
                if (count == 0) {
                    bracketEnd = i
                    break
                }
            }
            s.substring(0, numberStart) + decodeString(s.substring(numberEnd + 1, bracketEnd)).repeat(s.substring(numberStart, numberEnd).toInt()) + decodeString(s.substring(bracketEnd + 1))
        } ?: s
    }
}