package hard

import main.Solution

class Solution10 : Solution() {
    override fun test() {
        println(isMatch("a", "ab*"))
        println(isMatch("aa", "a*"))
        println(isMatch("ab", ".*"))
        println(isMatch("aab", "c*a*b"))
        println(isMatch("mississippi", "mis*is*p*."))
        println(isMatch("mississippi", "mis*is*ip*."))
    }

    fun isMatch(s: String, p: String): Boolean {
        return when {
            s.isBlank() -> p.isBlank() || (p.length % 2 == 0 && p.foldIndexed(true) { index, result, char -> result && (index % 2 == 0 || char == '*') })
            p.isBlank() -> s.isBlank()
            p.length == 1 -> (s.length == 1 && (p.first() == '.' || p.first() == s.first()))
            p[1] != '*' && (p.first() == s.first() || p.first() == '.') -> isMatch(s.substring(1), p.substring(1))
            else -> {
                if (p[1] == '*') {
                    if (isMatch(s, p.substring(2))) {
                        return true
                    }
                    if (p.first() == '.') {
                        s.forEachIndexed { index, char ->
                            if (isMatch(s.substring(index + 1), p.substring(2))) {
                                return true
                            }
                        }
                    } else {
                        for ((index, char) in s.withIndex()) {
                            if (p.first() == char) {
                                if (isMatch(s.substring(index + 1), p.substring(2))) {
                                    return true
                                }
                            } else {
                                break
                            }
                        }
                    }
                }
                false
            }
        }
    }

//        p.forEachIndexed { index, char ->
//            if (char != '*' && (index == p.length - 1 || p[index + 1] != '*')) {
//                s.forEachIndexed { subIndex, subChar ->
//                    if (char == '.' || char == subChar) {
//                        if (isMatchRecursive(s.substring(0, subIndex), p.substring(0, index)) && isMatchRecursive(s.substring(subIndex + 1), p.substring(index + 1))) {
//                            return true
//                        }
//                    }
//
//                }
//            }
//
//            if (index < p.length - 1 && p[index + 1] == '*') {
//                if (char == '.') {
//                    s.forEachIndexed { subIndex, subChar ->
//                        if (isMatchRecursive(s.substring(subIndex), p.substring()))
//                    }
//                }
//            }
//        }
}