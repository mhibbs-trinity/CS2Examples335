package cs2.adt

class BSTSet[A <% Ordered[A]] extends Set[A] {
    private var bst = new BinarySearchTree[A]()
    private var len = 0

    def iterator():Iterator[A] = bst.iterator

    def add(elem:A):Unit = {
        if(!bst.contains(elem)) {
            bst.insert(elem)
            len += 1
        }
    }
    def remove(elem:A):Unit = {
        if(bst.contains(elem)) {
            bst.remove(elem)
            len -= 1
        }
    }
    def contains(elem:A):Boolean = bst.contains(elem)
    override def size():Int = len

    override def intersect(other:Set[A]):Set[A] = {
        val res = new BSTSet[A]()
        for(x <- bst) {
            if(other.contains(x)) res.add(x)
        }
        res
    }
    override def union(other:Set[A]):Set[A] = {
        val res = new BSTSet[A]()
        for(x <- bst) res.add(x)
        for(x <- other) res.add(x)
        res
    }
    override def difference(other:Set[A]):Set[A] = {
        val res = new BSTSet[A]()
        for(x <- bst) {
            if(!other.contains(x)) res.add(x)
        }
        res
    }
}