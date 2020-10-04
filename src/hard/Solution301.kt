package hard

import main.Solution

class Solution301 : Solution() {
    override fun test() {
        val input = arrayOf(
            "",
            "()",
            "()())()",
            "(a)())()",
            ")("
        )
        input.forEach { println(removeInvalidParentheses(it)) }
    }

    fun removeInvalidParentheses(s: String): List<String> {
        var result = listOf(s)
        while (true) {
            val temp = mutableListOf<String>()
            result.forEach { str ->
                var count = 0
                var left = 0
                for ((index, char) in str.withIndex()) {
                    when (char) {
                        '(' -> count++
                        ')' -> count--
                    }
                    if (count == 0) {
                        left = index
                    } else if (count < 0) {
                        temp.addAll((0..index).filter { str[it] == ')' }.map { str.removeRange(it..it) })
                        break
                    }
                }
                if (count > 0) {
                    temp.addAll((left until str.length).filter { str[it] == '(' }.map { str.removeRange(it..it) })
                }
            }
            if (temp.isEmpty()) {
                break
            }
            result = temp.distinct()
        }
        return result
    }
}