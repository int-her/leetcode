package easy

import main.Solution

class Solution189 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(intArrayOf(-1, -100, 3, 99), 2),
            Pair(intArrayOf(1, 2, 3, 4, 5, 6, 7), 0),
            Pair(intArrayOf(1, 2, 3, 4, 5, 6, 7), 1),
            Pair(intArrayOf(1, 2, 3, 4, 5, 6, 7), 2),
            Pair(intArrayOf(1, 2, 3, 4, 5, 6, 7), 3)
        )
        input.forEach {
            rotate(it.first, it.second)
            println(it.first.joinToString())
        }
    }

    // Follow up: Could you do it in-place with O(1) extra space?
    fun rotate(nums: IntArray, k: Int): Unit {
        val kk = k % nums.size
        if (kk != 0) {
            var start = 0
            var numOfRotate = 0
            var temp: Int
            while (numOfRotate < nums.size) {
                var index = start
                temp = nums[index]
                while (numOfRotate < nums.size) {
                    numOfRotate++
                    val nextIndex = (index + kk) % nums.size
                    temp = nums[nextIndex].also { nums[nextIndex] = temp }
                    index = nextIndex
                    if (index == start) {
                        break
                    }
                }
                start++
            }
        }
    }
}