package medium

import Solution
import kotlin.math.sign

class Solution56 : Solution() {
    override fun test() {
        val input = listOf(
            arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18)),
            arrayOf(intArrayOf(1, 4), intArrayOf(4, 5)),
            arrayOf(intArrayOf(4, 5), intArrayOf(1, 4)),
            arrayOf(intArrayOf(1, 2), intArrayOf(4, 5)),
            arrayOf(intArrayOf(2, 3), intArrayOf(4, 5), intArrayOf(6, 7), intArrayOf(8, 9), intArrayOf(1, 10)),
            arrayOf(intArrayOf(0, 0))
        )
        input.forEach { println(merge(it).joinToString { subArray -> subArray.joinToString() })}
    }

    // O(n^2) or O(nm)
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        for (i in intervals.indices) {
            if (intervals[i].isNotEmpty()) {
                for (j in (i + 1 until intervals.size)) {
                    if (intervals[j].isNotEmpty()) {
                        val (a, b, c, d) = if ((intervals[i].first() - intervals[j].first()).sign * 2 + (intervals[i].last() - intervals[j].last()).sign <= 0) {
                            intervals[i] + intervals[j]
                        } else {
                            intervals[j] + intervals[i]
                        }
                        if (b >= d) {
                            intervals[j] = intArrayOf(a, b)
                            intervals[i] = intArrayOf()
                            break
                        } else if (b >= c) {
                            intervals[j] = intArrayOf(a, d)
                            intervals[i] = intArrayOf()
                            break
                        }
                    }
                }
            }
        }
        return intervals.filter { it.isNotEmpty() }.toTypedArray()
    }
}