package transparency.parser

class Parser(mapping: Map[String, Int], 
             lineSeparator: String, 
             colSeparator: String) {
  
  def parse(document: String): Array[Array[String]] = {
    (document split lineSeparator).map(_ split colSeparator)
  }
}

object Parser {
  def createSimpleParser: Parser = {
    val mapping = 
      Map(
        "date"    -> 0,
        "name"    -> 1,
        "group"   -> 2,
        "topic"   -> 3,
        "message" -> 4
      )
    
    new Parser(mapping, "\n", ":")
  }
}