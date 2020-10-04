package medium

import main.Solution
import java.util.*

class Solution378 : Solution() {
    override fun test() {
        val input = arrayOf(
            arrayOf(intArrayOf(1, 5, 9), intArrayOf(10, 11, 13), intArrayOf(12, 13, 15))
        )
        input.forEach { println(kthSmallest(it, 8)) }
    }

    fun kthSmallest(matrix: Array<IntArray>, k: Int): Int {
        val priorityQueue = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
        val indices = MutableList(matrix.size) { 0 }
        matrix.indices.forEach { priorityQueue.add(Pair(matrix[it][indices[it]++], it)) }
        repeat(k - 1) {
            val (_, index) = priorityQueue.poll()
            if (indices[index] < matrix.size) {
                priorityQueue.add(Pair(matrix[index][indices[index]++], index))
            }
        }
        return priorityQueue.first().first
    }
}