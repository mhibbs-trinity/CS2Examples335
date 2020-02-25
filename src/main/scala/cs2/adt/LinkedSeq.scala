package cs2.adt

class LinkedSeq[A] extends Seq[A] {
    private class Node(var data:A, var next:Node)
    private var head:Node = null
    private var len:Int = 0

    def get(idx:Int):A = {
        var rover = head
        for(i <- 1 to idx) rover = rover.next
        rover.data 
    }
    def set(idx:Int,elem:A):Unit = ???
    def insert(idx:Int,elem:A):Unit = ???
    def remove(idx:Int):A = ???

    def length():Int = len
}