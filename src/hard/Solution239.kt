package hard

import main.Solution
import java.util.*

class Solution239 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(intArrayOf(1, 3, -1, -3, 5, 3, 6, 7), 3)
        )
        input.forEach { println(maxSlidingWindow(it.first, it.second).joinToString()) }
    }

    // Follow up: Could you solve it in linear time?
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val result = IntArray(nums.size - k + 1)
        val queue = LinkedList<Int>()
        (0 until k).forEach {
            while (queue.isNotEmpty() && queue.last() < nums[it]) {
                queue.removeLast()
            }
            queue.add(nums[it])
        }
        result[0] = queue.first()
        (k until nums.size).forEach {
            if (queue.first() == nums[it - k]) {
                queue.removeFirst()
            }
            while (queue.isNotEmpty() && queue.last() < nums[it]) {
                queue.removeLast()
            }
            queue.add(nums[it])
            result[it - k + 1] = queue.first()
        }
        return result
    }
}