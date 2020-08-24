package easy

import Solution

class Solution217 : Solution() {
    override fun test() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun containsDuplicate(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()
        for (num in nums) {
            if (set.contains(num)) {
                return true
            } else {
                set.add(num)
            }
        }
        return false
    }
}