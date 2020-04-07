package cs2.adt

abstract class Set[A] extends Iterable[A] {
    def add(elem:A):Unit
    def remove(elem:A):Unit
    def contains(elem:A):Boolean
    def size():Int

    def intersect(other:Set[A]):Set[A]
    def union(other:Set[A]):Set[A]
    def difference(other:Set[A]):Set[A]

    //Concrete methods derived from abstract
    def += (elem:A) = add(elem)
    def -= (elem:A) = remove(elem)
    def & (other:Set[A]) = intersect(other)
    def ++ (other:Set[A]) = union(other)
    def -- (other:Set[A]) = difference(other)
}