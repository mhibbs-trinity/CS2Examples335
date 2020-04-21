package cs2.io

import java.io._

object StreamStuff {

    def copyStream(in:InputStream, out:OutputStream):Unit = {
        while(in.available() > 0) {
            out.write(in.read)
        }
    }

    def main(args:Array[String]):Unit = {
        val pw = new PrintWriter(new File("pi.txt"))
        pw.println(math.Pi)
        pw.close

        //To read from a file in the resources folder, we should use the
        //getResourceAsStream method to immediately get an InputStream
        //rather than making a new File
        val stream = getClass().getResourceAsStream("/tempest.txt")
        val fin = new BufferedInputStream(stream)
        while(fin.available() > 0) {
            print(fin.read.toChar)
        }


        /*
        val fin = new BufferedInputStream(new FileInputStream(new File("tempest.txt")))
        val fos = new BufferedOutputStream(new FileOutputStream(new File("copy.txt")))

        copyStream(fin, System.out)

        fin.close()
        fos.close() */

        val dos = new DataOutputStream(
                       new BufferedOutputStream(
                           new FileOutputStream(new File("pi_data.txt"))))
        dos.writeDouble(math.Pi)
        dos.close

    }


}