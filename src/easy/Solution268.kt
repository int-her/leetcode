package easy

import main.Solution
import java.math.BigInteger

class Solution268 : Solution() {
    override fun test() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun missingNumber(nums: IntArray): Int = (nums.size.toBigInteger() * (nums.size.toBigInteger() - BigInteger.ONE) / BigInteger.valueOf(2) - nums.fold(BigInteger.ZERO) { acc, num -> acc + num.toBigInteger() }).toInt()
}