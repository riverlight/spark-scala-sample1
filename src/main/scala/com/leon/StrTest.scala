package com.leon

/**
  * Created by leon on 2016/3/25.
  */
object StrTest {
  def main(args: Array[String]) : Unit = {
    println("hi, this is string test")

    val str = """(null, abc, "leon", haha)"""
    val mm = str.split('#').map(line => line.substring(7, line.length-1))

    println(str)
    println(mm(0))
  }
}
