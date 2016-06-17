package com.leon

import scala.io.Source

/**
  * Created by leon on 2016/2/1.
  */
class linzConfig {
  private var pdbHost : String = "localhost";
  private var pdbPort : Int = 27017;

  // mongo db
  private var pdbUserName : String = "leon";
  private var pdbPassword : String = "123";
  private var pdbDatabase : String = "sca";
  private var pdbCollName : String = "mysca";

  // flume
  private var pflHostname : String = "localhost";
  private var pflPort : Int = 11114

  // redis
  private var predisHost = "10.10.81.101"
  private var predisPort : Int = 7001

  //kafka需要zookeeper作为集群协同服务器
  private var pzkQuorum = "10.10.69.166:2181";

  //消费者Group名称, kafka的每个消费者都必须标记自己所在的Group
  private var pconsumerGroup = "test-consumer-group";
  private var ptopicNames = "test";
  private var pperiod = 2;

  //每个InputStream运行一个Receiver, 同一个Receiver可以运行多个线程.
  //这里指定3个线程同时读取InputStream
  private var pthreadsPerInputStream = 1;

  def this(configFile:String) {
    this()
    parseConfig(configFile)
    printConf
  }

  private def parseConfig(confFile : String) : Unit = {
    for (line <- Source.fromFile(confFile).getLines() if ((line.length>=3) && (line.charAt(0)!='#'))) {
      val keyVal = line.split("=")
      println(keyVal(0))
      keyVal(0) match {
        case "dbHost" => dbHost = keyVal(1);
        case "dbPort" => dbPort = keyVal(1).toInt;
        case "dbUserName" => dbUserName = keyVal(1);
        case "dbPassword" => dbPassword = keyVal(1);
        case "dbDatabase" => dbDatabase = keyVal(1);
        case "dbCollName" => dbCollName = keyVal(1);
        case "flHostname" => flHostname = keyVal(1);
        case "flPort" => flPort = keyVal(1).toInt;
        case "zkQuorum" => zkQuorum = keyVal(1);
        case "consumerGroup" => consumerGroup = keyVal(1);
        case "topics" => topicNames = keyVal(1);
        case "threads" => threadsPerInputStream = keyVal(1).toInt;
        case "period" => period = keyVal(1).toInt;
        case "redisHost" => redisHost = keyVal(1);
        case "redisPort" => redisPort = keyVal(1).toInt;
        case _ => ;
      }
    }
  }

  def printConf(): Unit = {
    println(dbHost + " " + dbPort + " " + dbUserName + " " + dbPassword + " " + dbDatabase + " " + dbCollName + " " + flHostname + " " + flPort)
    println(zkQuorum + " " + consumerGroup + " " + topicNames + " " + threadsPerInputStream + " " + period + " " + redisHost + " " + redisPort)
  }

  def dbHost = pdbHost
  def dbHost_=(host:String) { pdbHost = host }
  def dbPort = pdbPort
  def dbPort_=(port:Int) { pdbPort = port }
  def dbUserName = pdbUserName
  def dbUserName_=(user:String) { pdbUserName = user }
  def dbPassword = pdbPassword
  def dbPassword_=(pwd:String) { pdbPassword = pwd }
  def dbDatabase = pdbDatabase
  def dbDatabase_=(db:String) { pdbDatabase = db }
  def dbCollName = pdbCollName
  def dbCollName_=(name:String) { pdbCollName = name }
  def flHostname = pflHostname
  def flHostname_=(host:String) { pflHostname = host }
  def flPort = pflPort
  def flPort_=(port:Int) { pflPort = port }
  def redisHost = predisHost
  def redisHost_=(host:String) { predisHost = host }
  def redisPort = predisPort
  def redisPort_=(port:Int) { predisPort = port }
  def zkQuorum = pzkQuorum
  def zkQuorum_=(zk:String) { pzkQuorum = zk }
  def consumerGroup = pconsumerGroup
  def consumerGroup_=(cG:String) { pconsumerGroup = cG }
  def topicNames = ptopicNames
  def topicNames_=(name:String) { ptopicNames = name }
  def period = pperiod;
  def period_=(p:Int) { pperiod = p }
  def threadsPerInputStream = pthreadsPerInputStream;
  def threadsPerInputStream_=(threadsPerInputStream: Int) { pthreadsPerInputStream = threadsPerInputStream; }
}
