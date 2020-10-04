package hard

import main.Solution
import java.util.*

class Solution84 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(2, 1, 5, 6, 2, 3),
            intArrayOf(1),
            intArrayOf(1, 1),
            intArrayOf(2, 1, 2),
            intArrayOf(4, 2, 0, 3, 2, 5),
            intArrayOf(0, 1, 2, 0, 1, 0),
            intArrayOf(4, 2, 0, 3, 2, 5),
            intArrayOf(1, 1, 1, 1, 1, 1),
            intArrayOf(0, 1, 2, 3, 4, 5, 6),
            intArrayOf(1, 2, 3, 4, 5, 6, 7),
            intArrayOf(1, 6, 5, 4, 3, 2, 1, 0, 7),
            intArrayOf(1, 7, 6, 5, 4, 3, 2, 1, 9)
        )
        input.forEach { println(largestRectangleArea(it)) }
    }

    // Divide and conquer -> O(nlogn)
    // Use stack -> O(n)
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = Stack<Int>()
        var max = 0
        heights.forEachIndexed { index, height ->
            while (stack.isNotEmpty() && heights[stack.peek()] > height) {
                max = max.coerceAtLeast(heights[stack.pop()] * (index - 1 - if (stack.isEmpty()) -1 else stack.peek()))
            }
            stack.push(index)
        }
        while (stack.isNotEmpty()) {
            max = max.coerceAtLeast(heights[stack.pop()] * (heights.lastIndex - if (stack.isEmpty()) -1 else stack.peek()))
        }
        return max
    }
}