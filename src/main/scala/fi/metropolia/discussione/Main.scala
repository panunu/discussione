package fi.metropolia.discussione

import fi.metropolia.discussione.amqp.AMQP
import akka.actor.ActorSystem
import akka.actor.Props
import fi.metropolia.discussione.amqp.AnalyzerActor

object Main {
  
  def main(args: Array[String]): Unit = {    
    val system = ActorSystem("System")
    val analyzer = system.actorOf(Props[AnalyzerActor], name = "analyzer")
    
    println("Initializing consumer...")
    val consumer = new AMQP
    consumer consume("upload-material", (message: String) => analyzer ! message)
  }

}