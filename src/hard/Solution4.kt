package hard

import main.Solution

class Solution4 : Solution() {
    override fun test() {
        val nums1 = intArrayOf()
        val nums2 = intArrayOf(1, 2, 4, 8, 9, 10)
        val nums3 = intArrayOf(4, 5)
        val nums4 = intArrayOf(1, 2, 3, 6)
        println(findMedianSortedArrays(nums1, nums2))
        println(findMedianSortedArrays(nums3, nums4))
    }

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        if (nums1.isEmpty()) {
            return if (nums2.size % 2 == 0) (nums2[nums2.size / 2 - 1] + nums2[nums2.size / 2]).toDouble() / 2 else nums2[nums2.size / 2].toDouble()
        }
        if (nums2.isEmpty()) {
            return if (nums1.size % 2 == 0) (nums1[nums1.size / 2 - 1] + nums1[nums1.size / 2]).toDouble() / 2 else nums1[nums1.size / 2].toDouble()
        }
        if (nums1.size + nums2.size < 5) {
            val nums3 = nums1 + nums2
            nums3.sort()
            return if (nums3.size % 2 == 0) (nums3[(nums3.size - 1) / 2] + nums3[nums3.size / 2]).toDouble() / 2 else nums3[(nums3.size - 1) / 2].toDouble()
        }
        val nums3 = if (nums1.size >= nums2.size) nums1 else nums2
        val nums4 = if (nums1.size >= nums2.size) nums2 else nums1
        if (nums4.size == 1) {
            return if (nums3.size % 2 == 0) {
                (if (nums3[nums3.size / 2 - 1] >= nums4.first()) {
                    nums3[nums3.size / 2 - 1]
                } else {
                    if (nums3[nums3.size / 2] > nums4.first()) nums4.first() else nums3[nums3.size / 2]
                }).toDouble()
            } else {
                (if (nums3[nums3.size / 2] >= nums4.first()) {
                    if (nums3[nums3.size / 2 - 1] > nums4.first()) (nums3[nums3.size / 2 - 1] + nums3[nums3.size / 2]) else (nums4.first() + nums3[nums3.size / 2])
                } else {
                    if (nums3[nums3.size / 2 + 1] > nums4.first()) (nums3[nums3.size / 2] + nums4.first()) else (nums3[nums3.size / 2] + nums3[nums3.size / 2 + 1])
                }).toDouble() / 2
            }
        }
        // target: i + j = (nums3.size + nums4.size - 3) / 2
        var i = (nums3.size - 1) / 2
        var j = (nums3.size + nums4.size - 3) / 2 - i
        var minJ = -1
        var maxJ = nums4.size - 1
        while (j != -1 && j != nums4.size - 1) {
            println("i: $i, j: $j")
            if ((j < nums4.size - 1 && nums3[i] <= nums4[j + 1]) && (i < nums3.size - 1 && nums4[j] <= nums3[i + 1])) {
                break
            }
            if (nums3[i] > nums4[j]) {
                minJ = j
                j = minJ + (maxJ - minJ + 1) / 2
                i = (nums3.size + nums4.size - 3) / 2 - j
            } else {
                maxJ = j
                j = minJ + (maxJ - minJ) / 2
                i = (nums3.size + nums4.size - 3) / 2 - j
            }
        }
        println("i: $i, j: $j")
        return if (j == -1) {
            if ((nums3.size + nums4.size) % 2 == 0) {
                if (i == nums3.size - 1) {
                    (nums3.last() + nums4.first()).toDouble() / 2
                } else {
                    val a = nums3[i]
                    val b = if (nums3[i + 1] < nums4.first()) nums3[i + 1] else nums4.first()
                    (a + b).toDouble() / 2
                }
            } else {
                nums3[i].toDouble()
            }
        } else if (j == nums4.size - 1) {
            if ((nums3.size + nums4.size) % 2 == 0) {
                if (i == -1) {
                    (nums4.last() + nums3.first()).toDouble() / 2
                } else {
                    val a = if (nums3[i] > nums4.last()) nums3[i] else nums4.last()
                    val b = nums3[i + 1]
                    (a + b).toDouble() / 2
                }
            } else {
                (if (nums3[i] > nums4.last()) nums3[i] else nums4.last()).toDouble()
            }
        } else {
            if ((nums3.size + nums4.size) % 2 == 0) {
                val a = if (nums3[i] > nums4[j]) nums3[i] else nums4[j]
                val b = if (nums3[i + 1] > nums4[j + 1]) nums4[j + 1] else nums3[i + 1]
                (a + b).toDouble() / 2
            } else {
                if (nums3[i] > nums4[j]) nums3[i].toDouble() else nums4[j].toDouble()
            }
        }
    }
}