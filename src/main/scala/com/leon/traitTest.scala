package com.leon

trait Output {
  def out(i:Int) : Unit
}

class Aout(k: Int) extends Output {
  val m = k*3
  def out(i: Int):Unit = { println( i+m) }
  val out1 = { i: Int => { println(i+m)}}
}

class Bout(k: Int) extends Output {
  val m = k*2
  def out(i: Int):Unit = { println(i-m) }
}

/**
  * Created by leon on 2016/2/19.
  */
object traitTest {
  def main(args: Array[String]): Unit = {
    println("Hi, this is trait test")

    val a = new Aout(8)
    val b = new Bout(8)

    val c = Vector(10, 20, 30)
    val d = c.map(a.out1)
    val e = c.map(b.out)
  }
}
