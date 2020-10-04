package medium

import main.Solution

class Solution338 : Solution() {
    override fun test() {
        (0..6).forEach { println(countBits(it).joinToString()) }
    }

    fun countBits(num: Int): IntArray {
        val result = IntArray(num + 1)
        result.indices.forEach {
            result[it] = result[it / 2] + it % 2
        }
        return result
    }
}