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
class Solution328 : Solution() {
    override fun test() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun oddEvenList(head: ListNode?): ListNode? {
        return try {
            var oddEnd = head
            val evenStart = head!!.next
            var evenEnd = evenStart
            while (true) {
                val newOdd = evenEnd!!.next
                evenEnd.next = newOdd!!.next
                oddEnd!!.next = newOdd
                newOdd.next = evenStart
                oddEnd = oddEnd.next
                evenEnd = evenEnd.next
            }
            head
        } catch (e: Exception) {
            head
        }
    }
}