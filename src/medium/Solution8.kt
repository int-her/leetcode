package medium

import main.Solution

class Solution8 : Solution() {
    override fun test() {
        val input = arrayOf(
            "42", "    -42", "4193 with words", "words and 987", "-91283472332", "1", "0", "-0", "-1", "    0000000    ", "+-2", "+"
        )
        input.forEach { println(myAtoi(it)) }
    }

    fun myAtoi(str: String): Int {
        return str.indices.firstOrNull { str[it] != ' ' }?.let { index ->
            var (start, sign) = when (str[index]) {
                '+' -> Pair(index + 1, 1)
                '-' -> Pair(index + 1, -1)
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> Pair(index, 1)
                else -> return 0
            }
            while (start < str.length && str[start] !in '1'..'9') {
                if (str[start++] != '0') return 0
            }
            if (start == str.length) {
                0
            } else {
                val end = (start + 1..str.lastIndex).firstOrNull { str[it] !in '0'..'9' } ?: str.length
                val result = (if (end - start >= 11) 10000000000 else str.substring(start, end).toLong()) * sign
                when {
                    result in Int.MIN_VALUE..Int.MAX_VALUE -> result.toInt()
                    sign == 1 -> Int.MAX_VALUE
                    else -> Int.MIN_VALUE
                }
            }
        } ?: 0
    }
}