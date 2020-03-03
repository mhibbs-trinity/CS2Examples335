package cs2.adt

class LinkedPriorityQueue[A <% Ordered[A]] extends PriorityQueue[A] {
    private class Node(var data:A, var next:Node)
    private var head:Node = null

    def add(elem:A):Unit = {
        if(head == null || head.data < elem) {
            head = new Node(elem, head)
        } else {
            var rover = head
            while(rover.next != null && rover.next.data > elem) {
                rover = rover.next
            }
            rover.next = new Node(elem, rover.next)
        }
    }
    def get():A = {
        val ret = head.data
        head = head.next
        ret
    }
    def peek():A = head.data


    /*
    def add(elem:A):Unit = {
        head = new Node(elem, head)
    }
    def get():A = {
        var biggest = head.data
        var oneBefore:Node = null
        var rover = head

        while(rover.next != null) {
            if(rover.next.data > biggest) {
                biggest = rover.next.data
                oneBefore = rover
            }
            rover = rover.next
        }
        if(oneBefore == null) {
            head = head.next
        } else {
            oneBefore.next = oneBefore.next.next
        }
        biggest
    }
    def peek():A = {
        var biggest = head.data
        var rover = head
        while(rover != null) {
            if(rover.data > biggest) biggest = rover.data
            rover = rover.next
        }
        biggest
    }
    */
    def isEmpty():Boolean = head == null

}