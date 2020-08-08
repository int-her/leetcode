package hard

import Solution

class Solution44 : Solution() {
    val dp = mutableSetOf<Pair<String, String>>()

    override fun test() {
        val input = arrayOf(
            Pair("aa", "a"),
            Pair("aa", "*"),
            Pair("cb", "?a"),
            Pair("adceb", "*a*b"),
            Pair("acdcb", "a*c?b"),
            Pair("", ""),
            Pair("ho", "**ho"),
            Pair("aaabaaabaabababbabababaababbabbbbaaaaababbaabbbaab", "*babbbb*aab**b*bb*aa*"),
            Pair("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaaba", "a*******b"),
            Pair("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb")
        )
        input.forEach { println(isMatch(it.first, it.second)) }
    }

    fun isMatch(s: String, p: String): Boolean {
        return when {
            p == s || (p.isNotEmpty() && p.all { it == '*' }) -> true
            s.isEmpty() || p.isEmpty() -> false
            s.first() == p.first() || p.first() == '?' -> isMatch(s.substring(1), p.substring(1))
            s.last() == p.last() || p.last() == '?' -> isMatch(s.substring(0, s.lastIndex), p.substring(0, p.lastIndex))
            p.first() != '*' || p.last() != '*' -> false
            else -> {
                if (!dp.contains(Pair(s, p))) {
                    (0..s.length).forEach { sIndex ->
                        if (isMatch(s.substring(sIndex), p.trimStart('*'))) {
                            return true
                        }
                    }
                    dp.add(Pair(s, p))
                }
                false
            }
        }
    }
}