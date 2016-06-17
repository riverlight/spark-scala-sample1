package com.leon

import scala.io.Source
import java.io.PrintWriter

/**
  * Created by leon on 2016/2/5.
  */
object nginxSample extends App {
  var in = Source.fromFile("d:\\workroom\\testroom\\nginx.log")
  var out = new PrintWriter("d:\\workroom\\testroom\\sample.log")
  val sampleBase = 25
  var count = 0
  for (line <- in.getLines()) {
    var k = count%sampleBase
    var r = (Math.random()*sampleBase).toInt
    println(r)
    if (k==r)
      out.println(line)
    count += 1
  }
  out.close()
}
