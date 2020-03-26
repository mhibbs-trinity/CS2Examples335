package cs2.adt

class DoubleLinkedSeq[A: Manifest] extends Seq[A] with Iterable[A] {
  class Node(var data: A, var prev: Node, var next: Node) {
    def getNode(idx: Int): Node = {
      if (idx >= 0 && idx < len) {
        var rover = this
        for (i <- 1 to idx) rover = rover.next
        rover
      } else end
    }
  }
  class BidirectionalIterator extends scala.collection.Iterator[A] {
    private var rover = end.next
    def next(): A = {
      val ret = rover.data
      rover = rover.next
      ret
    }
    def hasNext(): Boolean = rover != end
    def previous(): A = {
      val ret = rover.data
      rover = rover.prev
      ret
    }
    def hasPrevious(): Boolean = rover != end
  }

  def iterator(): BidirectionalIterator = new BidirectionalIterator()

  var end: Node = new Node(new Array[A](1)(0), end, end)
  end.next = end
  end.prev = end
  private var len: Int = 0

  def get(idx: Int): A = end.next.getNode(idx).data
  def set(idx: Int, elem: A): Unit = end.next.getNode(idx).data = elem
  def insert(idx: Int, elem: A): Unit = {
    var rover = end.next.getNode(idx - 1)
    rover.next = new Node(elem, rover, rover.next)
    rover.next.next.prev = rover.next
    len += 1
  }
  override def append(elem: A): Unit = {
    var rover = end.prev
    rover.next = new Node(elem, rover, rover.next)
    rover.next.next.prev = rover.next
    len += 1
  }
  def remove(idx: Int): A = {
    var rover = end.next.getNode(idx)
    rover.prev.next = rover.next
    rover.next.prev = rover.prev
    len -= 1
    rover.data
  }

  def length(): Int = len

}
