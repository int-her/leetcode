package medium

import main.Solution

class Solution17 : Solution() {
    override fun test() {
        val input = "23"
        println(letterCombinations(input))
    }

    fun letterCombinations(digits: String): List<String> {
        var output = mutableListOf("")
        var temp = mutableListOf<String>()
        digits.forEach { letter ->
            when (letter) {
                '2' -> temp.addAll(output.flatMap { listOf("${it}a", "${it}b", "${it}c") })
                '3' -> temp.addAll(output.flatMap { listOf("${it}d", "${it}e", "${it}f") })
                '4' -> temp.addAll(output.flatMap { listOf("${it}g", "${it}h", "${it}i") })
                '5' -> temp.addAll(output.flatMap { listOf("${it}j", "${it}k", "${it}l") })
                '6' -> temp.addAll(output.flatMap { listOf("${it}m", "${it}n", "${it}o") })
                '7' -> temp.addAll(output.flatMap { listOf("${it}p", "${it}q", "${it}r", "${it}s") })
                '8' -> temp.addAll(output.flatMap { listOf("${it}t", "${it}u", "${it}v") })
                '9' -> temp.addAll(output.flatMap { listOf("${it}w", "${it}x", "${it}y", "${it}z") })
            }
            output = temp
            temp = mutableListOf()
        }
        return if (output.first().isBlank()) emptyList() else output
    }
}