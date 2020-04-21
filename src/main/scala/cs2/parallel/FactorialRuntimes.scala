package cs2.parallel

import cs2.util.TimeLogger
import scala.collection.parallel.mutable.ParArray

object FactorialRuntimes {

    def factRecur(n:BigInt):BigInt = {
        if(n <= 1) 1
        else n * factRecur(n-1)
    }

    def factFor(n:BigInt):BigInt = {
        var product:BigInt = 1
        for(x <- BigInt(1) to n) {
            product *= x
        }
        product
    }

    def factCollect(n:BigInt):BigInt = {
        val one:BigInt = 1
        (one to n).reduce(_*_)
    }

    def factParCollect(n:BigInt):BigInt = {
        val one:BigInt = 1
        (one to n).par.reduce(_*_)
    }

    import java.util.concurrent._
    def factExecutor(n:BigInt, k:Int):BigInt = {
        val service = Executors.newCachedThreadPool
        val futures:Array[Future[BigInt]] = Array.tabulate(k)((idx:Int) => {
            service.submit(new Callable[BigInt] {
                def call():BigInt = {
                    (BigInt(idx+1) to n by k).product
                }
            })
        })
        val res = futures.map(_.get).product
        service.shutdown
        res
    }

    def main(args:Array[String]):Unit = {
        val logger = new TimeLogger

        val n = 100000

        val a = Array.fill(100)(1).par
        var x = 0
        for(i <- a) {
            x += i
        }
        println(x)
        println(a.sum)


        /*
        logger.reset()
        factRecur(n)
        logger.log("recursive")
        */
        logger.reset()
        factFor(n)
        logger.log("for loop ")

        logger.reset()
        factCollect(n)
        logger.log("collect  ")

        logger.reset()
        factParCollect(n)
        logger.log("par coll ")

        for(k <- 10 to 10) {
            logger.reset()
            factExecutor(n, k)
            logger.log("executor " + k)
        }
    }
}