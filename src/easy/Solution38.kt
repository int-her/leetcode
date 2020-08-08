package easy

import Solution

class Solution38 : Solution() {
    override fun test() {
        (1..10).forEach { println(countAndSay(it)) }
    }

    fun countAndSay(n: Int): String {
        return when (n) {
            1 -> "1"
            else -> {
                val previous = countAndSay(n - 1)
                var result = ""
                var index = 1
                var count = 1
                var char = previous.first()
                while (index < previous.length) {
                    if (char != previous[index]) {
                        result += "$count$char"
                        count = 1
                    } else {
                        count++
                    }
                    char = previous[index++]
                }
                result + "$count$char"
            }
        }
    }
}