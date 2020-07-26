package medium

import ListNode
import Solution

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution141 : Solution() {
    override fun test() {
        val input1 = ListNode(3)
        input1.next = ListNode(2)
        input1.next!!.next = ListNode(0)
        input1.next!!.next!!.next = ListNode(-4)
        input1.next!!.next!!.next!!.next = input1.next

        val input2 = ListNode(1)
        input2.next = ListNode(2)
        input2.next!!.next = input2

        val input3 = ListNode(1)

        println(hasCycle(input1))
        println(hasCycle(input2))
        println(hasCycle(input3))
    }

    fun hasCycle(head: ListNode?): Boolean {
        val copy = mutableSetOf<ListNode>()
        var pointer = head
        while (pointer != null) {
            if (copy.contains(pointer)) {
                return true
            }
            copy.add(pointer)
            pointer = pointer.next
        }
        return false
    }
}