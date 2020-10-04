package easy

import main.Solution

class Solution69 : Solution() {
    override fun test() {
        val input = arrayOf(
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, Int.MAX_VALUE
        )
        input.forEach { println(mySqrt(it)) }
    }

    fun mySqrt(x: Int): Int {
        var min = 0
        var max = 46340
        return if (x >= max * max) {
            max
        } else {
            while (max - min > 1) {
                val mid = (min + max) / 2
                if (x >= mid * mid) {
                    min = mid
                } else {
                    max = mid
                }
            }
            min
        }
    }
}