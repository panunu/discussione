package transparency

import entity.{Discussion}
import parser.Parser

object Main {

  def main(args: Array[String]): Unit = {
    
    val document = """|date0:name0:group0:topic0:message0
                      |date1:name1:group1:topic1:message1
                      |date2:name2:group2:topic2:message2""".stripMargin
    
    val content = (Parser createSpreadsheetParser) parse document
        
    println(content.length)
    
    var discussion = new Discussion("asd")
  }

}
