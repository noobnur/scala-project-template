package org.ledrone

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.scala.DefaultScalaModule

import scala.reflect.ClassTag
import scala.reflect._

class JSONJackson {

  val objectMapper = new ObjectMapper
  objectMapper.registerModule(DefaultScalaModule)

  def toJson(value: Map[Symbol, Any]): String = {
    toJson(value map { case (k,v) => k.name -> v})
  }

  def toJson(value: Any): String = {
    objectMapper.writeValueAsString(value)
  }

  def toMap[V](json:String)(implicit m: Manifest[V]) = fromJson[Map[String,V]](json)

  def fromJson[T: ClassTag](json: String): T = {
    objectMapper.readValue[T](json, classTag[T].runtimeClass.asInstanceOf[Class[T]])
  }
}
