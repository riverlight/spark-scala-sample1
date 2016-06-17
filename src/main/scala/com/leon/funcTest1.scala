package com.leon

/**
  * Created by leon on 2016/2/20.
  */

class T1 {
  def hello(i: Int) { println("T1") }
}

class C1 extends T1 {
  override def hello(i: Int) { println("c1 : " + i ) }
}

class C2 extends T1 {
  override def hello(i: Int) { println("c2 : " + 2*i ) }
}

object funcTest1 {
  def main(args: Array[String]) : Unit = {
    println("Hi, this is func test program")

    val c1 = makeC(1)
    c1.hello(10)
    val c2 = makeC(2)
    c2.hello(10)
  }

  def makeC(i: Int): T1 = {
    i match {
      case 1 => new C1()
      case 2 => new C2()
      case _ => new T1()
    }
  }
}
