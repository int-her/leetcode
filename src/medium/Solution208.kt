package medium

class Trie() {
    /** Initialize your data structure here. */
    class TreeNode(var `val`: String) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
    var root: TreeNode? = null

    /** Inserts a word into the trie. */
    fun insert(word: String) {
        if (root == null) {
            root = TreeNode(word)
        } else {
            var pointer = root
            while (true) {
                if (word < pointer!!.`val`) {
                    if (pointer.left == null) {
                        pointer.left = TreeNode(word)
                        break
                    } else {
                        pointer = pointer.left
                    }
                } else {
                    if (pointer.right == null) {
                        pointer.right = TreeNode(word)
                        break
                    } else {
                        pointer = pointer.right
                    }
                }
            }
        }
    }

    /** Returns if the word is in the trie. */
    fun search(word: String): Boolean {
        var pointer = root
        while (pointer != null) {
            pointer = when {
                word < pointer.`val` -> pointer.left
                word > pointer.`val` -> pointer.right
                else -> return true
            }
        }
        return false
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    fun startsWith(prefix: String): Boolean {
        var pointer = root
        while (pointer != null) {
            pointer = when {
                pointer.`val`.startsWith(prefix) -> return true
                prefix < pointer.`val` -> pointer.left
                else -> pointer.right
            }
        }
        return false
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */