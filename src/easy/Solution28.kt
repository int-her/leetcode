package easy

import Solution

class Solution28 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair("hello", "ll"),
            Pair("aaaaa", "bba"),
            Pair("", "b"),
            Pair("b", "")
        )
        input.forEach { println(strStr(it.first, it.second)) }
    }

    fun strStr(haystack: String, needle: String): Int {
        return when {
            needle.isEmpty() -> 0
            needle.length > haystack.length -> -1
            else -> {
                for (i in 0..haystack.length - needle.length) {
                    // substring은 생략..
                    if (haystack.substring(i, i + needle.length) == needle) {
                        return i
                    }
                }
                -1
            }
        }
    }
}