package fi.metropolia.discussione.analyze

import scala.collection.Map

abstract class Processable

case class Unprocessed(val date: String, val author: String, val message: String) extends Processable {
  override def toString(): String = "[" + date + "] " + author + ": " + message
}