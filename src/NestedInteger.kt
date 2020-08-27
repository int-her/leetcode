class NestedInteger(var value: Int? = null) {
    private val nestedList: MutableList<NestedInteger> = mutableListOf()

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    fun isInteger(): Boolean = value != null

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    fun getInteger(): Int? = value

    // Set this NestedInteger to hold a single integer.
    fun setInteger(value: Int): Unit {
        nestedList.clear()
        this.value = value
    }

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    fun add(ni: NestedInteger): Unit {
        if (value != null) {
            nestedList.add(NestedInteger(value))
            value = null
        }
        nestedList.add(ni)
    }

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    fun getList(): List<NestedInteger>? = nestedList.takeIf { value == null }
}