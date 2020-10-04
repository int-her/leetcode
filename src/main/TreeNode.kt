package main

import java.util.*

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    companion object {
        fun makeTreeNode(values: List<Int?>): TreeNode? {
            return if (values.isEmpty()) {
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

    override fun toString(): String {
        return "${this.`val`} ${this.left?.toString() ?: ""} ${this.right?.toString() ?: ""}"
    }
}