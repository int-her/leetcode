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
class Solution19 : Solution() {
    override fun test() {
        val head = ListNode(1)
        head.next = ListNode(2)
        head.next!!.next = ListNode(3)
        head.next!!.next!!.next = ListNode(4)
        head.next!!.next!!.next!!.next = ListNode(5)
        println(removeNthFromEnd(head, 2))
    }

    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val nodeList: MutableList<ListNode> = mutableListOf()
        var pointer = head
        while (pointer != null) {
            nodeList.add(pointer)
            pointer = pointer.next
        }
        return when (n) {
            nodeList.size -> head!!.next
            1 -> {
                nodeList[nodeList.size - 2].next = null
                head
            }
            else -> {
                nodeList[nodeList.size - n - 1].next = nodeList[nodeList.size - n + 1]
                head
            }
        }
    }
}