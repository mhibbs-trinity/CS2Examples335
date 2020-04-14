package cs2.adt

abstract class Set[A <% Ordered[A]] extends Iterable[A] {
    def add(elem:A):Unit
    def remove(elem:A):Unit
    def contains(elem:A):Boolean
    def size():Int

    def intersect(other:Set[A]):Set[A] = {
        val res = Set[A]()
        for(x <- this) {
            if(other.contains(x)) res += x
        }
        res
    }
    def union(other:Set[A]):Set[A] = {
        val res = Set[A]()
        for(x <- this) res += x
        for(x <- other) res += x
        res
    }
    def difference(other:Set[A]):Set[A] = {
        val res = Set[A]()
        for(x <- this) {
            if(!other.contains(x)) res += x
        }
        res
    }

    //Concrete methods derived from abstract
    def += (elem:A) = add(elem)
    def -= (elem:A) = remove(elem)
    def & (other:Set[A]) = intersect(other)
    def ++ (other:Set[A]) = union(other)
    def -- (other:Set[A]) = difference(other)
}

object Set {
    def apply[A <% Ordered[A]]():Set[A] = {
        new HashTableSet[A]()
    }
}
