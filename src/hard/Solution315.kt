package hard

import main.Solution
import java.util.*

class Solution315 : Solution() {
  override fun test() {
    val input = arrayOf(
      intArrayOf(5, 2, 6, 1, 1, 5, 5, 1, 1)
    )
    input.forEach { println(countSmaller(it)) }
  }

  fun countSmaller(nums: IntArray): List<Int> {
    val treeMap = TreeMap<Int, Int>()
    val result = MutableList(nums.size) { 0 }
    nums.reversed().forEachIndexed { index, num ->
      treeMap[num] = (treeMap[num] ?: 0) + 1
      result[index] = treeMap.headMap(num, false).values.sum()
    }
    return result.reversed()
  }
}