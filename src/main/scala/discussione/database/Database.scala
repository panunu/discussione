package discussione.database

import com.mongodb.casbah.Imports._
import discussione.parser.Parser

class Database {
  
  private val collection = MongoConnection()("db")
  
  def +=(entry: Parser.Entry): Unit = {
    // TODO: Analyze Entry.
    // TODO: Disregard if the message is not considered meaningful?
    
    val persons = collection("person")
    val person = ?(persons, MongoDBObject("name" -> entry.name))
    
    val discussions = collection("discussion")
    val discussion = MongoDBObject(
      "date"    -> entry.date,
      "person"  -> person,
      "topic"   -> entry.topic,
      "message" -> entry.message
    )
    
    //discussions += discussion
    
    println(discussions)
  }
  
  private def ?(collection: MongoCollection, doc: MongoDBObject) = {
    collection.findOne(doc) match {
      case None => collection += doc
      case Some(doc) => doc
    }
  }
  
}