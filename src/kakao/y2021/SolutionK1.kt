package kakao.y2021

import main.Solution

class SolutionK1 : Solution() {
    override fun test() {
        val input = arrayOf(
            "...!@BaT#*..y.abcdefghijklm",
            "z-+.^.",
            "=.=",
            "123_.def",
            "abcdefghijklmn.p"
        )
        input.forEach { println(solution(it)) }
    }

    fun solution(new_id: String): String {
        return new_id
            .toLowerCase()
            .filter { it in ('a'..'z') + ('0'..'9') + listOf('-', '_', '.') }
            .let { it.filterIndexed { index, char -> index == 0 || char != '.' || it[index - 1] != '.' } }
            .let { it.dropWhile { char -> char == '.' } }
            .let { it.dropLastWhile { char -> char == '.' }}
            .let { if (it.isEmpty()) "a" else it }
            .let { if (it.length >= 16) it.substring(0, 15) else it }
            .let { it.dropLastWhile { char -> char == '.' }}
            .let { if (it.length <= 2) it + it.last().toString().repeat(3 - it.length) else it }
    }
}