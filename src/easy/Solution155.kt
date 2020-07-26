package easy

class MinStack() {
    /** initialize your data structure here. */
    val data = mutableListOf<Int>()
    val minData = mutableListOf<Int>()

    fun push(x: Int) {
        data.add(x)
        if (x <= minData.lastOrNull() ?: Int.MAX_VALUE) {
            minData.add(x)
        }
    }

    fun pop() {
        if (minData.last() == data.removeAt(data.lastIndex)) {
            minData.removeAt(minData.lastIndex)
        }
    }

    fun top(): Int {
        return data.last()
    }

    fun getMin(): Int {
        return minData.last()
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * var obj = MinStack()
 * obj.push(x)
 * obj.pop()
 * var param_3 = obj.top()
 * var param_4 = obj.getMin()
 */