package org.ledrone

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

import scala.io.Source

object LeDroneMain extends App {
  def returnOk() : String = {
    "ledrone starting"
  }

  case class User(userId : Int, id : Int, title : String, completed : Boolean)

  def getData() : Map[String, String] = {
    val data = Source.fromURL("https://jsonplaceholder.typicode.com/todos/1").mkString
    val arrayData = Source.fromFile("/Users/dayah/dayah_projects/drone/scala-project-template/src/main/scala/org/ledrone/testJson.txt").getLines.mkString

    val objectMapper = new ObjectMapper
    objectMapper.registerModule(DefaultScalaModule)

    def arrayToObj(json : String) : List[Map[Any,Any]] = {
      objectMapper.readValue(json, classOf[List[Map[Any,Any]]])
    }


    val arrayObject = arrayToObj(arrayData).head.getOrElse("data", Map.empty)
    arrayObject.asInstanceOf[Map[String,String]]
  }
  println(getData)
}