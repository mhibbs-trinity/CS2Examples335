package cs2.algorithms

import cs2.adt.Seq
import cs2.adt.DoubleLinkedSeq

object QuickSorter {

    def quickSort[A <% Ordered[A] : Manifest](seq:Seq[A]):Seq[A] = {
        val pivot = seq(0)
        val lt = new DoubleLinkedSeq[A]()
        val gt = new DoubleLinkedSeq[A]()
        val et = new DoubleLinkedSeq[A]()
        while(seq.length != 0) {
            val tmp = seq.remove(0)
            if(tmp < pivot) lt.prepend(tmp)
            else if(tmp > pivot) gt.prepend(tmp)
            else et.prepend(tmp)
        }

        val slt = if(lt.length <= 1) lt else quickSort(lt)
        val sgt = if(gt.length <= 1) gt else quickSort(gt)

        val result = new DoubleLinkedSeq[A]()
        while(slt.length != 0) result.append(slt.remove(0))
        while(et.length  != 0) result.append(et.remove(0))
        while(sgt.length != 0) result.append(sgt.remove(0))

        result
    }

    def main(args:Array[String]) {
        val s = new DoubleLinkedSeq[Int]()
        for(i <- 1 to 10) s.append((math.random * 100).toInt)

        for(i <- 0 until s.length) print(s(i) + ",")
        println()

        val ss = quickSort(s)
        for(i <- 0 until ss.length) print(ss(i) + ",")
        println()
    }


}