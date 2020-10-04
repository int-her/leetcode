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
class Solution160 : Solution() {
    override fun test() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    // Your code should preferably run in O(n) time and use only O(1) memory.
    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        var result: ListNode? = null
        var isFind = false
        var pointer = headA
        while (pointer != null) {
            pointer.`val` = -pointer.`val`
            pointer = pointer.next
        }
        pointer = headB
        while (pointer != null) {
            if (pointer.`val` < 0 && !isFind) {
                result = pointer
                isFind = true
            }
            pointer.`val` = -pointer.`val`
            pointer = pointer.next
        }
        pointer = headA
        while (pointer != null) {
            pointer.`val` = -pointer.`val`
            pointer = pointer.next
        }
        pointer = headB
        while (pointer != null) {
            pointer.`val` = -pointer.`val`
            pointer = pointer.next
        }
        return result
    }
}