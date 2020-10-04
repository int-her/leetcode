package easy

import main.Solution

class Solution190 : Solution() {
    override fun test() {
        val input = arrayOf(
            43261596, -3
        )
        input.forEach { println(reverseBits(it)) }
    }

    // you need treat n as an unsigned value
    fun reverseBits(n: Int): Int {
        var result = 0
        var divider = 1.shl(31)
        var adder = 1
        while (divider != 0) {
            if (divider.and(n) == divider) {
                result += adder
            }
            divider = divider.ushr(1)
            adder = adder.shl(1)
        }
        return result
    }
}