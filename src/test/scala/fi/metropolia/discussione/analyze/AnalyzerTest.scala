package fi.metropolia.discussione.analyze

import org.scalatest.FunSuite
import org.scalatest._

class AnalyzerTest extends FunSuite with BeforeAndAfter {
  val target: Analyzer = new Analyzer
  val entry:Entry = new Entry("Anni", "2012-10-10", "puhe")
  
  test("analyzeOne converts Entry to Processed") {    
    assert(target.analyzeOne(entry).isInstanceOf[Processed])
  }
  
  test("analyzeOne keyphrases message to Map with String key") {    
    assert(target.analyzeOne(entry).keyphrases == Map("puhe" -> 1.0))
  }
  
}