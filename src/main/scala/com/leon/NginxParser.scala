package com.leon

import com.leon.util.InvalidNginxLogException

/**
  * Created by leon on 2016/3/25.
  */
object NginxParser {
  def main(args: Array[String]) : Unit = {
    val log = """10.10.233.12 - - [25/Mar/2016:14:09:15 +0800] "OPTIONS /api/tracks/showTag HTTP/1.1" 200 4 "http://www.mgtv.com/v/1/290525/f/3052871.html" "Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36" "222.172.150.153, 222.172.150.153""""
    println(log)

    val m = parse(log)
    println(m)
  }

  def parse(str : String) = {
    val strs = str.split('"')
    if (strs.length!=8) throw new InvalidNginxLogException()

    val strs0 = strs(0).split(' ')
    if (strs0.length!=5) throw new InvalidNginxLogException()

    val strs1 = strs(1).split(' ')
    if (strs1.length!=3) throw new InvalidNginxLogException()

    val strs2 = strs(2).split(' ')
    if (strs2.length!=3) throw new InvalidNginxLogException()

    (strs0(0), strs0(3).substring(1), strs1(0), strs1(1), strs1(2), strs2(1).toInt, strs2(2).toInt, strs(3), strs(5), strs(7).split(',')(0))
  }
}
