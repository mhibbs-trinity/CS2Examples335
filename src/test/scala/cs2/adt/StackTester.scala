package cs2.adt

import org.junit._
import org.junit.Assert._

class StackTester {
    var s:Stack[Int] = null

    @Before def initializeStack() {
        s = new ArrayStack[Int] ()
    }

    @Test def checkIsEmptyWithEmpty() {
        assertTrue(s.isEmpty)
    }

    @Test def checkIsEmptyWithNonEmpty() {
        s.push(1)
        assertTrue(!s.isEmpty)
    }

    @Test def checkLotsOfPushAndPop() {
        for(i <- 1 to 50) {
            s.push(i)
        }
        for(i <- 50 to 1 by -1) {
            assertTrue(s.peek == i)
            assertTrue(s.pop == i)
        }
        assertTrue(s.isEmpty)
    }
}