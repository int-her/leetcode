package medium

import Solution
import kotlin.math.abs
import kotlin.math.sign

class Solution50 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(21.5, 0),
            Pair(2.00000, 10),
            Pair(2.10000, 3),
            Pair(2.00000, -2),
            Pair(0.00001, 2147483647),
            Pair(2.00000, -2147483648)
        )
        input.forEach { println(myPow(it.first, it.second)) }
    }

    fun myPow(x: Double, n: Int): Double {
        val nums = mutableListOf(Pair(x, 1L))
        val sign = n.sign
        var abs = abs(n.toLong())
        var result = 1.toDouble()
        while (nums.last().second < abs) {
            nums.add(Pair(nums.last().first * nums.last().first, nums.last().second * 2))
        }
        nums.reversed().forEach { (num, m) ->
            if (abs >= m) {
                if (sign >= 0) result *= num else result /= num
                abs -= m
            }
        }
        return result
    }
}