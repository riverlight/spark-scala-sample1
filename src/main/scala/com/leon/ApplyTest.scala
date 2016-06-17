package com.leon

/**
  * Created by leon on 2016/2/29.
  */

class AT0(a : Int) {
  println("AT0 : " + a)
  def print() : Unit = { println("class :" + a) }
}

object AT0 {
  def apply(a : Int) : AT0 = {
    new AT0(a)
  }
  def print() : Unit = { println("object") }
}

object ApplyTest extends App {
  println("hi apply test")

  xtest1("100", ((_: Int) + (_: String).toInt) )

  for ( i <- 1 to 10) {
    val k = AT0(i)
  }
  for ( i <- 1 to 10) {
    AT0.print
  }
  for ( i <- 1 to 10) {
    AT0(i).print
  }

  def xtest1(s0: String, f: (Int, String)=>Int) : Unit = {
    println(f(s0.toInt, "11"))
  }

  def m(s0: String, s1: String) = {
    s0 + s1
  }
}

