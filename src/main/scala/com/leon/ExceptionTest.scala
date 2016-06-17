package com.leon

import scala.util.Try

/**
  * Created by leon on 2016/2/23.
  */
object ExceptionTest extends App {
  println("hi exception test")

  var s = Set(999)
  for ( n <- 1 to 10 ) {
    s += n
  }
  println(s)

  val w = s.map( f )

  println(w)

  println("??????????")
  w.filter(f1).map(println)

  def f(i : Int) : Any = {
    try {
      if (i==999)
        throw new Exception()
      else
        i*2
    }
    catch {
      case _ => { println("Exception"); null }
    }
  }

  def f1(x : Any) : Boolean = {
    (x!=null) && (x<10)
  }

  implicit def A2I(k : Any) : Int = {
    k match {
      case n : Int => n
      case _ => { throw new Exception() }
    }
  }
}
