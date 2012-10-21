name := "discussione"

version := "0.1"

scalaVersion := "2.9.1"

org.scalastyle.sbt.ScalastylePlugin.Settings


resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository"

resolvers += "Codahale Repisotry" at "http://repo.codahale.com"


libraryDependencies += "com.rabbitmq" % "amqp-client" % "2.8.2"

libraryDependencies += "com.typesafe.akka" % "akka-actor" % "2.0.2"

libraryDependencies += "fi.metropolia.ereading" % "Juju" % "0.0.1-SNAPSHOT" withSources()

libraryDependencies += "org.scalatest" %% "scalatest" % "1.8" % "test"

libraryDependencies += "org.scalaj" %% "scalaj-collection" % "1.2"

libraryDependencies += "com.codahale" %% "jerkson" % "0.5.0"
