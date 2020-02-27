package cs2.adt

class DoubleLinkedSeq[A:Manifest] extends Seq[A] {
    private class Node(var data:A, var prev:Node, var next:Node) {
        def getNode(idx:Int):Node = {
            if(idx >= 0 && idx < len) {
                var rover = this
                for(i <- 1 to idx) rover = rover.next
                rover
            } else end
        }
    }
    private var end:Node = new Node(new Array[A](1)(0),end,end)
    private var len:Int = 0

    def get(idx:Int):A = end.next.getNode(idx).data
    def set(idx:Int,elem:A):Unit = end.next.getNode(idx).data = elem
    def insert(idx:Int,elem:A):Unit = {
        var rover = end.next.getNode(idx-1)
        rover.next = new Node(elem, rover, rover.next)
        rover.next.next.prev = rover.next
        len += 1
    }
    def remove(idx:Int):A = {
        var rover = end.next.getNode(idx)
        rover.prev.next = rover.next
        rover.next.prev = rover.prev
        rover.data
    }

    def length():Int = len


}