package fi.metropolia.discussione.analyze.aspect

import fi.metropolia.discussione.analyze._
import ucar.nc2.constants._Coordinate

class Award {

  def all(data: List[Unprocessed]): Map[String, String] = {
    val wordsPerPerson = data.groupBy(_.author).mapValues(_.foldLeft(0)(_ + _.message.split(" ").length))

    Map(
      "mostWords" -> wordsPerPerson.maxBy(_._2)._1,
      "leastWords" -> wordsPerPerson.minBy(_._2)._1
    )
  }

}
