package easy

import main.Solution
import kotlin.math.log
import kotlin.math.pow

class Solution172 : Solution() {
    override fun test() {
        val input = arrayOf(
            3, 5, 8, 10, 24, 25, 99, 100, 124, 125, 2147483647, 2147483646
        )
        input.forEach { println(trailingZeroes(it)) }
    }

    fun trailingZeroes(n: Int): Int {
        return (1..log(n.toDouble(), 5.0).toInt()).fold(0) { sum, exponent -> sum + n / 5.0.pow(exponent).toInt() }
    }
}