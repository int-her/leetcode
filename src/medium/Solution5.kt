package medium

class Solution5 {
    fun test() {
        println(longestPalindrome("babad"))
        println(longestPalindrome("cbbd"))
    }

    fun longestPalindrome(s: String): String {
        var max = 0
        var result = ""
        val candidates = MutableList(s.length) { Pair(it, it) }
        (0..(s.length - 2)).forEach {
            if (s[it] == s[it + 1]) {
                candidates.add(Pair(it, it + 1))
            }
        }
        while (candidates.isNotEmpty()) {
            val (start, end) = candidates.removeAt(0)
            if (end - start + 1 > max) {
                max = end - start + 1
                result = s.substring(start, end + 1)
            }
            if (start != 0 && end != s.length - 1 && s[start - 1] == s[end + 1]) {
                candidates.add(Pair(start - 1, end + 1))
            }
        }
        return result
    }
}