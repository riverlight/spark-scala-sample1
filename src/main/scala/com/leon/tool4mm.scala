package com.leon

import scala.collection.mutable
import scala.io.Source
import java.io.PrintWriter

/**
  * Created by leon on 2016/2/2.
  */
object tool4mm {
  def main(args: Array[String]): Unit = {
    println("Hi, leon~~")

    var t = new scala.collection.mutable.HashMap[Int, Array[String]]
    val out = new PrintWriter("d:\\workroom\\testroom\\1.mp4.txt")
    for (line <- Source.fromFile("d:\\workroom\\testroom\\leon.txt").getLines() ) {
      var pos = line.indexOf("1.mp4=")
      var name = line.substring(pos+6, line.length-4).replace('.', '_')
      var x = name.split("_")
      var k = (x(0).toInt, x)
      t += k
    }

    for ( i <- 0 to 10000 ) {
      val x = t.getOrElse(i, null)
      if (x!=null) {
        out.println(x(0) + " " + x(1) + " " + x(2) + " " + x(3) + " " + x(4) + " " +
              x(5) + " " + x(6) + " " + x(7) + " " + x(8))
      }
    }

    out.close()
  }
}
