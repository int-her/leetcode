package medium

import Solution

class Solution227 : Solution() {
    override fun test() {
        val input = arrayOf(
            "3+2*2",
            " 3/2 ",
            " 3+5 / 2 "
        )
        input.forEach { println(calculate(it)) }
    }

    fun calculate(s: String): Int {
        val operators = listOf('+', '-', '*', '/')
        val tokens1 = mutableListOf<Any>()
        val tokens2 = mutableListOf<Any>()

        var start = 0
        s.indices.forEach { index ->
            if (s[index] in operators) {
                tokens1.add(s.substring(start, index).trim().toInt())
                tokens1.add(s[index])
                start = index + 1
            }
        }
        tokens1.add(s.substring(start).trim().toInt())

        var index = 0
        var value = -1
        while (index < tokens1.size) {
            when (tokens1[index++]) {
                '+', '-' -> {
                    tokens2.add(value)
                    tokens2.add(tokens1[index - 1])
                }
                '*' -> value *= tokens1[index++] as Int
                '/' -> value /= tokens1[index++] as Int
                else -> value = tokens1[index - 1] as Int
            }
        }
        tokens2.add(value)

        index = 1
        var result = tokens2.first() as Int
        while (index < tokens2.size) {
            when (tokens2[index++]) {
                '+' -> result += tokens2[index++] as Int
                '-' -> result -= tokens2[index++] as Int
            }
        }

        return result
    }
}