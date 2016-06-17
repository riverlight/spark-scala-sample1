package com.leon

/**
  * Created by leon on 2016/2/1.
  */
object dd {
  def main(args:Array[String]): Unit = {
    val m = new mm();
    m.p;
    println(m.k)

    val conf = new linzConfig("D:\\workroom\\testroom\\log.properties");

    val kk = List(1, 2, 10)
    val kk2 = (1 to 10).toList

    val ff = fpTest(kk)
    val ff2 = fpTest(kk2)
    ff.foreach(println)
    ff2.foreach(println)

    //val (t0, t1, t2) = test(10)
    //println(t0 + " " + t1 + " " + t2)
  }

  def fpTest(lis : List[Int]) : List[Int] = {
    return lis.map(_*2).map(_-2)
  }

  def test(a : Int) {
    return (a, a.toLong, a.toString)
  }
}
