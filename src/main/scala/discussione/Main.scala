package discussione

import parser.Parser
import com.mongodb.casbah.Imports._
import database.Database

object Main {
  
  def main(args: Array[String]): Unit = {    
    val document = """|26.05.2012 14:00;Kent Beck;group0;TDD;What to test?
                      |26.05.2012 14:01;Martin Fowler;group1;TDD;Everything
                      |26.05.2012 14:03;Bob Martin;group2;TDD;Not everything""".stripMargin
    
    val content = Parser.simple << document
        
    val db = new Database()
    content.map(db += _)
  }

}