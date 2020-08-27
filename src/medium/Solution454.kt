package medium

import Solution

class Solution454 : Solution() {
    override fun test() {
        val input = arrayOf(
            listOf(intArrayOf(1, 2), intArrayOf(-2, -1), intArrayOf(-1, 2), intArrayOf(0, 2))
        )
        input.forEach { println(fourSumCount(it[0], it[1], it[2], it[3])) }
    }

    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {
        val a = mutableMapOf<Int, Int>()
        val b = mutableMapOf<Int, Int>()
        A.indices.forEach { i ->
            A.indices.forEach { j ->
                a[A[i] + B[j]] = (a[A[i] + B[j]] ?: 0) + 1
                b[C[i] + D[j]] = (b[C[i] + D[j]] ?: 0) + 1
            }
        }
        return a.keys.sumBy { a[it]!! * (b[-it] ?: 0) }
    }
}