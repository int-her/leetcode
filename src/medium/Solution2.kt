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
class Solution2 : Solution() {
    override fun test() {
        val l1 = ListNode(2)
        l1.next = ListNode(4)
        l1.next!!.next = ListNode(3)
        l1.next!!.next!!.next = ListNode(1)
        val l2 = ListNode(5)
        l2.next = ListNode(6)
        l2.next!!.next = ListNode(4)
        println(addTwoNumbers(l1, l2))
    }
    
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val out = ListNode(0)
        add(out, l1!!)
        add(out, l2!!)
        carry(out)
        return out
    }
    
    fun add(out: ListNode, l: ListNode) {
        var outPointer: ListNode = out
        var lPointer: ListNode? = l
        while (lPointer != null) {
            outPointer.`val` += lPointer.`val`
            if (lPointer.next != null && outPointer.next == null) {
                outPointer.next = ListNode(0)
            }
            lPointer = lPointer.next
            outPointer = outPointer.next ?: return
        }
    }

    fun carry(out: ListNode) {
        var outPointer: ListNode? = out
        while (outPointer != null) {
            if (outPointer.`val` >= 10) {
                outPointer.next?.let { it.`val` += outPointer!!.`val` / 10 } ?: let { outPointer!!.next = ListNode(outPointer!!.`val` / 10) }
                outPointer.`val` %= 10
            }
            outPointer = outPointer.next
        }
    }
}