package cs2.algorithms

import scala.io.Source
import scala.collection.mutable.Set

object TextAnalysis {

    def countWords(lines:Iterator[String]):Int = {
        var wordSet = Set[String]()
        for(line <- lines) {
            var words = line.split("\\s+")
            words = words.map(_.filter(_.isLetter).toLowerCase)
            wordSet ++= words
        }
        for(word <- wordSet) {
            //println(word)
        }
        wordSet.size
    }

    def main(args:Array[String]):Unit = {
        val url = getClass.getResource("/tempest.txt")
        val it = Source.fromURL(url).getLines()
        println(countWords(it))
    }
}