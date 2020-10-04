package medium

import main.ListNode
import main.Solution

/**
 * Example:
 * var li = main.ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class main.ListNode(var `val`: Int) {
 *     var next: main.ListNode? = null
 * }
 */
class Solution148 : Solution() {
    override fun test() {
        val input = arrayOf(
            ListNode.makeListNode(listOf(4, 2, 1, 3)),
            ListNode.makeListNode(listOf(-1, 5, 3, 4, 0))
        )
        input.forEach { println(sortList(it)) }
    }

    fun sortList(head: ListNode?): ListNode? {
        return head?.let { helper(it, it.next) }
    }

    fun helper(head: ListNode?, tail: ListNode?): ListNode? {
        return tail?.let {
            val sorted = helper(tail, tail.next)
            val result: ListNode? = ListNode(head!!.`val`).also { it.next = sorted }
            var pointer = result
            while (pointer!!.next != null) {
                if (pointer.`val` > pointer.next!!.`val`) {
                    pointer.`val` = pointer.next!!.`val`.also { pointer!!.next!!.`val` = pointer!!.`val` }
                }
                pointer = pointer.next
            }
            result
        } ?: head
    }
}