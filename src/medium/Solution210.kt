package medium

import Solution

class Solution210 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(2, arrayOf(intArrayOf(1, 0))),
            Pair(4, arrayOf(intArrayOf(1, 0), intArrayOf(2, 0), intArrayOf(3, 1), intArrayOf(3, 2))),
            Pair(1, arrayOf()),
            Pair(2, arrayOf(intArrayOf(1, 0), intArrayOf(0, 1)))
        )
        input.forEach { println(findOrder(it.first, it.second).joinToString()) }
    }

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val a = mutableMapOf<Int, MutableSet<Int>>()
        val b = mutableMapOf<Int, MutableSet<Int>>()
        val result = mutableListOf<Int>()
        a.putAll((0 until numCourses).map { Pair(it, mutableSetOf<Int>()) })
        b.putAll((0 until numCourses).map { Pair(it, mutableSetOf<Int>()) })
        prerequisites.forEach {
            a[it[1]]!!.add(it[0])
            b[it[0]]!!.add(it[1])
        }
        while (true) {
            val satisfyingCourses = b
                .filter { it.value.isEmpty() }
                .also { courses ->
                    courses.forEach { (pre, _) ->
                        a[pre]!!.forEach { post -> b[post]!!.remove(pre) }
                        b.remove(pre)
                    }
                }
            if (satisfyingCourses.isEmpty()) {
                break
            }
            result.addAll(satisfyingCourses.keys)
        }
        return if (result.size == numCourses) result.toIntArray() else intArrayOf()
    }
}