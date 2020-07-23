package hard

import Solution

class Solution41 : Solution() {
    override fun test() {
        val input = arrayOf(
            intArrayOf(6, 5, 4, 3, 2, 1, 0, -1),
            intArrayOf(6, 5, 14, 23, 4, 1, 4, 2, 3),
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(),
            intArrayOf(-1),
            intArrayOf(0),
            intArrayOf(1),
            intArrayOf(2, 3, 4),
            intArrayOf(1, 2, 0),
            intArrayOf(1, 2, 3, 0),
            intArrayOf(3, 4, -1, 1),
            intArrayOf(7, 8, 9, 11, 12),
            intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10),
            // answer: 100
            intArrayOf(99, 94, 96, 11, 92, 5, 91, 89, 57, 85, 66, 63, 84, 81, 79, 61, 74, 78, 77, 30, 64, 13, 58, 18, 70, 69, 51, 12, 32, 34, 9, 43, 39, 8, 1, 38, 49, 27, 21, 45, 47, 44, 53, 52, 48, 19, 50, 59, 3, 40, 31, 82, 23, 56, 37, 41, 16, 28, 22, 33, 65, 42, 54, 20, 29, 25, 10, 26, 4, 60, 67, 83, 62, 71, 24, 35, 72, 55, 75, 0, 2, 46, 15, 80, 6, 36, 14, 73, 76, 86, 88, 7, 17, 87, 68, 90, 95, 93, 97, 98),
            // answer: 259
            intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144, 145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180, 181, 182, 183, 184, 185, 186, 187, 188, 189, 190, 191, 192, 193, 194, 195, 196, 197, 198, 199, 200, 201, 202, 203, 204, 205, 206, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 240, 241, 242, 243, 244, 245, 246, 247, 248, 249, 250, 251, 252, 253, 254, 255, 256, 257, 258)
        )
        input.forEach { println(firstMissingPositive(it)) }
    }

    // The algorithm should run in O(n) time and uses constant extra space.
    // If there is no constraint about memory space, then the problem is more easy and simple.
    // 근데 그냥 다른 쉬운 방법이 많네..
    // Ex1) 유효하지 않은 넘버를 size + 1로 모두 변경 -> 유효한 nums[value] 마이너스로 뒤집기 -> search first positive index
    // Ex2) nums[0]에 0 박고 원래 nums[0]에 있던 value를 폭탄 돌리기처럼 nums[value]에 박고.. -> 전체 반복
    fun firstMissingPositive(nums: IntArray): Int {
        var min = 0
        var max = nums.lastIndex
        var interval = (nums.size + 1) / 2

        // distinct
        val distinct = mutableMapOf<Int, Boolean>()
        nums.indices.forEach { index ->
            distinct[nums[index]]?.let {
                nums[index] = -1
            } ?: let {
                distinct[nums[index]] = true
            }
        }

        while (interval > 0 && min <= max) {
            var left = min
            var right = max
            while (left <= right) {
                if (nums[left] !in (min + 1)..(min + interval)) {
                    while (left <= right && nums[right] !in (min +  1)..(min + interval)) {
                        right--
                    }
                    if (right > left) {
                        nums[left] = nums[right].also { nums[right] = nums[left] }
                        left++
                    }
                } else {
                    left++
                }
            }
            if (left == min) {
                break
            } else if (left == min + interval) {
                min = left
            } else {
                max = min + interval - 1
            }
            interval = (max - min) / 2 + 1
        }
        return min + 1
    }
}