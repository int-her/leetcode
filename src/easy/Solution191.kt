package easy

import main.Solution
import kotlin.math.pow

class Solution191 : Solution() {
    override fun test() {
        val input = arrayOf(
            0, 1, 2, 3, 4 ,5, 6, 7, Int.MIN_VALUE, -3
        )
        input.forEach { println(hammingWeight(it)) }
    }

    // you need treat n as an unsigned value
    fun hammingWeight(n: Int): Int {
        return when {
            n == Int.MIN_VALUE -> 1
            n < 0 -> hammingWeight(n - Int.MIN_VALUE) + 1
            else -> {
                var temp = n
                var step = 2.toDouble().pow(30).toInt()
                var result = 0
                while (temp > 0) {
                    if (temp >= step) {
                        temp -= step
                        result++
                    }
                    step /= 2
                }
                result
            }
        }
    }
}