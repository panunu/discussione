resolvers += "sonatype-snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/"

resolvers += "sbt-idea-repo" at "http://mpeltonen.github.com/maven/"

addSbtPlugin("com.typesafe.sbteclipse" % "sbteclipse-plugin" % "2.1.0")

addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.2.0-SNAPSHOT")

addSbtPlugin("com.github.mpeltonen" % "sbt-idea" % "1.1.0")
