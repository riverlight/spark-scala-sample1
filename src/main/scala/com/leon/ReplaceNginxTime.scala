package com.leon

import java.text.SimpleDateFormat
import java.util.{Locale, Calendar, Date}

import com.leon.util.InvalidNginxLogException

/**
  * Created by leon on 2016/2/23.
  */
object ReplaceNginxTime extends App {
  val strOld = """10.10.177.7 - - [01/Dec/2015:23:51:40 +0800] "GET /api/bubbles/v2?pn=0&ps=10&v=55ce401e289098b274929c09 HTTP/1.1" 200 68 "http://www.77hp1.net/77hpzx/2015/08-227-1-1.html" "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36" "116.4.123.205, 10.10.251.132""""
  //val strOld = "haha"
  println(strOld + "\n****\n")

  try {
    val strNew = replaceLogDate(strOld)
    println(strNew + "\n****\n")
  }
  catch {
    case ex : InvalidNginxLogException => { println("\n\nInvalidNginxLogException\n\n")}
  }

  def replaceLogDate(strOld : String) : String = {
    val date = new Date()
    val strDate = String.format(Locale.US, "%td/%tb/%tC%ty:%tH:%tM:%tS",date, date, date, date, date, date, date)

    val strs = strOld.split(']')
    if (strs.length!=2)
      throw new InvalidNginxLogException()

    val strs0 = strs(0).split('[')
    if (strs0.length!=2)
      throw new InvalidNginxLogException()
    val strs01 = strs0(1).split(' ')
    if (strs01.length!=2)
      throw new InvalidNginxLogException()

    val strNew = strs0(0) + "[" + strDate + " " + strs01(1) +"]" + strs(1)
    strNew
  }
}
