package medium

import Solution

class Solution406 : Solution() {
    override fun test() {
        val input = arrayOf(
            arrayOf(),
            arrayOf(intArrayOf(10, 0)),
            arrayOf(intArrayOf(7, 0), intArrayOf(4, 4), intArrayOf(7, 1), intArrayOf(5, 0), intArrayOf(6, 1), intArrayOf(5, 2))
        )
        input.forEach { println(reconstructQueue(it).joinToString { a -> "[${a.first()}, ${a.last()}]" }) }
    }

    fun reconstructQueue(people: Array<IntArray>): Array<IntArray> {
//        val result = people.filter { it.last() == 0 }.sortedBy { it.first() }.map { intArrayOf(it.first(), it.last()) }.toMutableList()
        val result = mutableListOf<IntArray>()
        var k = 0
        while (result.size < people.size) {
            val list = people.filter { it.last() == k }.sortedBy { it.first() }
            list.indices.forEach { index ->
                var count = 0
                var pointer = 0
                while (pointer < result.size && count <= list[index].last()) {
                    if (result[pointer].first() >= list[index].first()) {
                        count++
                    }
                    pointer++
                }
                if (count > list[index].last()) {
                    pointer--
                }
                result.add(pointer, intArrayOf(list[index].first(), list[index].last()))
            }
            k++
        }
        return result.toTypedArray()
    }
}