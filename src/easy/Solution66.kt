package easy

import main.Solution

class Solution66 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(0),
            intArrayOf(1),
            intArrayOf(9),
            intArrayOf(4, 9),
            intArrayOf(9, 9, 9, 9),
            intArrayOf(1, 2, 3),
            intArrayOf(4, 3, 2, 1)
        )
        input.forEach { println(plusOne(it).joinToString()) }
    }

    fun plusOne(digits: IntArray): IntArray {
        digits[digits.lastIndex]++
        var index = digits.lastIndex
        while (index >= 0) {
            if (digits[index] == 10) {
                digits[index--] = 0
                if (index >= 0) {
                    digits[index]++
                }
            } else {
                break
            }
        }
        return if (digits.first() == 0) IntArray(1) { 1 } + digits else digits
    }
}