package fi.metropolia.discussione.analyze.aspect

import fi.metropolia.discussione.analyze._
import ucar.nc2.constants._Coordinate

class Award {

  def all(data: List[Unprocessed]): Map[String, String] = {
    val byAuthor = data.groupBy(_.author)
    val wordsPerAuthor = byAuthor.mapValues(_.foldLeft(0)(_ + _.message.split(" ").length))
    val discussionsPerAuthor = byAuthor.mapValues(_.size)

    Map(
      "mostWords" -> wordsPerAuthor.maxBy(_._2)._1,
      "leastWords" -> wordsPerAuthor.minBy(_._2)._1,
      "mostDiscussions" -> discussionsPerAuthor.maxBy(_._2)._1
    )
  }

}
