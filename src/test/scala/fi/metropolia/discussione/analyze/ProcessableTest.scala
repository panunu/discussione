package fi.metropolia.discussione.analyze

import org.scalatest._
import com.codahale.jerkson.Json._

class ProcessableTest extends FunSuite {

  test("Processable can be generated into JSON") {
    val json = generate(
        new Processed(new Unprocessed("1", "A", "m"), Map())
    )
    
    assert(json.contains("\"keyphrases\":{}"))
    assert(json.contains("\"author\":\"A\""))
  }
  
}