package com.leon

import java.io.PrintWriter;

/**
  * Created by leon on 2016/2/1.
  */
object videoEventFile extends App {
  if (args.length!=2) {
    System.err.println("Usage: videoEventFile <fileName> <messagesPerSec> ")
    System.exit(1)
  }

  val Array(fileName, messagesPerSec) = args
  val out = new PrintWriter(fileName)

  val str = "{\"cat\":4,\"user\":null,\"video\":\"568e724811cdf38f01556e82\",\"ip\":\"182.38.192.128\",\"user_Agent\":\"Mozilla/5.0 (Linux; U; Android 4.3; zh-cn; R8007 Build/JLS36C) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30\",\"referer\":\"http://www.iqiyi.com/marketing/ksfw.html\",\"identity\":\"1452268301081r3wk4k8r\",\"cms\":null,\"created\":\"2016-01-08T15:51:43.380Z\",\"app\":{\"_id\":\"567b4850c89172df00b18a82\",\"project\":\"567b4850c89172df00b18a81\"}}"
  while(true) {
    (1 to messagesPerSec.toInt).foreach { msgID =>
      out.println(str)
    }
    println("producer ... ")
    Thread.sleep(1000)
  }
}
