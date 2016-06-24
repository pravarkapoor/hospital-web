name := """hospital-web"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)
unmanagedBase := baseDirectory.value / "lib"
libraryDependencies += "org.jdbi" % "jdbi" % "2.73"





fork in run := false