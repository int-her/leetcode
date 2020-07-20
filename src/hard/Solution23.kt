package hard

import ListNode
import Solution
import java.util.*

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution23 : Solution() {
    override fun test() {
        val l1 = ListNode(1)
        l1.next = ListNode(4)
        l1.next!!.next = ListNode(5)
        val l2 = ListNode(1)
        l2.next = ListNode(3)
        l2.next!!.next = ListNode(4)
        val l3 = ListNode(2)
        l3.next = ListNode(6)
        println(mergeKLists(arrayOf(l1, l2, l3)))
    }

    class Value(val value: Int, val from: Int) : Comparable<Value> {
        override fun compareTo(other: Value): Int {
            return this.value - other.value
        }
    }

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val priorityQueue = PriorityQueue<Value>()
        val result = ListNode(0)
        var resultPointer = result
        lists.forEachIndexed { index, list ->
            if (list != null) {
                priorityQueue.add(Value(list.`val`, index))
                lists[index] = list.next
            }
        }
        while (priorityQueue.isNotEmpty()) {
            val value = priorityQueue.poll()
            resultPointer.next = ListNode(value.value)
            resultPointer = resultPointer.next!!
            if (lists[value.from] != null) {
                priorityQueue.add(Value(lists[value.from]!!.`val`, value.from))
                lists[value.from] = lists[value.from]!!.next
            }
        }

        return result.next
    }
}