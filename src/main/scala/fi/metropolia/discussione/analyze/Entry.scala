package fi.metropolia.discussione.analyze

class Entry(val date: String, val author: String, val message: String) {
  override def toString(): String = "[" + date + "] " + author + ": " + message
  
  // Todo: make more flexible. Should contain all the data. Convert to JSON once built.
}