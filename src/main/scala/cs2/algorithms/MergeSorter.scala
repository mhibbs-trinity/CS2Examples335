package cs2.algorithms

import cs2.adt.Seq
import cs2.adt.DoubleLinkedSeq

object MergeSorter {

    def mergeSeqs[A <% Ordered[A] : Manifest](left:Seq[A], right:Seq[A]):Seq[A] = {
        val ret = new DoubleLinkedSeq[A]()

        while(left.length != 0 && right.length != 0) {
            if(left(0) < right(0)) ret.append(left.remove(0))
            else ret.append(right.remove(0))
        }
        while(left.length != 0) ret.append(left.remove(0))
        while(right.length!= 0) ret.append(right.remove(0))

        ret
    }

    def splitSeq[A : Manifest](seq:Seq[A]):(Seq[A],Seq[A]) = {
        val left = new DoubleLinkedSeq[A]()
        val right= new DoubleLinkedSeq[A]()
        var addToLeft = true
        while(seq.length != 0) {
            if(addToLeft) left.prepend(seq.remove(0))
            else right.prepend(seq.remove(0))
            addToLeft = !addToLeft
        }
        (left,right)
    }

    def mergeSort[A <% Ordered[A] : Manifest](seq:Seq[A]):Seq[A] = {
        val (left,right) = splitSeq(seq)
        if(right.length == 0) left
        else mergeSeqs(mergeSort(left), mergeSort(right))
    }

    def main(args:Array[String]) {
        val s = new DoubleLinkedSeq[Int]()
        for(i <- 1 to 10) s.append((math.random * 100).toInt)

        for(i <- 0 until s.length) print(s(i) + ",")
        println()

        val ss = mergeSort(s)
        for(i <- 0 until ss.length) print(ss(i) + ",")
        println()
    }

}