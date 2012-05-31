name := "discussione"

version := "0.1"

scalaVersion := "2.9.1"

libraryDependencies += "com.mongodb.casbah" % "casbah_2.9.0-1" % "2.1.5.0"

libraryDependencies ++= Seq("org.slf4j" % "slf4j-simple" % "1.6.4", "org.slf4j" % "slf4j-api" % "1.6.4")

seq(netbeans.NetbeansTasks.netbeansSettings:_*)
