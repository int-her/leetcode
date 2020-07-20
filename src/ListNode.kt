class ListNode(var `val`: Int) {
    var next: ListNode? = null

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