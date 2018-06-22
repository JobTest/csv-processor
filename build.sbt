name := """CsvProcessor"""
version := "1.0"
scalaVersion := "2.12.1"

// Change this to another test framework if you prefer
libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http_2.12" % "10.0.9",
  "com.typesafe.akka" %% "akka-stream_2.12" % "2.5.4",
  "com.lightbend.akka" %% "akka-stream-alpakka-file_2.12" % "0.11",
  "com.lightbend.akka" %% "akka-stream-alpakka-csv_2.12" % "0.11",
  "ch.qos.logback" %% "logback-classic" % "1.1.7",
  "com.google.inject" %% "guice" % "4.0",
  "com.typesafe.akka" %% "akka-http-jackson_2.12" % "10.1.2",
  "commons-lang" %% "commons-lang" % "2.3",
  "commons-cli" %% "commons-cli" % "1.2"
)

