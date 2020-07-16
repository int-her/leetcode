package medium

class Solution3 {
    fun test() {
        val input1 = "abcabcbb"
        val input2 = "bbbbb"
        val input3 = "pwwkew"
        println(lengthOfLongestSubstring(input1))
        println(lengthOfLongestSubstring(input2))
        println(lengthOfLongestSubstring(input3))
    }

    fun lengthOfLongestSubstring(s: String): Int {
        val isPresented = HashMap<Char, Boolean>()
        (0..256).forEach { i -> isPresented.put(i.toChar(), false) }
        var i = 0
        var j = 0
        var max = 0
        var now = 0
        while (j < s.length) {
            if (!isPresented[s[j]]!!) {
                isPresented[s[j]] = true
                max = if (++now > max) now else max
            } else {
                while (s[i] != s[j]) {
                    now--
                    isPresented[s[i++]] = false
                }
                i++
            }
            j++
        }
        return max
    }
}