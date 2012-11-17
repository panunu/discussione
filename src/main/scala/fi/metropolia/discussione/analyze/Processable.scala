package fi.metropolia.discussione.analyze

import scala.collection.Map

abstract class Processable

case class Unprocessed(val author: String, val message: String) extends Processable {
  override def toString(): String = author + ": " + message
}