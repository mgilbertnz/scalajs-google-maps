import sbt.Keys._

lazy val root = project.in(file(".")).
  enablePlugins(ScalaJSPlugin).settings(
  //credentials += Credentials(Path.userHome / ".ivy2" / ".credentials"),
  //resolvers += "NextWave Repo" at "http://maxdevmaster.cloudapp.net:4343/artifactory/nxtwv-maven/",
  //publishTo := Some("NextWave Repo" at "http://maxdevmaster.cloudapp.net:4343/artifactory/nxtwv-maven/")
  publishMavenStyle := true,
  publishTo := Some("releases" at "https://nexus.s-art.co.nz/repository/maven-releases"),
  //  publishTo := Some("Nexus" at "http://nexus.financialplatforms.co.nz:8081/nexus/content/repositories/releases"),
  credentials += Credentials(Path.userHome / ".ivy2" / ".credentials.sa"),
  credentials += Credentials(Path.userHome / ".ivy2" / ".credentials.fp"),
)

lazy val demo = (project in file("demo"))
  .settings(demoSettings: _*)
  .enablePlugins(ScalaJSPlugin)
  .dependsOn(root)


val scalaV = "2.12.12"
val scalajsDomV = "1.0.0"

lazy val demoSettings = Seq(
  name := s"gmap-demo",
  scalaVersion := scalaV,
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % scalajsDomV
  )
)

name := "Type-safe and Scala-friendly library over Google Maps"

normalizedName := "scalajs-google-maps"

version := "0.0.4"

organization := "com.sa"

scalaVersion := scalaV

crossScalaVersions := Seq(scalaV)

libraryDependencies ++= Seq(
  "org.scala-js" %%% "scalajs-dom" % scalajsDomV
)

// jsDependencies in Test += RuntimeDOM

