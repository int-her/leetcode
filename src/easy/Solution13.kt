package easy

import main.Solution

class Solution13 : Solution() {
    override fun test() {
        val input = arrayOf(
            "III", "IV", "IX", "LVIII", "MCMXCIV"
        )
        input.forEach { println(romanToInt(it)) }
    }

    fun romanToInt(s: String): Int {
        return if (s.isEmpty()) {
            0
        } else {
            val symbols = charArrayOf('I', 'V', 'X', 'L', 'C', 'D', 'M', '-', '-')
            val values = mapOf(Pair('I', 1), Pair('V', 5), Pair('X', 10), Pair('L', 50), Pair('C', 100), Pair('D', 500), Pair('M', 1000))
            var result = 0
            (0 until s.lastIndex).forEach {
                val n = symbols.indexOf(s[it])
                val sign = if (s[it + 1] == symbols[n + 1] || s[it + 1] == symbols[n + 2]) -1 else 1
                result += sign * values[s[it]]!!
            }
            result + values[s.last()]!!
        }
    }
}