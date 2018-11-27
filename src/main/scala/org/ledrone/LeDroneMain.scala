package org.ledrone

import scala.io.Source


object LeDroneMain extends App {
  def returnOk() : String = {
    "ledrone starting"
  }

  case class User(userId : Int, id : Int, title : String, completed : Boolean)

  def getData() : Unit = {
    val data = Source.fromURL("https://jsonplaceholder.typicode.com/todos/1").mkString

    val strData =
      """
        |{"data" : {
        |"key1" : "value1",
        |"key2" : "value2",
        |"key2" : "value3",
        |}}
      """.stripMargin

    val jack = new JSONJackson
//    println(jack.toMap(data).get("userId"))
    val obj = jack.toViewObj(data)
    println(obj.title)

    println(data)
  }
  getData
}