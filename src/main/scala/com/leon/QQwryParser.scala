package com.leon

import java.io.PrintWriter

import scala.io.Source

/**
  * Created by leon on 2016/6/30.
  */
object QQwryParser {
  def main(args : Array[String]) : Unit = {
    println("Hi, this is qqwry data file process program")

    //makeNocityFile()
    //makeChinaFile()
    makeFinalFile()
  }

  def makeFinalFile() : Unit = {
    val out = new PrintWriter("d:\\workroom\\testroom\\final.txt")
    val lines = Source.fromFile("d:\\workroom\\testroom\\china.txt").getLines()

    val units = lines.map( line => {
      val strs = line.split('\t')
      (ip2Long(strs(0)), ip2Long(strs(1)), strs(2))
    }).toArray

    var start : Long = 0
    var end : Long = 0
    var key = ""

    units.foreach( unit => {
      if ((unit._1==(end+1) || unit._1==end) && unit._3==key) {
        end = unit._2
      } else {
        out.println(long2ip(start) + "\t" + long2ip(end) + "\t" + key)
        start = unit._1
        end = unit._2
        key = unit._3
      }
    })
    out.println(long2ip(start) + "\t" + long2ip(end) + "\t" + key)
    out.close()
  }

  def ip2Long(ip : String) : Long = {
    val strs = ip.split('.')
    val ipLong : Long = strs(0).toLong*256 *256l*256l + strs(1).toLong*256*256  + strs(2).toLong*256l + strs(3).toLong
    ipLong
  }

  def long2ip(ipLong : Long) : String = {
    val u0 = ipLong/(256*256*256)
    val u1 = ipLong/(256*256) - u0*256
    val u2 = ipLong/256 - u1*256 - u0*256*256
    val u3 = ipLong - u2*256 - u1*256*256 - u0*256*256*256
    val ip = u0 + "." + u1 + "." + u2 + "." + u3
    ip
  }

  def makeChinaFile() : Unit = {
    val out = new PrintWriter("d:\\workroom\\testroom\\china.txt")
    val lines = Source.fromFile("d:\\workroom\\testroom\\no-city.txt").getLines()
    lines.foreach( line => {
      val strs = line.split(' ')
      if (strs(4).contains("北京")) out.println(strs(0) + "\t" + strs(2) + "\t" + "BJ")
      if (strs(4).contains("上海")) out.println(strs(0) + "\t" + strs(2) + "\t" + "SH")
      if (strs(4).contains("天津")) out.println(strs(0) + "\t" + strs(2) + "\t" + "TJ")
      if (strs(4).contains("重庆")) out.println(strs(0) + "\t" + strs(2) + "\t" + "CQ")
      if (strs(4).contains("黑龙江")) out.println(strs(0) + "\t" + strs(2) + "\t" + "HL")
      if (strs(4).contains("辽宁")) out.println(strs(0) + "\t" + strs(2) + "\t" + "LN")
      if (strs(4).contains("吉林")) out.println(strs(0) + "\t" + strs(2) + "\t" + "JL")
      if (strs(4).contains("河北")) out.println(strs(0) + "\t" + strs(2) + "\t" + "HB")
      if (strs(4).contains("河南")) out.println(strs(0) + "\t" + strs(2) + "\t" + "HE")
      if (strs(4).contains("湖北")) out.println(strs(0) + "\t" + strs(2) + "\t" + "HU")
      if (strs(4).contains("湖南")) out.println(strs(0) + "\t" + strs(2) + "\t" + "HN")
      if (strs(4).contains("山东")) out.println(strs(0) + "\t" + strs(2) + "\t" + "SD")
      if (strs(4).contains("山西")) out.println(strs(0) + "\t" + strs(2) + "\t" + "SX")
      if (strs(4).contains("陕西")) out.println(strs(0) + "\t" + strs(2) + "\t" + "SA")
      if (strs(4).contains("安徽")) out.println(strs(0) + "\t" + strs(2) + "\t" + "AH")
      if (strs(4).contains("浙江")) out.println(strs(0) + "\t" + strs(2) + "\t" + "ZJ")
      if (strs(4).contains("江苏")) out.println(strs(0) + "\t" + strs(2) + "\t" + "JS")
      if (strs(4).contains("福建")) out.println(strs(0) + "\t" + strs(2) + "\t" + "FJ")
      if (strs(4).contains("广东")) out.println(strs(0) + "\t" + strs(2) + "\t" + "GD")
      if (strs(4).contains("海南")) out.println(strs(0) + "\t" + strs(2) + "\t" + "HA")
      if (strs(4).contains("四川")) out.println(strs(0) + "\t" + strs(2) + "\t" + "SC")
      if (strs(4).contains("云南")) out.println(strs(0) + "\t" + strs(2) + "\t" + "YN")
      if (strs(4).contains("贵州")) out.println(strs(0) + "\t" + strs(2) + "\t" + "GZ")
      if (strs(4).contains("青海")) out.println(strs(0) + "\t" + strs(2) + "\t" + "QH")
      if (strs(4).contains("甘肃")) out.println(strs(0) + "\t" + strs(2) + "\t" + "GS")
      if (strs(4).contains("江西")) out.println(strs(0) + "\t" + strs(2) + "\t" + "JX")
      if (strs(4).contains("台湾")) out.println(strs(0) + "\t" + strs(2) + "\t" + "TW")
      if (strs(4).contains("香港")) out.println(strs(0) + "\t" + strs(2) + "\t" + "XG")
      if (strs(4).contains("澳门")) out.println(strs(0) + "\t" + strs(2) + "\t" + "MO")
      if (strs(4).contains("内蒙古")) out.println(strs(0) + "\t" + strs(2) + "\t" + "NM")
      if (strs(4).contains("宁夏")) out.println(strs(0) + "\t" + strs(2) + "\t" + "NX")
      if (strs(4).contains("新疆")) out.println(strs(0) + "\t" + strs(2) + "\t" + "XJ")
      if (strs(4).contains("西藏")) out.println(strs(0) + "\t" + strs(2) + "\t" + "XZ")
      if (strs(4).contains("广西")) out.println(strs(0) + "\t" + strs(2) + "\t" + "GX")
    })
    out.close()
  }

  def makeNocityFile() : Unit = {
    val out = new PrintWriter("d:\\workroom\\testroom\\no-city.txt")
    val lines = Source.fromFile("d:\\workroom\\testroom\\qqwry-utf.txt").getLines()
    lines.foreach( line => {
      val strs = line.split('\t')
      out.println(strs(0))
    })
    out.close
  }
}
