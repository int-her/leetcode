package hard

import main.Solution

class Solution32 : Solution() {
    override fun test() {
        println(longestValidParentheses("(()"))
        println(longestValidParentheses(")()())"))
        println(longestValidParentheses("()(()"))
    }

    fun longestValidParentheses(s: String): Int {
        val a = longestValidParentheses2(s, false)
        val b = longestValidParentheses2(s, true)
        return if (a > b) a else b
    }

    fun longestValidParentheses2(s: String, isReversed: Boolean): Int {
        var count = 0
        var now = 0
        var max = 0
        (if (!isReversed) s else s.reversed()).forEach { char ->
            now++
            when (char) {
                '(' -> if (!isReversed) count++ else count--
                ')' -> if (!isReversed) count-- else count++
            }
            if (count < 0) {
                count = 0
                now = 0
            } else if (count == 0 && now > max) {
                max = now
            }
        }
        return max
    }
}