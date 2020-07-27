package hard

import java.util.*

class MedianFinder() {
    /** initialize your data structure here. */
    private val minPriorityQueue = PriorityQueue<Int> { a, b -> b - a }
    private val maxPriorityQueue = PriorityQueue<Int> { a, b -> a - b }

    fun addNum(num: Int) {
        if (minPriorityQueue.isEmpty() || minPriorityQueue.peek() >= num) minPriorityQueue.add(num) else maxPriorityQueue.add(num)
        if (minPriorityQueue.size > maxPriorityQueue.size + 1) maxPriorityQueue.add(minPriorityQueue.poll())
        if (maxPriorityQueue.size > minPriorityQueue.size) minPriorityQueue.add(maxPriorityQueue.poll())
    }

    fun findMedian(): Double {
        return if (minPriorityQueue.size == maxPriorityQueue.size) {
            (minPriorityQueue.peek() + maxPriorityQueue.peek()).toDouble() / 2
        } else {
            minPriorityQueue.peek().toDouble()
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * var obj = MedianFinder()
 * obj.addNum(num)
 * var param_2 = obj.findMedian()
 */