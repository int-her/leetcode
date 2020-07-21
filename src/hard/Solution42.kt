package hard

import Solution

class Solution42 : Solution() {
    override fun test() {
        println(trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)))
        println(trap(intArrayOf(4, 2, 0, 3, 2, 5)))
        println(trap(intArrayOf(2, 0, 2)))
    }

    fun trap(height: IntArray): Int {
        var start = height.indexOfFirst { it > 0 }
        if (start == -1) {
            return 0
        }
        var end = start + 1
        var result = 0
        var temp = 0
        while (end < height.size) {
            if (height[end] >= height[start]) {
                result += (end - start - 1) * height[start] - temp
                temp = 0
                start = end
            } else {
                temp += height[end]
            }
            end++
        }
        val leftBorder = start
        end = height.indexOfLast { it > 0 }
        start = end - 1
        temp = 0
        while (start >= leftBorder) {
            if (height[start] >= height[end]) {
                result += (end - start - 1) * height[end] - temp
                temp = 0
                end = start
            } else {
                temp += height[start]
            }
            start--
        }
        return result
    }
}