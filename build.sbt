name := """CsvProcessor"""
version := "1.0"
scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.0.9",
  "com.typesafe.akka" %% "akka-stream" % "2.5.4",
  "com.typesafe.akka" %% "akka-slf4j" % "2.4.17",
  "com.typesafe.akka" %% "akka-http-jackson" % "10.1.2",
  "com.lightbend.akka" %% "akka-stream-alpakka-file" % "0.11",
  "com.lightbend.akka" %% "akka-stream-alpakka-csv" % "0.11",
  "com.google.inject" % "guice" % "4.0",
  "ch.qos.logback" % "logback-classic" % "1.1.7",
  "commons-lang" % "commons-lang" % "2.3",
  "commons-cli" % "commons-cli" % "1.2",
  "org.scalatest" %% "scalatest" % "3.0.1" % Test,
  "io.rest-assured" % "scala-support" % "3.0.2" % Test
)
