package cs2.net

import java.net._
import java.io._
import java.lang.Thread

object SimpleNetworkExamples {

    def getPageSource(url:String):String = {
        val link = new URL(url)
        val bis = new BufferedInputStream(link.openStream)
        var res = ""
        while(bis.available > 0) {
            res += bis.read.toChar
        }
        res
    }

    def serverSide():Unit = {
        val ss = new ServerSocket(50000)
        val sock = ss.accept
        val os = new BufferedOutputStream(sock.getOutputStream)
        for(i <- 1 to 10) {
            val c = scala.util.Random.nextPrintableChar
            println(">> Sending: " + c)
            os.write(c)
        }
        os.flush
        os.close
        sock.close
        ss.close
    }

    def clientSide():Unit = {
        val sock = new Socket("localhost", 50000)
        val is = new BufferedInputStream(sock.getInputStream)
        while(is.available == 0) Thread.sleep(10)
        while(is.available > 0) {
            println("<< Received: " + is.read.toChar)
        }
        is.close
        sock.close
    }


    def main(args:Array[String]):Unit = {

        (new Thread { override def run() { serverSide }}).start
        Thread.sleep(1000)
        clientSide

        //println(getPageSource("https://new.trinity.edu"))
    }
}