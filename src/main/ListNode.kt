package main

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    companion object {
        fun makeListNode(input: List<Int>): ListNode? {
            return if (input.isEmpty()) {
                null
            } else {
                val root = ListNode(input.first())
                var pointer = root
                (1 until input.size).forEach {
                    pointer.next = ListNode(input[it])
                    pointer = pointer.next!!
                }
                root
            }
        }
    }

    override fun toString(): String {
        var temp: ListNode? = this
        var result = ""
        while (temp != null) {
            result += temp.`val`
            temp = temp.next
        }
        return result
    }
}