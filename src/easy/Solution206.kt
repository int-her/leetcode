package easy

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