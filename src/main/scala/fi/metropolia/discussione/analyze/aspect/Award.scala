package fi.metropolia.discussione.analyze.aspect

import fi.metropolia.discussione.analyze._
import ucar.nc2.constants._Coordinate

class Award {

  def all(data: List[Unprocessed]): Awarded = {
    val byAuthor = data.groupBy(_.author)
    val wordsPerAuthor = byAuthor.mapValues(_.foldLeft(0)(_ + _.message.split(" ").length))
    val discussionsPerAuthor = byAuthor.mapValues(_.size)

    new Awarded(
      wordsPerAuthor.maxBy(_._2)._1,
      wordsPerAuthor.minBy(_._2)._1,
      discussionsPerAuthor.maxBy(_._2)._1
    )
  }

}
