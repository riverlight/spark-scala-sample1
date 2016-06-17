package com.leon

/**
  * Created by leon on 2016/2/23.
  */

class OptionTestC1(x : Int) {
  val c = x*2
}

object OptionTest extends App {
  println("Hi, option test")

  val w = for ( i <- 1 to 10 ) yield f1(i)
  w.map(x => println(x.getOrElse(new OptionTestC1(-1)).c))

  val usename : Option[String] = None
  for (u <- usename) {
    println(u)
  }

  val v = w.map(f2)
  v.map(x => println(x.getOrElse(new OptionTestC1(-1)).c))
  v.map(m => {
    val k = for (mm <-m ) yield mm
    println(k.getOrElse(new OptionTestC1(99)).c)
  })

  f3("haha leon")

  def f2(p : Option[OptionTestC1]) : Option[OptionTestC1] = {
    for ( u <- p ) yield u
  }

  def f1(i : Int) : Option[OptionTestC1] = {
    if (i<5) Option(new OptionTestC1(i)) else None
  }

  def f3(n : Option[String]): Unit = {
    for (k <- n) println(k)
  }

  implicit def s2o(s : String) : Option[String] = Some(s)
}
