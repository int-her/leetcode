package medium

import main.Solution

class Solution134 : Solution() {
    override fun test() {
        val input = arrayOf(
//            Pair(intArrayOf(1, 2, 3, 4, 5), intArrayOf(3, 4, 5, 1, 2)),
//            Pair(intArrayOf(2, 3, 4), intArrayOf(3, 4, 3)),
            Pair(intArrayOf(3, 3, 4), intArrayOf(3, 4, 4))
        )
        input.forEach { println(canCompleteCircuit(it.first, it.second)) }
    }

    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
        val size = gas.size
        var start = gas.indices.firstOrNull { gas[it] >= cost[it % size] } ?: return -1
        var rest = gas[start]
        var now = start
        while (start < size) {
            if (now < start) {
                rest = gas[start]
                now = start
            }
            while (rest >= cost[now]) {
                rest -= cost[now]
                now = (now + 1) % size
                if (now == start) {
                    return start
                }
                rest += gas[now]
            }
            while (true) {
                rest -= gas[start]
                rest += cost[start]
                start++
                if (start == size || gas[start] >= cost[start]) {
                    break
                }
            }
        }
        return -1
    }
}