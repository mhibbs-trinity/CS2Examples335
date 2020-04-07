package cs2.adt

class LinkedStack[A] extends Stack[A] {
    private class Node(var data:A, var next:Node)
    private var head:Node = null

    def push(elem:A):Unit = {
        head = new Node(elem, head)
    }
    def pop():A = {
        if(isEmpty) {
            throw new java.util.EmptyStackException
        }
        val ret = head.data
        head = head.next
        ret
    }
    def peek():A = {
        if(isEmpty) {
            throw new java.util.EmptyStackException
        }
        head.data
    }
    def isEmpty():Boolean = head == null

}