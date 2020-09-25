package easy

import Solution

class Solution326 : Solution() {
    override fun test() {
        TODO("Not yet implemented")
    }

    fun isPowerOfThree(n: Int): Boolean {
        return n > 0 && 1162261467 % n == 0
    }
}