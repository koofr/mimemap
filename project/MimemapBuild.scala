import sbt._
import sbt.Keys._

object MimemapBuild extends Build {

  lazy val mimemap = Project(
    id = "mimemap",
    base = file("."),
    settings = Project.defaultSettings ++ Seq(
      name := "Mimemap",
      organization := "net.koofr",
      version := "0.1",

      scalaVersion := "2.9.2",
      crossScalaVersions := Seq("2.9.1", "2.9.2"),

      libraryDependencies += "org.scalatest" %% "scalatest" % "1.6.1" % "test"
    )
  )
}
