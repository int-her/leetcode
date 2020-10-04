package medium

import main.Solution
import java.util.*

class Solution739 : Solution() {
    class Temperature(val value: Int, val from: Int) : Comparable<Temperature> {
        override fun compareTo(other: Temperature): Int {
            return this.value - other.value
        }
    }

    override fun test() {
        val input = intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)
        println(dailyTemperatures(input).joinToString())
    }

    fun dailyTemperatures(T: IntArray): IntArray {
        val priorityQueue = PriorityQueue<Temperature>()
        val result = IntArray(T.size) { 0 }
        T.forEachIndexed { index, value ->
            priorityQueue.add(Temperature(value, index))
            while (true) {
                val temperature = priorityQueue.poll()
                if (temperature.value == value) {
                    priorityQueue.add(Temperature(temperature.value, temperature.from))
                    break
                } else {
                    result[temperature.from] = index - temperature.from
                }
            }
        }
        return result
    }
}