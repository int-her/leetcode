package easy

import Solution

class Solution125 : Solution() {
    override fun test() {
        val input = arrayOf(
            "A man, a plan, a canal: Panama",
            "race a car"
        )
        input.forEach { println(isPalindrome(it)) }
    }

    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.lastIndex
        while (left < right) {
            if (s[left] !in 'a'..'z' && s[left] !in 'A'..'Z' && s[left] !in '0'..'9') {
                left++
            } else if (s[right] !in 'a'..'z' && s[right] !in 'A'..'Z' && s[right] !in '0'..'9') {
                right--
            } else {
                if (s[left] != s[right] && s[left].toLowerCase() != s[right].toLowerCase()) {
                    return false
                }
                left++
                right--
            }
        }
        return true
    }
}