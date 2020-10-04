package medium

import main.Solution

class Solution179 : Solution() {
    class CustomComparator : Comparator<Int> {
        override fun compare(o1: Int?, o2: Int?): Int {
            val s1 = o1!!.toString()
            val s2 = o2!!.toString()
            val minLen = s1.length.coerceAtMost(s2.length)
            return s2.substring(0, minLen).compareTo(s1.substring(0, minLen)).takeIf { it != 0 } ?: let {
                s2.repeat(s1.length).compareTo(s1.repeat(s2.length))
            }
        }
    }

    override fun test() {
        val input = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(10, 2),
            intArrayOf(3, 30, 34, 5, 9),
            intArrayOf(121, 12)
        )
        input.forEach { println(largestNumber(it)) }
    }

    fun largestNumber(nums: IntArray): String {
        return nums.sortedWith(CustomComparator()).joinToString(separator = "").takeIf { !it.startsWith('0') } ?: "0"
    }
}