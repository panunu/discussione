package fi.metropolia.discussione.analyze

import org.scalatest.FunSuite
import org.scalatest._
import fi.metropolia.discussione.parser.Parser

class AnalyzerTest extends FunSuite with BeforeAndAfter {
  val target: Analyzer = new Analyzer
  
  test("analyze returns a Map") {
    assert(target.extract("asd") != null)
  }
}