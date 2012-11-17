package fi.metropolia.discussione.analyze.aspect

import scala.collection.mutable.Map
import fi.metropolia.discussione.analyze._

class Difference {
  val keyphrase = new Keyphrase
  val jaccard = new Jaccard

  /**
   * Calculates differences (distances) for discussions (uses keyphrases).
   * Calculation is based on a weighted Jaccard distance.
   */
  def all(data: List[Unprocessed]) = {
    val keyphrased = data.map((original:Unprocessed) => Map("author" -> original.author, "keyphrases" -> keyphrase.single(original).map(_._1)))
    val keyphrases = keyphrase all data

    // { author: "A", x: x, y: Math.random(), z: Math.random()})
    println(keyphrases)

    keyphrased
  }
  
}

class Jaccard {

  def index(a: String, b: String): Double = index(split(a), split(b))
  def index(a: Set[String], b: Set[String]): Double = a.intersect(b).size / a.union(b).size.asInstanceOf[Double]

  def distance(a:String, b: String): Double = distance(split(a), split(b))
  def distance(a: Set[String], b: Set[String]): Double = 1.0 - index(a, b)

  private def split(x: String): Set[String] = x.split(" ").toSet

}