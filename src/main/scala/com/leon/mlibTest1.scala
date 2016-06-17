package com.leon

import org.apache.spark.ml.clustering.KMeans
import org.apache.spark.mllib.clustering.{BisectingKMeans, BisectingKMeansModel}
import org.apache.spark.mllib.linalg.Vectors
import org.apache.spark.{SparkContext, SparkConf}

/**
  * Created by leon on 2016/2/18.
  */
object mlibTest1 {
  def main(args: Array[String]): Unit = {
    println("*****************\n\n" + "\tmlibTest1" + "\n\n*******************\n")

    val conf = new SparkConf().setAppName("mlibTest1")
    val sc = new SparkContext(conf)
    val data = sc.textFile("/tmp/data/simple.data")
    val parsedData = data.map(s => Vectors.dense(s.split(' ').map(_.toDouble))).cache()

    // cluster the data into 6 classes using KMeans
    val numCluster = 2
    val bkm = new BisectingKMeans().setK(numCluster)
    val model = bkm.run(parsedData)

    println("vector 1.0 2.1 3.8 belongs to clustering " + model.predict(Vectors.dense("1.0 2.1 3.8".split(' ').map(_.toDouble))))
    println("vector 2.0 2.1 3.8 belongs to clustering " + model.predict(Vectors.dense("2.0 2.1 3.8".split(' ').map(_.toDouble))))
    println("vector 10.0 12.1 13.8 belongs to clustering " + model.predict(Vectors.dense("10.0 12.1 13.8".split(' ').map(_.toDouble))))
    println(s"Compute Cost : ${model.computeCost(parsedData)}")
  }
}
