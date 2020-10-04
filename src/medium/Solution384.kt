package medium

import java.util.*

class Solution384(val nums: IntArray) {
    private val rand = Random()

    /** Resets the array to its original configuration and return it. */
    fun reset(): IntArray = nums

    /** Returns a random shuffling of the array. */
    fun shuffle(): IntArray {
        return nums.clone().also { shuffled ->
            shuffled.indices.forEach { index ->
                val randIndex = rand.nextInt(shuffled.size - index) + index
                shuffled[index] = shuffled[randIndex].also { shuffled[randIndex] = shuffled[index] }
            }
        }
    }

}

/**
 * Your main.Solution object will be instantiated and called as such:
 * var obj = main.Solution(nums)
 * var param_1 = obj.reset()
 * var param_2 = obj.shuffle()
 */