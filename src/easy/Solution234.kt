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
class Solution234 : Solution() {
    override fun test() {
        val input = arrayOf(
            ListNode.makeListNode(listOf()),
            ListNode.makeListNode(listOf(1)),
            ListNode.makeListNode(listOf(1, 2)),
            ListNode.makeListNode(listOf(1, 2, 2, 1))
        )
        input.forEach { println(isPalindrome(it)) }
    }

    // Follow up: Could you do it in O(n) time and O(1) space?
    fun isPalindrome(head: ListNode?): Boolean {
        return when (head) {
            null -> true
            else -> {
                var length = 0
                var pointer = head
                while (pointer != null) {
                    pointer = pointer.next
                    length++
                }
                pointer = head
                var temp: ListNode? = null
                var halfCount = 0
                while (halfCount < length / 2) {
                    val prev = pointer
                    pointer = pointer!!.next
                    prev!!.next = temp
                    temp = prev
                    halfCount++
                }
                if (length % 2 == 1) {
                    pointer = pointer!!.next
                }
                while (halfCount > 0) {
                    if (temp!!.`val` != pointer!!.`val`) {
                        return false
                    } else {
                        temp = temp.next
                        pointer = pointer.next
                    }
                    halfCount--
                }
                true
            }
        }
    }
}