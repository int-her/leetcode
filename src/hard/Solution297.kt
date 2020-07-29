package hard

import TreeNode
import java.util.*

/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Codec() {
    // Encodes a URL to a shortened URL.
    fun serialize(root: TreeNode?): String {
        val result = mutableListOf<Int?>()
        val queue = LinkedList<TreeNode?>()
        return root?.let {
            queue.add(it)
            while (queue.isNotEmpty()) {
                queue.poll()
                    .also { node ->
                        result.add(node?.`val`)
                    }?.also { node ->
                        queue.add(node.left)
                        queue.add(node.right)
                    }
            }
            result.joinToString(separator = ",") { value -> value?.let { value.toString() } ?: "null" }
        } ?: ""
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        return if (data.isEmpty()) {
            null
        } else {
            val values = data.split(",").map { it.toIntOrNull() }
            if (values.isEmpty()) {
                null
            } else {
                val queue = LinkedList<TreeNode>()
                val root = TreeNode(values.first()!!)
                queue.add(root)
                IntProgression.fromClosedRange(1, values.lastIndex - 1, 2).forEach {
                    val parent = queue.pop()
                    values[it]?.let { value -> TreeNode(value) }?.also { treeNode -> parent.left = treeNode }?.also { treeNode -> queue.add(treeNode) }
                    values[it + 1]?.let { value -> TreeNode(value) }?.also { treeNode -> parent.right = treeNode }?.also { treeNode -> queue.add(treeNode) }
                }
                if (values.size % 2 == 0 && values.last() != null) {
                    val parent = queue.pop()
                    parent.left = TreeNode(values.last()!!)
                }
                root
            }
        }
    }
}

/**
 * Your Codec object will be instantiated and called as such:
 * var obj = Codec()
 * var data = obj.encode(longUrl)
 * var ans = obj.decode(data)
 */