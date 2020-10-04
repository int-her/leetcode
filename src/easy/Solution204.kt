package easy

import main.Solution

class Solution204 : Solution() {
    override fun test() {
        val input = arrayOf(
            16, 14, 13, 10, 9, 7
        )
        input.forEach { println(countPrimes(it)) }
    }

    fun countPrimes(n: Int): Int {
        var list = (2 until n).toList()
        return if (list.isEmpty()) {
            0
        } else {
            var index = 0
            while (list[index] * list[index] <= n) {
                list = list.filterIndexed { i, num -> i <= index || num % list[index] != 0 }
                index++
            }
            list.size
        }
    }
}