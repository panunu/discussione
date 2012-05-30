package transparency.parser

class Parser(mapping: Map[String, Int], lineSep: String, colSep: String) {
  
  def <<(document: String): Array[Parser.Entry] =
    (document split lineSep).map(extract)
  
  private def extract(entry: String): Parser.Entry = {
    val values = entry split colSep
    
    new Parser.Entry(
      values(mapping("date")),
      values(mapping("name")),
      values(mapping("topic")),
      values(mapping("message"))
    )
  }
  
}

object Parser {
  
  def simple: Parser = {
    val mapping = 
      Map(
        "date"    -> 0,
        "name"    -> 1,
        "topic"   -> 3,
        "message" -> 4
      )
    
    new Parser(mapping, "\n", ";")
  }
  
  class Entry(val date: String, val name: String, val topic: String, val message: String) {
    override def toString = "[" + date + "] " + name + ": " + message
  }
  
}