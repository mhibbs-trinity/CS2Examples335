package cs2.adt

import org.junit._
import org.junit.Assert._

class QueueTester {
    var q:Queue[Int] = null

    @Before def initializeQueue() {
        q = new LinkedQueue[Int]()
    }

    @Test def checkIsEmpty() {
        assertTrue(q.isEmpty)
        q.enqueue(1)
        assertFalse(q.isEmpty)
        assertTrue(q.dequeue() == 1)
        assertTrue(q.isEmpty)
    }

    @Test def checkManyEnDeQueues() {
        for(i <- 1 to 100) {
            q.enqueue(i)
        }
        for(i <- 1 to 100) {
            assertTrue(q.peek == i)
            assertTrue(q.dequeue == i)
        }
        assertTrue(q.isEmpty)
    }

    @Test def checkRepeatedEnDeQueues() {
        for(i <- 1 to 100) {
            q.enqueue(i)
        }
        for(i <- 1 to 50) {
            assertTrue(q.peek == i)
            assertTrue(q.dequeue == i)
        }
        //insertions into a queue after some removals
        for(i <- 101 to 150) {
            q.enqueue(i)
        }
        for(i <- 51 to 150) {
            assertTrue(q.peek == i)
            assertTrue(q.dequeue == i)
        }
        assertTrue(q.isEmpty)
        //insertions into a queue made empty by removals
        for(i <- 1 to 20) {
            q.enqueue(i)
        }
        for(i <- 1 to 20) {
            assertTrue(q.peek == i)
            assertTrue(q.dequeue == i)
        }
        assertTrue(q.isEmpty)
    }




}