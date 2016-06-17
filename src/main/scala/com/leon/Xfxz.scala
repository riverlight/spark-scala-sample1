package com.leon

import java.io.PrintWriter
import java.util.Date

import scala.io.Source

/**
  * Created by leon on 2016/4/11.
  */
object Xfxz {
  def main(args: Array[String]) : Unit = {

    val date = new Date()
    val out = new PrintWriter("d:\\workroom\\testroom\\xfxz2.csv")
    for (line <- Source.fromFile("d:\\workroom\\testroom\\xfxz.csv").getLines() ) {
      val v = line.split(',')
      date.setTime(v(0).toLong)
      out.println(date + "," + v(1))
    }
    out.close
  }
}
