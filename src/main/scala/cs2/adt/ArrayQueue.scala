package cs2.adt

class ArrayQueue[A : Manifest] extends Queue[A] {
    var arr = new Array[A] (20)
    var len = 0
    var front = 0

    def enqueue(elem:A):Unit = {
        if(len == arr.length) {
            val tmp = new Array[A] (len * 2)
            for(i <- 0 until len) tmp(i) = arr((front + i) % arr.length)
            front = 0
            arr = tmp
        }
        arr((front + len) % arr.length) = elem
        len += 1
    }
    def dequeue():A = {
        val retVal = arr(front)
        front = (front + 1) % arr.length
        len -= 1
        retVal
    }
    def peek():A = arr(front)
    def isEmpty():Boolean = len == 0
}