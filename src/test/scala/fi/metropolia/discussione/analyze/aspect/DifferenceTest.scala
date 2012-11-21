package fi.metropolia.discussione.analyze.aspect

import org.scalatest._
import fi.metropolia.discussione.analyze.Unprocessed

class DifferenceTest extends FunSuite with BeforeAndAfter {
  val difference = new Difference

  val unprocessed = List(
    new Unprocessed("A", "omena appelsiini banaani"),
    new Unprocessed("B", "omena appelsiini banaani"),
    new Unprocessed("C", "omena banaani"),
    new Unprocessed("D", "peruna")
  )

  test("calculates difference") {
  }
}