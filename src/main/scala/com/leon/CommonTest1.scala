package com.leon

/**
  * Created by leon on 2016/2/25.
  */
object CommonTest1 extends App {
  val a = 1 to 10
  println(a)

  val b = a.map(x => ("n001", 1))
  println(b)
  println(b.size)

  val c = b.count(x => x._2==1)
  println(c)
}
