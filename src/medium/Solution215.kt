package medium

import main.Solution

class Solution215 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(intArrayOf(3, 2, 1, 5, 6, 4), 2),
            Pair(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4),
            Pair(intArrayOf(3, 3, 3, 3, 3, 3, 3, 3, 3, 3), 8)
        )
        input.forEach { println(findKthLargest(it.first, it.second)) }
    }

    fun findKthLargest(nums: IntArray, k: Int): Int {
        return when (k) {
            1 -> nums.max()!!
            nums.size -> nums.min()!!
            else -> {
                val pivot = nums.random()
                val split1 = mutableListOf<Int>()
                val split2 = mutableListOf<Int>()
                var count = 0
                nums.forEach {
                    when {
                        it > pivot -> split1.add(it)
                        it == pivot -> count++
                        else -> split2.add(it)
                    }
                }
//                println("$pivot $split1 $split2")
                if (split1.size < k) {
                    if (split1.size + count >= k) {
                        pivot
                    } else {
                        findKthLargest(split2.toIntArray(), k - split1.size - count)
                    }
                } else {
                    findKthLargest(split1.toIntArray(), k)
                }
            }
        }
    }
}