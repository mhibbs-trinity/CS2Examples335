package cs2.parallel

object Deadlocks {

    class Lock

    val lock1 = new Lock
    val lock2 = new Lock

    def funcA():Unit = {
        lock1.synchronized {
            println("A1")
            lock2.synchronized {
                println("A2")
            }
        }
    }
    def funcB():Unit = {
        lock2.synchronized {
            println("B2")
            lock1.synchronized {
                println("B1")
            }
        }
    }

    def tryToDeadlock():Unit = {
        val athreads = Array.fill(5)(new Thread {
            override def run():Unit = funcA
        })
        val bthreads = Array.fill(5)(new Thread {
            override def run():Unit = funcB
        })
        athreads.foreach(_.start)
        Thread.sleep(1)
        bthreads.foreach(_.start)
    }



    def main(args:Array[String]):Unit = {
        tryToDeadlock()
    }
}