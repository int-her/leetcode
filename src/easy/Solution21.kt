package easy

import main.ListNode
import main.Solution

class Solution21 : Solution() {
    override fun test() {
        val l1 = ListNode(1)
        l1.next = ListNode(2)
        l1.next!!.next = ListNode(4)
        val l2 = ListNode(1)
        l2.next = ListNode(3)
        l2.next!!.next = ListNode(4)
        println(mergeTwoLists(null, null))
    }

    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        var l1Pointer = l1
        var l2Pointer = l2
        val result = ListNode(0)
        var resultPointer = result
        while (l1Pointer != null && l2Pointer != null) {
            if (l1Pointer.`val` > l2Pointer.`val`) {
                resultPointer.next = ListNode(l2Pointer.`val`)
                l2Pointer = l2Pointer.next
                resultPointer = resultPointer.next!!
            } else {
                resultPointer.next = ListNode(l1Pointer.`val`)
                l1Pointer = l1Pointer.next
                resultPointer = resultPointer.next!!
            }
        }
        if (l1Pointer != null) {
            resultPointer.next = l1Pointer
        } else {
            resultPointer.next = l2Pointer
        }
        return result.next
    }
}