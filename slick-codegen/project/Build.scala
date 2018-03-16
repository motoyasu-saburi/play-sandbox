import sbt.Keys._
import sbt._

object myBuild extends Build {
  lazy val mainProject = Project(
    id="slick-codegen",
    base=file("."),
    settings = Project.defaultSettings ++ Seq(
      scalaVersion := "2.11.6",
      libraryDependencies ++= List(
        "com.typesafe.slick" %% "slick" % "3.0.3",
        "com.typesafe.slick" %% "slick-codegen" % "3.2.2",
        "mysql" % "mysql-connector-java" % "5.1.38",
        "org.slf4j" % "slf4j-nop" % "1.6.4"
      ),
      slick <<= slickCodeGenTask,
      sourceGenerators in Compile <+= slickCodeGenTask
    )
  )

  lazy val slick = TaskKey[Seq[File]]("slick-codegen")
  lazy val slickCodeGenTask = (sourceManaged, dependencyClasspath in Compile, runner in Compile, streams) map { (dir, cp, r, s) =>
    val outputDir = "../app"
    val url = "jdbc:mysql://127.0.0.1/thulcandra"
    val username = "root"
    val password = ""
    val jdbcDriver = "com.mysql.jdbc.Driver"
    val slickDriver = "slick.jdbc.MySQLProfile"
    val pkg = "models"
    toError(r.run("slick.codegen.SourceCodeGenerator", cp.files, Array(slickDriver, jdbcDriver, url, outputDir, pkg, username, password), s.log))
    val fname = outputDir + "/models/Tables.scala"
    Seq(file(fname))
  }
}
