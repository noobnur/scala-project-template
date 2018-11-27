package org.ledrone

import scala.io.Source
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper

//import com.typesafe.scalalogging.slf4j.Logger
//import org.slf4j.LoggerFactory

object LeDroneMain extends App {
  def returnOk() : String = {
//    val logger = LoggerFactory.getLogger()
//    logger.info("logging is working")
    "ledrone starting"
  }

  case class User(userId : Int, id : Int, title : String, completed : Boolean)



  def getData() : Unit = {
    val data = Source.fromURL("https://jsonplaceholder.typicode.com/todos/1").mkString

    val jack = new JSONJackson
    println(jack.toMap(data))

    println(data)
  }
  getData
}