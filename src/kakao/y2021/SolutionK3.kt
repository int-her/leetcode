package kakao.y2021

import main.Solution

class SolutionK3 : Solution() {
    override fun test() {
        val input = arrayOf(
            Pair(arrayOf(
                "java backend junior pizza 150",
                "java backend junior pizza 210",
                "java backend junior pizza 210",
                "java backend junior pizza 210",
                "java backend junior pizza 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"
            ), arrayOf(
                "java and backend and junior and pizza 210",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 10000"
            ))
        )
        input.forEach { println(solution(it.first, it.second).joinToString())}
    }

    fun solution(info: Array<String>, query: Array<String>): IntArray {
        val stat = Array(3) { Array(2) { Array(2) { Array(2) { mutableListOf<Int>() } } } }
        info.forEach { i ->
            val elements = i.split(" ")
            val a = if (elements[0][0] == 'c') 0 else if (elements[0][0] == 'j') 1 else 2
            val b = if (elements[1][0] == 'b') 0 else 1
            val c = if (elements[2][0] == 'j') 0 else 1
            val d = if (elements[3][0] == 'c') 0 else 1
            stat[a][b][c][d].add(elements[4].toInt())
        }
        (0 until 3).forEach { a ->
            (0 until 2).forEach { b ->
                (0 until 2).forEach { c ->
                    (0 until 2).forEach { d ->
                        stat[a][b][c][d].sort()
                    }
                }
            }
        }

        return query.map { q ->
            val elements = q.split(" ").filter { it != "and" }
            val a = if (elements[0][0] == '-') listOf(0, 1, 2) else if (elements[0][0] == 'c') listOf(0) else if (elements[0][0] == 'j') listOf(1) else listOf(2)
            val b = if (elements[1][0] == '-') listOf(0, 1) else if (elements[1][0] == 'b') listOf(0) else listOf(1)
            val c = if (elements[2][0] == '-') listOf(0, 1) else if (elements[2][0] == 'j') listOf(0) else listOf(1)
            val d = if (elements[3][0] == '-') listOf(0, 1) else if (elements[3][0] == 'c') listOf(0) else listOf(1)
            var result = 0
            a.forEach { aa ->
                b.forEach { bb ->
                    c.forEach { cc ->
                        d.forEach { dd ->
                            result += stat[aa][bb][cc][dd].size - (stat[aa][bb][cc][dd].binarySearch(elements[4].toInt()).let {
                                if (it >= 0) {
                                    ((0..it).reversed().firstOrNull { index -> stat[aa][bb][cc][dd][index] < elements[4].toInt() } ?: -1) + 1
                                } else {
                                    -it - 1
                                }
                            })
                        }
                    }
                }
            }
            result
        }.toIntArray()
    }
}