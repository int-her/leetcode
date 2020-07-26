class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null

    override fun toString(): String {
        var temp: Node? = this
        var result = ""
        while (temp != null) {
            result += temp.`val`
            temp = temp.next
        }
        return result
    }
}