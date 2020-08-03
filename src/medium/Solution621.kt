package medium

import Solution

class Solution621 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 2),
            Pair(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 0),
            Pair(charArrayOf('A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'), 2)
        )
        input.forEach { println(leastInterval(it.first, it.second)) }
    }

    fun leastInterval(tasks: CharArray, n: Int): Int {
        val count = tasks.groupBy { it }.mapValues { it.value.size }.toMutableMap()
        var time = 0
        var lastIdleTime = n + 1
        while (count.values.any { it != 0 }) {
            lastIdleTime = n + 1
            count.toList().sortedByDescending { it.second }.filter { it.second != 0 }.let { if (it.size > n + 1) it.subList(0, n + 1) else it }.forEach { (task, _) ->
                count[task] = count[task]!! - 1
                lastIdleTime--
            }
            time += n + 1
        }
        return time - lastIdleTime
    }
}