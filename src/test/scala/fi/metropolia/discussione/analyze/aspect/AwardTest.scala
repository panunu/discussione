package fi.metropolia.discussione.analyze.aspect

import org.scalatest._
import fi.metropolia.discussione.analyze.Unprocessed

class AwardTest extends FunSuite with BeforeAndAfter {
  val award = new Award

  val unprocessed = List(
    new Unprocessed("", "A", "alpha omega phi xi"),
    new Unprocessed("", "B", "alpha xi"),
    new Unprocessed("", "C", "omega"),
    new Unprocessed("", "A", "trol lol loo")
  )

  test("collects the person with the most words in discussion") {
    assert(award.all(unprocessed)("mostWords") == "A")
  }

  test("collects the person with the least words in discussion") {
    assert(award.all(unprocessed)("leastWords") == "C")
  }
  
}