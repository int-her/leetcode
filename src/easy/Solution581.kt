package easy

import Solution
import java.util.*

class Solution581 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(2, 6, 4, 8, 10, 9, 15),
            intArrayOf(1, 2, 3, 4),
            intArrayOf(1, 2, 4, 3),
            intArrayOf(1, 3, 5, 4, 2),
            intArrayOf(1, 3, 2, 3, 3),
            intArrayOf(1, 3, 2, 2, 2),
            intArrayOf(1, 2, 5, 3, 4)
        )
        input.forEach { println(findUnsortedSubarray(it)) }
    }

    fun findUnsortedSubarray(nums: IntArray): Int {
        var min = Int.MAX_VALUE
        var max = Int.MIN_VALUE
        val stack = Stack<Pair<Int, Int>>()
        nums.forEachIndexed { index, num ->
            while (stack.isNotEmpty() && (stack.peek().first > num || (stack.peek().first == num && max == index - 1))) {
                val (_, popIndex) = stack.pop()
                min = min.coerceAtMost(popIndex)
                max = max.coerceAtLeast(index)
            }
            stack.push(Pair(num, index))
        }
        stack.clear()
        nums.reversed().forEachIndexed { index, num ->
            while (stack.isNotEmpty() && (stack.peek().first < num || (stack.peek().first == num && min == (nums.lastIndex - index) + 1))) {
                val (_, popIndex) = stack.pop()
                min = min.coerceAtMost(nums.lastIndex - index)
                max = max.coerceAtLeast(popIndex)
            }
            stack.push(Pair(num, nums.lastIndex - index))
        }
        return if (min == Int.MAX_VALUE) 0 else max - min + 1
    }
}