package cs2.adt

class BinarySearchTree[A <% Ordered[A]] {
    private class Node(var data:A, var left:Node, var right:Node) {
        def contains(elem:A):Boolean = {
            if(data == elem) true
            else {
                if(elem < data) {
                    if(left != null) left.contains(elem)
                    else false
                }
                else {
                    if(right != null) right.contains(elem)
                    else false
                }
            }
        }

        def insert(elem:A):Unit = {
            if(elem < data) {
                if(left == null) left = new Node(elem, null, null)
                else left.insert(elem)
            } else {
                if(right == null) right = new Node(elem, null, null)
                else right.insert(elem)
            }
        }

        def passUpMax():(A,Node) = {
            if(right == null) (data, left)
            else {
                val (d,n) = right.passUpMax
                right = n
                (d, this)
            }
        }

        def remove(elem:A):Node = {
            if(data == elem) {
                if(left == null) right
                else if(right == null) left
                else {
                    val (d,n) = left.passUpMax
                    left = n
                    data = d
                    this
                }
            } else {
                if(elem < data) left = left.remove(elem)
                else right = right.remove(elem)
                this
            }
        }

        def getMax():A = {
            if(right == null) data
            else right.getMax
        }

    }

    private var root:Node = null

    def getMax():A = {
        root.getMax
    }

    def removeMax():A = {
        val mx = getMax
        remove(mx)
        mx
    }

    def contains(elem:A):Boolean = {
        if(root == null) false
        else root.contains(elem)
    }

    def insert(elem:A):Unit = {
        if(root == null) root = new Node(elem, null, null)
        else root.insert(elem)
    }

    def remove(elem:A):Unit = {
        if(root != null) root = root.remove(elem)
    }

    def isEmpty():Boolean = root == null

    def printPreOrder():Unit = {
        def processNode(curr:Node):Unit = {
            if(curr != null) {
                print(curr.data + ", ")
                processNode(curr.left)
                processNode(curr.right)
            }
        }
        processNode(root)
    }
    def printInOrder():Unit = {
        def processNode(curr:Node):Unit = {
            if(curr != null) {
                processNode(curr.left)
                print(curr.data + ", ")
                processNode(curr.right)
            }
        }
        processNode(root)
    }
    def printPostOrder():Unit = {
        def processNode(curr:Node):Unit = {
            if(curr != null) {
                processNode(curr.left)
                processNode(curr.right)
                print(curr.data + ", ")
            }
        }
        processNode(root)
    }

    def printPreOrderStack():Unit = {
        val stk = new LinkedStack[Node]()
        stk.push(root)
        while(!stk.isEmpty) {
            val curr = stk.pop
            if(curr != null) {
                print(curr.data + ", ")
                stk.push(curr.right)
                stk.push(curr.left)
            }
        }
        println
    }
}

object BinarySearchTree {
    def main(args:Array[String]):Unit = {
        var bst = new BinarySearchTree[Int]()
        bst.insert(40)
        bst.insert(20)
        bst.insert(60)
        bst.insert(15)
        bst.insert(30)
        bst.insert(4)
        bst.insert(55)

        bst.printPreOrder
        println
        bst.printInOrder
        println
        bst.printPostOrder
        println
        bst.printPreOrderStack
    }
}