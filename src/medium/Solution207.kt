package medium

import Solution

class Solution207 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(2, arrayOf(intArrayOf(1, 0))),
            Pair(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1)))
        )
        input.forEach { println(canFinish(it.first, it.second)) }
    }

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val map = mutableMapOf<Int, List<Int>>()
        val isVisited = BooleanArray(numCourses)
        prerequisites.forEach {
            map[it.last()] = (map[it.last()] ?: emptyList()) + listOf(it.first())
        }
        while (true) {
            var count = 0
            (0 until numCourses).forEach {
                if (!isVisited[it]) {
                    val isPossible = (map[it] ?: emptyList()).foldRight(true) { course, isPossible -> isVisited[course] && isPossible }
                    if (isPossible) {
                        isVisited[it] = true
                        count++
                    }
                }
            }
            if (count == 0) {
                return isVisited.all { it }
            }
        }
    }
}