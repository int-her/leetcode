package kakao.y2021

import main.Solution

class SolutionK2 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"), intArrayOf(2, 3, 4)),
            Pair(arrayOf("ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"), intArrayOf(2, 3, 5)),
            Pair(arrayOf("XYZ", "XWY", "WXA"), intArrayOf(2, 3, 4))
        )
        input.forEach { println(solution(it.first, it.second).joinToString()) }
    }

    fun solution(orders: Array<String>, course: IntArray): Array<String> {
        val result = mutableListOf<String>()
        course.forEach { numOfDishes ->
            val frequency = mutableMapOf<String, Int>()
            orders.forEach { order ->
                val combination = mutableListOf<String>()
                helper(order.toList().sorted().joinToString(separator = ""), numOfDishes, "", combination)
                combination.forEach { frequency[it] = (frequency[it] ?: 0) + 1 }
            }
            frequency.values.max()?.takeIf { it >= 2 }.let { max ->
                result.addAll(frequency.filterValues { it == max }.keys)
            }
        }
        return result.sorted().toTypedArray()
    }

    fun helper(n: String, c: Int, picked: String, result: MutableList<String>) {
        when (c) {
            0 -> result.add(picked)
            else -> (0..n.length - c).forEach {
                helper(n.substring(it + 1), c - 1, picked + n[it], result)
            }
        }
    }
}