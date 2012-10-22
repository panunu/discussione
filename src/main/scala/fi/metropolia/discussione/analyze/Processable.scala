package fi.metropolia.discussione.analyze

import scala.collection.Map

abstract class Processable

case class Unprocessed(val date: String, val author: String, val message: String) extends Processable {
	override def toString(): String = "[" + date + "] " + author + ": " + message
}

case class Processed(val data: Unprocessed, val keyphrases: Map[String, Double]) extends Processable {
  override def toString(): String = data.toString + " " + keyphrases
}

// Todo: make it more flexible. Should contain all the data. Convert to JSON once built.