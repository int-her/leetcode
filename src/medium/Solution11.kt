package medium

import main.Solution

class Solution11 : Solution() {
    override fun test() {
        val input = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
        println(maxArea(input))
    }

    // 솔루션을 참고하였음
    fun maxArea(height: IntArray): Int {
        var l = 0
        var r = height.size - 1
        var max = 0
        while (l < r) {
            val area = (if (height[l] < height[r]) {
                height[l++]
            } else {
                height[r--]
            }) * (r - l + 1)
            if (max < area) {
                max = area
            }
        }
        return max
    }
}