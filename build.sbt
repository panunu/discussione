name := "discussione"

version := "0.1"

scalaVersion := "2.9.1"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies ++= Seq("org.slf4j" % "slf4j-simple" % "1.6.4", "org.slf4j" % "slf4j-api" % "1.6.4")

libraryDependencies += "com.rabbitmq" % "amqp-client" % "2.8.2"

libraryDependencies += "com.typesafe.akka" % "akka-actor" % "2.0.2"