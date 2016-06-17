package com.leon

import scala.io.Source

/**
  * Created by leon on 2016/2/22.
  */
object NginxEvenv extends App {
  var in = Source.fromFile("d:\\workroom\\testroom\\1.log").getLines

  var i = 0
  for ( line <- in ) {
    println(line)
  }

  var in1 = Source.fromFile("d:\\workroom\\testroom\\1.log").getLines
  for ( line <- in1 ) {
    println(line)
  }

  def exceptTest(i : Int) = {
    if (i==1)
      throw new Exception(i.toString)
  }

}
