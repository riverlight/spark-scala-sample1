package com.leon

/**
  * Created by leon on 2016/1/26.
  */
object arrayTest {
  def main(args: Array[String]): Unit = {
    println("Hi, this is arrayTest program!")
    System.out.print(System.getProperty("user.dir"))

    val a = Array(1, 2, 3, 4);
    val res = for ( i <- a  if i==4 ) yield  i*2
    for ( r <- res ) println(r)

    val k = a.filter(_==4).map (_*2)
    for ( r<-k ) println(r)
  }
}
