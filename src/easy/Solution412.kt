package easy

import Solution

class Solution412 : Solution() {
    override fun test() {
        val input = arrayOf(
            0, 1, 15
        )
        input.forEach { println(fizzBuzz(it)) }
    }

    fun fizzBuzz(n: Int): List<String> {
        return (1..n).map {
            when (it % 15) {
                3, 6, 9, 12 -> "Fizz"
                5, 10 -> "Buzz"
                0 -> "FizzBuzz"
                else -> it.toString()
            }
        }
    }
}