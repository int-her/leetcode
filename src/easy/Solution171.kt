package easy

import main.Solution
import kotlin.math.pow

class Solution171 : Solution() {
    override fun test() {
        val input = arrayOf(
            "A", "AB", "ZY"
        )
        input.forEach { println(titleToNumber(it)) }
    }

    fun titleToNumber(s: String): Int {
        return s.reversed().foldIndexed(0) { index, sum, char -> sum + 26.0.pow(index).toInt() * (char.toInt() - 64) }
    }
}