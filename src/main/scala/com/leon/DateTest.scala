package com.leon

import java.text.SimpleDateFormat
import java.text._
import java.util.{Locale, Calendar, Date}

/**
  * Created by leon on 2016/2/23.
  */
object DateTest {
  def main(args : Array[String]) : Unit = {
    val date = new Date()

    val months = Array("JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC");
    val sym = new DateFormatSymbols(Locale.CHINA);
    sym.setMonths(months);
    val x = new SimpleDateFormat("dd/MM/yyyy:HH:mm:ss", sym)
    val x1 = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss", sym)

    val s = x.format(date)
    val s1 = "10/APR/2016:13:00:00"

    val s2 = "02/JAN/2000:00:00:00"
    println("getDay : " + getDay(x1.parse(s1)))

    println("****************\n\n")
    println(s)
    println(x.format(x1.parse(s1)))
    println(date)
    println(date.getTime)
    date.setSeconds(0)
    date.setTime((date.getTime/1000)*1000)
    println(date.getTime)
    //println(date.getTimeImpl)
    println("\n\n****************")
    println(x1.parse(s1).getTime)
    println(getMinuteLong(x1.parse(s1)))
  }

  def getDay(d : Date) : String = {
    val s = "%d%02d%02d" format (d.getYear+1900, d.getMonth+1, d.getDate)
    return s
  }

  def getMinuteLong( d: Date) : Long = {
    return (d.getTime/(1000*60))*1000*60
  }
}
