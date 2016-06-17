package com.leon

/**
  * Created by leon on 2016/2/21.
  */

class In0(val str: String) {
  def print = println("In0 : " + str)
}

class In1(val s: String) extends In0(s+"haha") {
  override def print = {
    super.print
    println("In1" + str)
  }
}

class LinzAll[T <: Any] {
  def print() : Unit = {
    "leon".print
  }

  def parse(i : Int)  : In0 = {
    val m = new In1(i.toString)
    m
  }

  implicit def str2In(s: String) : In0 = {
    var m : In1 = new In1(s)
    m
  }
}

object LinzTest1 {
  def main(args: Array[String]): Unit = {
    println("Hi, this is Linz test1 program!")

    //val i0 = new In0("a")
    //val i1 = new In1("b")
    //i1.print
    //i0.print
    val linz = new LinzAll[In1]()
    linz.print()
    //val m = linz.parse(20)
    //m.print
  }
}
