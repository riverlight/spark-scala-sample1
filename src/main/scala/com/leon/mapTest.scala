package com.leon

/**
  * Created by leon on 2016/1/26.
  */
object mapTest {
  def main(args: Array[String]) : Unit = {
    println("Hi, this is a mapTest program!")

    var scores = Map("Leon"-> 99, "Betty"-> 99, "fei"->100)
    val feiS = scores.getOrElse("fei", 120)
    println(feiS)
    scores += ("arwen"->99 )

  }
}
