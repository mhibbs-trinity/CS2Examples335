package cs2.adt

class LinkedSeq[A] extends Seq[A] with Iterable[A] {
    private class Node(var data:A, var next:Node) {
        def getNode(idx:Int):Node = {
            var rover = this
            for(i <- 1 to idx) rover = rover.next
            rover
        }
        override def toString():String = {
            if(next != null) data.toString + "," + next.toString
            else data.toString
        }
    }
    private var hed:Node = null
    private var len:Int = 0

    override def toString():String = {
        "(" + hed.toString + ")"
    }

    def iterator():scala.collection.Iterator[A] = {
        new scala.collection.Iterator[A] {
            var rover = hed
            def next():A = {
                val tmp = rover.data
                rover = rover.next
                tmp
            }
            def hasNext():Boolean = {
                rover != null
            }
        }
    }

    def get(idx:Int):A = {
        var rover = hed.getNode(idx)
        rover.data 
    }
    def set(idx:Int,elem:A):Unit = {
        var rover = hed.getNode(idx)
        rover.data = elem
    }
    def insert(idx:Int,elem:A):Unit = {
        len += 1
        if(idx == 0) {
            hed = new Node(elem, hed)
        } else { 
            var rover = hed.getNode(idx-1)
            rover.next = new Node(elem, rover.next)
        }
    }
    def remove(idx:Int):A = {
        len -= 1
        if(idx == 0) {
            val ret = hed.data
            hed = hed.next
            ret
        } else {
            var rover = hed.getNode(idx-1)
            val ret = rover.next.data
            rover.next = rover.next.next
            ret
        }
    }

    def length():Int = len
}

object SeqStuff {
    def main(args:Array[String]):Unit = {
        var seq = new LinkedSeq[Int]()
        for(i <- 1 to 10) seq.insert(0,i)

        for(i <- 0 until seq.length) {
            print(seq(i) + ",")
        }

        var it = seq.iterator
        while(it.hasNext) {
            print(it.next + ",")
        }

        it = seq.iterator
        it.foreach(print)

        seq.foreach(print)
        println
        println(seq)
    }
}

