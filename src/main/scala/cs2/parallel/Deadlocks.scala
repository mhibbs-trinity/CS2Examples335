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

    def simpleWaitNotify():Unit = {
        var turn = -1
        val threads = Array.tabulate(10)((idx:Int) => new Thread {
            override def run():Unit = {
                println("Thread " + idx + " started")

                lock1.synchronized {
                    while(turn != idx) lock1.wait

                    Thread.sleep(1000)
                    println("Work done by thread " + idx)

                    turn += 1
                    lock1.notifyAll
                }

            }
        })
        threads.foreach(_.start)
        Thread.sleep(500)
        turn = 0
        lock1.synchronized { lock1.notifyAll }
        threads.foreach(_.join)
    }


    def main(args:Array[String]):Unit = {
        //tryToDeadlock()
        simpleWaitNotify
    }
}