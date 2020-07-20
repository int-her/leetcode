package easy

import Solution
import java.util.*

class Solution20 : Solution() {
    override fun test() {
        println(isValid("()"))
        println(isValid("()[]{}"))
        println(isValid("(]"))
        println(isValid("([)]"))
        println(isValid("{[]}"))
    }

    fun isValid(s: String): Boolean {
        val stack = Stack<Char>()
        s.forEach {
            when (it) {
                '(', '{', '[' -> stack.push(it)
                ')' -> if (stack.empty() || stack.pop() != '(') {
                    return false
                }
                '}' -> if (stack.empty() || stack.pop() != '{') {
                    return false
                }
                ']' -> if (stack.empty() || stack.pop() != '[') {
                    return false
                }
            }
        }
        return stack.empty()
    }
}