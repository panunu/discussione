package fi.metropolia.discussione

import discussione.amqp.AMQP
import akka.actor.ActorSystem
import akka.actor.Props
import discussione.amqp.AnalyzerActor

object Main {
  
  def main(args: Array[String]): Unit = {    
    val system = ActorSystem("System")
    val analyzer = system.actorOf(Props[AnalyzerActor], name = "analyzer")
    
    println("Initializing consumer...")
    val consumer = new AMQP
    consumer consume("upload-material", (message: String) => analyzer ! message)
  }

}