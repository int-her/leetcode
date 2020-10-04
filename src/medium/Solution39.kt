package medium

import main.Solution

class Solution39 : Solution() {
    // max - target - solution set
    val dp: Array<Array<List<List<Int>>>> = Array(201) { Array(501) { listOf<List<Int>>() } }
    val isChecked: Array<Array<Boolean>> = Array(201) { Array(501) { false } }

    override fun test() {
        println(combinationSum(intArrayOf(2, 3, 6, 7), target = 7))
        println(combinationSum(intArrayOf(2, 3, 5), target = 8))
    }

    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        if (candidates.size == 1) {
            return if (target % candidates.first() == 0) listOf(List(target / candidates.first()) { candidates.first() }) else emptyList()
        }
        val result: MutableList<List<Int>> = mutableListOf()
        (0..(target / candidates.last())).forEach {
            val nextMaxCandidate = candidates[candidates.size - 2]
            val nextTarget = target - candidates.last() * it
            if (nextTarget == 0) {
                result.add(List(it) { candidates.last() })
            } else {
                if (!isChecked[nextMaxCandidate][nextTarget]) {
                    dp[nextMaxCandidate][nextTarget] = combinationSum(candidates.copyOfRange(0, candidates.size - 1), nextTarget)
                    isChecked[nextMaxCandidate][nextTarget] = true
                }
                result.addAll(dp[nextMaxCandidate][nextTarget].map { subSolution ->
                    subSolution + List(it) { candidates.last() }
                })
            }
        }
        return result
    }
}