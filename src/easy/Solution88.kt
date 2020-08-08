package easy

import Solution

class Solution88 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(intArrayOf(1, 2, 3, 0, 0, 0), intArrayOf(2, 5, 6))
        )
        input.forEach {
            merge(it.first, it.first.size - it.second.size, it.second, it.second.size)
            println(it.first.joinToString())
        }
    }

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var index = nums1.lastIndex
        var mIndex = m - 1
        var nIndex = n - 1
        while (mIndex >= 0 && nIndex >= 0) {
            nums1[index--] = if (nums1[mIndex] >= nums2[nIndex]) nums1[mIndex--] else nums2[nIndex--]
        }
        while (mIndex >= 0) {
            nums1[index--] = nums1[mIndex--]
        }
        while (nIndex >= 0) {
            nums1[index--] = nums2[nIndex--]
        }
    }
}