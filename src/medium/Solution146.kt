package medium

class LRUCache(private val capacity: Int) {
    private val cache = mutableMapOf<Int, Int>()
    private val used = mutableMapOf<Int, Pair<Int?, Int?>>()
    private var leastRecentlyUsedKey = -1
    private var mostRecentlyUsedKey = -1

    fun test() {
        val cache = LRUCache(2 /* capacity */)
        cache.put(1, 1)
        cache.put(2, 2)
        cache.get(1) // returns 1
        cache.put(3, 3) // evicts key 2
        cache.get(2) // returns -1 (not found)
        cache.put(4, 4) // evicts key 1
        cache.get(1) // returns -1 (not found)
        cache.get(3) // returns 3
        cache.get(4) // returns 4
    }

    // Follow up: Could you do both operations in O(1) time complexity?
    fun get(key: Int): Int {
        println(cache[key]?.also { put(key, it) } ?: -1)
        return cache[key]?.also { put(key, it) } ?: -1
    }

    fun put(key: Int, value: Int) {
        if (capacity > 0) {
            if (cache[key] != null) {
                cache[key] = value
                val remove = used[key]!!
                if (mostRecentlyUsedKey != key) {
                    remove.first?.also { used[it] = Pair(used[it]!!.first, remove.second) } ?: let { leastRecentlyUsedKey = remove.second!! }
                    remove.second?.let { used[it] = Pair(remove.first, used[it]!!.second) }
                    used[mostRecentlyUsedKey] = Pair(used[mostRecentlyUsedKey]!!.first, key)
                    used[key] = Pair(mostRecentlyUsedKey, null)
                }
            } else {
                cache[key] = value
                used[key] = Pair(mostRecentlyUsedKey, null)
                if (cache.size <= capacity) {
                    if (leastRecentlyUsedKey == -1) {
                        leastRecentlyUsedKey = key
                        used[key] = Pair(null, null)
                    } else {
                        used[mostRecentlyUsedKey] = Pair(used[mostRecentlyUsedKey]!!.first, key)
                    }
                } else {
                    val newLeastRecentUsedKey = used[leastRecentlyUsedKey]!!.second
                    used[leastRecentlyUsedKey]!!.second?.let { used[it] = Pair(null, used[it]!!.second) }
                    used.remove(leastRecentlyUsedKey)
                    cache.remove(leastRecentlyUsedKey)
                    newLeastRecentUsedKey?.let {
                        leastRecentlyUsedKey = it
                        used[mostRecentlyUsedKey] = Pair(used[mostRecentlyUsedKey]!!.first, key)
                    } ?: let {
                        leastRecentlyUsedKey = key
                        used[key] = Pair(null, null)
                    }
                }
            }
            mostRecentlyUsedKey = key
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * var obj = LRUCache(capacity)
 * var param_1 = obj.get(key)
 * obj.put(key,value)
 */