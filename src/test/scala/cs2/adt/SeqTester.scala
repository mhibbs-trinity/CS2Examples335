package cs2.adt

import org.junit._
import org.junit.Assert._

class SeqTester {
  var lst:DoubleLinkedSeq[Int] = null
  
  @Before def initList() {
    lst = new DoubleLinkedSeq[Int]()
    lst.end.data = -999
  }
  
  @Test def checkInitialListEmpty() {
    assertTrue(lst.length == 0)
  }
  @Test def checkInsertAndGet() {
    for(i <- 10 to 5 by -1) {
      lst.insert(0, i)
    }
    assertTrue(lst.length != 0)
    assertTrue(lst.length == 6)
    for(i <- 0 until lst.length) {
      assertTrue(lst.get(i) == i+5)
    }
  }
  @Test def checkLargeInsertAndGet() {
    for(i <- 100 to 0 by -1) {
      lst.insert(0, i)
    }
    for(i <- 0 until lst.length) {
      assertTrue(lst.get(i) == i)
    }
  }
  @Test def checkSetAndGet() {
    for(i <- 0 to 100) {
      lst.insert(i, i*2)
    }
    for(i <- 0 to 100) {
      lst.set(i, i*4)
    }
    for(i <- 0 to 100) {
      assertTrue(lst.get(i) == i*4)
    }
  }
  @Test def checkRemove() {
    for(i <- 0 to 100) {
      lst.insert(i, i)
    }
    for(i <- 0 to 100) {
      val tmp = lst.remove(0)
      assertTrue(tmp == i)
    }
  }

  @Test def checkMiddleRemove() {
    for(i <- 0 to 100) {
        lst.insert(i,i)
    }
    for(i <- 50 to 60) {
      assertTrue(lst.remove(50) == i)
    }
    assertTrue(lst.length == 90)
    assertTrue(lst.remove(0) == 0)
    assertTrue(lst.remove(lst.length-1) == 100)
  }
}