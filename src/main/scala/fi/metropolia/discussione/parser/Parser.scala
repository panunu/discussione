package fi.metropolia.discussione.parser

import fi.metropolia.discussione.analyze.Entry

class Parser(mapping: Map[String, Int], lineSep: String, colSep: String) {
  
  def parse(document: String): List[Entry] =
    (document split lineSep).map(extract).toList
  
  private def extract(entry: String): Entry = {
    val values = entry split colSep
    
    // TODO: Validate that given indexes are found.
    new Entry(
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
}
