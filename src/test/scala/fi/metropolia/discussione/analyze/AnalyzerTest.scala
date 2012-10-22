package fi.metropolia.discussione.analyze

import org.scalatest.FunSuite
import org.scalatest._

class AnalyzerTest extends FunSuite with BeforeAndAfter {
  val target: Analyzer = new Analyzer
  val unprocessed:Unprocessed = new Unprocessed("Anni", "2012-10-10", "puhe")
  
  test("analyzeOne converts Unprocessed to Processed") {    
    assert(target.analyzeOne(unprocessed).isInstanceOf[Processed])
  }
  
  test("analyzeOne keyphrases message to Map with String key") {    
    assert(target.analyzeOne(unprocessed).keyphrases == Map("puhe" -> 1.0))
  }
  
}