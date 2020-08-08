package easy

import Solution
import kotlin.math.abs
import kotlin.math.sign

class Solution7 : Solution() {
    override fun test() {
        val input = arrayOf(123, -123, 120, 1200, 0, 1, -1)
        input.forEach { println(reverse(it)) }
    }

    fun reverse(x: Int): Int {
        return try {
            x.sign * abs(x).toString().reversed().toInt()
        } catch (e: Exception) {
            0
        }
    }
}