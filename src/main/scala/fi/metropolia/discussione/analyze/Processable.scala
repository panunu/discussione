package fi.metropolia.discussione.analyze

abstract class Processable
abstract class Processed extends Processable

case class Unprocessed(val author: String, val message: String) extends Processable {
  override def toString(): String = author + ": " + message
}

case class Differenced(val author: String, val x:Double, val y:Double) extends Processed

case class Streamed(val word: String, val x:Double, val y:Double) extends Processed