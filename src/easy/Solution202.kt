package easy

import Solution

class Solution202 : Solution() {
    override fun test() {
        val input = arrayOf(
            1, 2, 3, 4, 5, 19
        )
        input.forEach { println(isHappy(it)) }
    }

    fun isHappy(n: Int): Boolean {
        val visited = mutableSetOf<Int>()
        var num = n
        while (num !in visited) {
            visited.add(num)
            num = num.toString().fold(0) { sum, char -> sum + (char - '0') * (char - '0') }
            if (num == 1) {
                return true
            }
        }
        return false
    }
}