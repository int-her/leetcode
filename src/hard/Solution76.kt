package hard

import Solution

class Solution76 : Solution() {
    override fun test() {
        println(minWindow("ADOBECODEBANC", "A"))
        println(minWindow("AA", "AAA"))
        println(minWindow("ADOBECODEBANC", "ABC"))
        println(minWindow("BBA", "AB"))
    }

    fun minWindow(s: String, t: String): String {
        if (t.length == 1) {
            return if (s.contains(t)) t else ""
        }
        val chars = t.toList().groupBy { it }.mapValues { it.value.size }
        val now = chars.mapValues { 0 }.toMutableMap()
        var left = 0
        var right = 0
        var min = Int.MAX_VALUE
        var result = ""
        var moveLeft = false
        while (left <= s.lastIndex && right <= s.lastIndex) {
            if (moveLeft) {
                if (s[left] in chars.keys) {
                    now[s[left]] = now[s[left]]!! - 1
                }
                left++
            } else {
                if (s[right] in chars.keys) {
                    now[s[right]] = now[s[right]]!! + 1
                }
            }

            // 체크를 이렇게 할게 아니고 아스키 코드 문자만 들어온다고 가정 했으므로 전체 배열에 개수 쌓아놓고 전체를 0으로 만들 수 있으면 일치
            // 전체 배열의 모든 요소 값이 0인지 체크 할 때도 직접 체크 하는것이 아니라 count 변수 한개 두고 +/- 하면서 체크
            // 허나 아스키 코드 개수가 어차피 상수이기 때문에 시간 복잡도에는 영향을 주지 않는다.
            val isContained = let {
                chars.forEach { (key, value) ->
                    if (now[key]!! < value) {
                        return@let false
                    }
                }
                true
            }
            if (isContained) {
                if (right - left + 1 < min) {
                    min = right - left + 1
                    result = s.substring(left, right + 1)
                }
                moveLeft = true
            } else {
                moveLeft = false
                right++
            }
        }
        return result
    }
}