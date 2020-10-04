package medium

import main.NestedInteger

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * class main.NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     constructor()
 *
 *     // Constructor initializes a single integer.
 *     constructor(value: Int)
 *
 *     // @return true if this main.NestedInteger holds a single integer, rather than a nested list.
 *     fun isInteger(): Boolean
 *
 *     // @return the single integer that this main.NestedInteger holds, if it holds a single integer
 *     // Return null if this main.NestedInteger holds a nested list
 *     fun getInteger(): Int?
 *
 *     // Set this main.NestedInteger to hold a single integer.
 *     fun setInteger(value: Int): Unit
 *
 *     // Set this main.NestedInteger to hold a nested list and adds a nested integer to it.
 *     fun add(ni: main.NestedInteger): Unit
 *
 *     // @return the nested list that this main.NestedInteger holds, if it holds a nested list
 *     // Return null if this main.NestedInteger holds a single integer
 *     fun getList(): List<main.NestedInteger>?
 * }
 */

class NestedIterator(nestedList: List<NestedInteger>) {
    private var flattenList = mutableListOf<Int>()
    private var index = 0

    init {
        flatten(nestedList, flattenList)
    }

    private fun flatten(nestedList: List<NestedInteger>, flattenList: MutableList<Int>) {
        nestedList.forEach { nestedInteger ->
            if (nestedInteger.isInteger()) {
                flattenList.add(nestedInteger.getInteger()!!)
            } else {
                flatten(nestedInteger.getList()!!, flattenList)
            }
        }
    }

    fun next(): Int = flattenList[index++]

    fun hasNext(): Boolean = index < flattenList.size
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * var obj = NestedIterator(nestedList)
 * var param_1 = obj.next()
 * var param_2 = obj.hasNext()
 */