package medium

import main.Solution

class Solution127 : Solution() {
    override fun test() {
        val input = arrayOf(
            Triple("hit", "cog", listOf("hot", "dot", "dog", "lot", "log", "cog")),
            Triple("hit", "cog", listOf("hot", "dot", "dog", "lot", "log"))
        )
        input.forEach { println(ladderLength(it.first, it.second, it.third)) }
    }

    fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {
        var words = wordList.filter { it != beginWord }
        var begins = listOf(beginWord)
        var count = 1
        while (begins.isNotEmpty()) {
            words.groupBy {
                begins.any { word -> it.zip(word) { a, b -> a == b }.count { !it } == 1 }
            }.also {
                words = it[false] ?: emptyList()
                begins = it[true] ?: emptyList()
                count++
            }
            if (endWord in begins) {
                return count
            }
        }
        return 0
    }
}