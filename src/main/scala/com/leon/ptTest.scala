package com.leon


trait Tpt0 {
  def t(i : Int) : Any
}

class Cpt1 extends Tpt0 {
  def t(i : Int) { println("Cpt1 : " + i)}
}

class Cpt2 extends Tpt0 {
  def t(i : Int) : Int = {
    println("Cpt2 : " + i)
    i*10
  }
}


/**
  * Created by leon on 2016/2/20.
  */
object ptTest {
  def main(args: Array[String]) : Unit = {
    println("Hi, this is pt test program")

    val c = new Cpt1()
    c.t(1)

    val c1 = new Cpt2()
    println(c1.t(2))
  }
}
