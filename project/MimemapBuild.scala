import sbt._
import sbt.Keys._

object MimemapBuild extends Build {

  lazy val mimemap = Project(
    id = "mimemap",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "mimemap",
      organization := "net.koofr",
      version := "0.2",

      scalaVersion := "2.10.0",
      crossScalaVersions := Seq("2.9.1", "2.9.2", "2.10.0"),

      libraryDependencies += "org.scalatest" %% "scalatest" % "1.9.1" % "test"
    )
  )
}
