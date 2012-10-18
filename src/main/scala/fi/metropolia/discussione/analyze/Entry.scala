package fi.metropolia.discussione.analyze

import scala.collection.Map

class Entry(val date: String, val author: String, val message: String) {
   override def toString(): String = "[" + date + "] " + author + ": " + message
}

class Processed(date: String, author: String, message: String, val keyphrases: Map[String, Double]) 
  extends Entry(date, author, message) {
  override def toString(): String = super.toString + " " + keyphrases
}

// Todo: make it more flexible. Should contain all the data. Convert to JSON once built.