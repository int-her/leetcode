package easy

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
class Solution206 : Solution() {
    override fun test() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun reverseList(head: ListNode?): ListNode? {
        var result: ListNode? = null
        var pointer = head
        while (pointer != null) {
            val node = ListNode(pointer.`val`)
            node.next = result
            result = node
            pointer = pointer.next
        }
        return result
    }
}