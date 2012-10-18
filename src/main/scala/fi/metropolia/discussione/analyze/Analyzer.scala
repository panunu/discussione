package fi.metropolia.discussione.analyze

import fi.metropolia.discussione.parser.Parser

class Analyzer {

  def analyze(content: List[Parser.Entry]) = {
    content.map(println)
  }
  
}