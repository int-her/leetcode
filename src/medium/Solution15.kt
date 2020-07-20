package medium

import Solution

class Solution15 : Solution() {
    override fun test() {
        val nums = intArrayOf(-1, 0, 1, 2, -1, 4)
        println(threeSum(nums))
    }

    fun threeSum(nums: IntArray): List<List<Int>> {
        val negative = mutableMapOf<Int, Int>()
        var zero = 0
        val positive = mutableMapOf<Int, Int>()
        val solutions: MutableList<List<Int>> = mutableListOf()
        nums.forEach {
            when {
                it < 0 -> negative[it] = negative[it]?.let { count -> count + 1 } ?: 1
                it == 0 -> zero++
                it > 0 -> positive[it] = positive[it]?.let { count -> count + 1 } ?: 1
            }
        }

        if (zero >= 3) {
            solutions.add(listOf(0, 0, 0))
        }
        if (zero >= 1) {
            negative.forEach { (key, _) ->
                positive[key * -1]?.let {
                    solutions.add(listOf(key, 0, key * -1))
                }
            }
        }
        negative.forEach { (key, value) ->
            negative.forEach { (subKey, _) ->
                if (key < subKey) {
                    positive[(key + subKey) * -1]?.let {
                        solutions.add(listOf(key, subKey, (key + subKey) * -1))
                    }
                }
            }
            if (value >= 2) {
                positive[key * -2]?.let {
                    solutions.add(listOf(key, key, key * -2))
                }
            }
        }
        positive.forEach { (key, value) ->
            positive.forEach { (subKey, _) ->
                if (key < subKey) {
                    negative[(key + subKey) * -1]?.let {
                        solutions.add(listOf(key, subKey, (key + subKey) * -1))
                    }
                }
            }
            if (value >= 2) {
                negative[key * -2]?.let {
                    solutions.add(listOf(key, key, key * -2))
                }
            }
        }
        return solutions
    }
}