package fi.metropolia.discussione.parser

class Parser(mapping: Map[String, Int], lineSep: String, colSep: String) {
  
  def parse(document: String): List[Parser.Entry] =
    (document split lineSep).map(extract).toList
  
  private def extract(entry: String): Parser.Entry = {
    val values = entry split colSep
    
    // TODO: Validate that given indexes are found.
    new Parser.Entry(
      values(mapping("date")),
      values(mapping("author")),
      values(mapping("message"))
    )
  }
  
}

object Parser {
  
  def simple: Parser = {
    val mapping = Map(
      "date" -> 0,
      "author" -> 1,
      "message" -> 2)
    
    new Parser(mapping, "\n", ";")
  }

  // Todo: make more flexible. Should contain all the data. Convert to JSON once built.
  class Entry(val date: String, val author: String, val message: String) {
    override def toString(): String = "[" + date + "] " + author + ": " + message
  }
  
}
