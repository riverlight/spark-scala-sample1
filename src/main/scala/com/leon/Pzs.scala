package com.leon

/**
  * Created by leon on 2016/5/26.
  */
object Pzs extends App {
  val xs = Seq(Seq("a", "b", "c"), Seq("d", "e", "f"), Seq("g", "h"), Seq("i", "j", "k"))
  val ys = for (Seq(x, y, z) <- xs) yield x + y + z
  println(ys)
  //val zs = xs map {case Seq(x, y, z) => x + y + z}
  val zs = xs withFilter {case Seq(x, y, z) => true; case _=> { println("???"); false} } map {case Seq(x, y, z) => x + y + z}
  println(zs)
}
