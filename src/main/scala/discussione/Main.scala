package discussione

import parser.Parser
import discussione.amqp.AMQP
import akka.actor.ActorSystem
import akka.actor.Props
import discussione.amqp.AnalyzerActor

object Main {
  
  def main(args: Array[String]): Unit = {    
    val document = """|2012-05-26 14:00;Kent Beck;What to test?
                      |2012-05-26 14:01;Martin Fowler;Everything
                      |2012-05-26 14:03;Bob Martin;Not everything""".stripMargin
    
    //val content = Parser.simple.parse(document)
    //content.map(println)
    
    val system = ActorSystem("System")
    val analyzer = system.actorOf(Props[AnalyzerActor], name = "analyzer")
    
    val consumer = new AMQP
    consumer consume("upload-material", (message: String) => analyzer ! message)
    consumer.close()
    
    system.shutdown()
  }

}