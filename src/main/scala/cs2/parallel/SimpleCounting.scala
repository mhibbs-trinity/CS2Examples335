package cs2.parallel

import io.StdIn._
import java.lang.Thread

object SimpleCounting {

    def countDownGetName():String = {
        val thread = new Thread {
            override def run():Unit = {
                for(i <- 0 until 5) {
                    println(i)
                    Thread.sleep(1000)
                }
                println("Times up!")
                sys.exit
            }
        }
        thread.start

        println("Enter you name:")
        var name = readLine
        thread.stop
        name
    }

    def betterCountDownGetName():String = {
        var haveAnswer = false
        var timesUp = false

        val thread = new Thread {
            override def run():Unit = {
                //The "other" thread (timer thread)
                var ctr = 5
                while(!haveAnswer && ctr > 0) {
                    println(ctr)
                    ctr -= 1
                    Thread.sleep(1000)
                }
                if(!haveAnswer) {
                    println("Times up!")
                    timesUp = true
                }

            }
        }
        thread.start()

        //The "main" thread
        var name = "Default"
        println("Enter your name:")
        while(!timesUp && !Console.in.ready) {
            Thread.sleep(10)
        }
        if(!timesUp) {
            name = readLine
            haveAnswer = true
        }
        name
    }

    class Lock

    def countToABillion():Unit = {
        val lock = new Lock

        var ctr = 0
        val threads = Array.fill(10)(new Thread {
            override def run():Unit = {
                for(i <- 1 to 1000000000/10) {
                    lock.synchronized({
                        ctr += 1
                    })
                }
            }
        })
        threads.foreach(_.start)
        threads.foreach(_.join)
        
        println(ctr)
    }

    import java.util.concurrent._
    def countToABillionWithExecutor():Unit = {
        val service = Executors.newCachedThreadPool

        val futures:Array[Future[Int]] = Array.fill(10)(
            service.submit(new Callable[Int] {
                def call():Int = {
                    var local = 0
                    for(i <- 1 to 100000000) {
                        local += 1
                    }
                    local
                }
            })
        )
        val res:Array[Int] = futures.map(_.get)
        println(res.sum)
        service.shutdown
    }



    def main(args:Array[String]):Unit = {
        //println("Hello, " + betterCountDownGetName)
        //countToABillion()
        countToABillionWithExecutor()
    }
}