package fi.metropolia.discussione.parser

import fi.metropolia.discussione.analyze.Unprocessed

class Parser(mapping: Map[String, Int], lineSep: String, colSep: String) {
  
  def parse(document: String): List[Unprocessed] =
    (document split lineSep).map(extract).toList
  
  private def extract(entry: String): Unprocessed = {
    val values = entry split colSep
    
    // TODO: Validate that given indexes are found.
    new Unprocessed(
      values(mapping("author")),
      values(mapping("message"))
    )
  }  
}

object Parser {  
  def simple: Parser = {
    val mapping = Map(
      "author" -> 0,
      "message" -> 1)
    
    new Parser(mapping, "\n", ";")
  }  
}
