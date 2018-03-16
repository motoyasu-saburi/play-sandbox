name := """thulcandra"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

resolvers += Resolver.sonatypeRepo("snapshots")

scalaVersion := "2.12.4"

crossScalaVersions := Seq("2.11.12", "2.12.4")

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "3.1.2" % Test
libraryDependencies += "com.h2database" % "h2" % "1.4.196"
libraryDependencies ++= dependencies

val dependencies = Seq(
  filters,
  "com.typesafe.play"             %% "play-slick"                          % "3.0.3",
  "com.typesafe.slick"            %% "slick-codegen"                       % "3.2.2",
  "com.typesafe.slick"            %% "slick-hikaricp"                      % "3.2.1",
  "org.scalaz"    %% "scalaz-core" % "7.2.12",
  "org.scala-lang"                 %  "scala-reflect"                      % "2.11.12",
  "org.apache.httpcomponents"      % "httpclient"                          % "4.3.4",
  "com.google.apis"                % "google-api-services-calendar"        % "v3-rev175-1.21.0"
    exclude ("com.fasterxml.jackson.core", "jackson-core")
    exclude ("com.google.code.findbugs", "jsr305")
    exclude ("com.google.guava", "guava-jdk5")
    exclude ("org.apache.httpcomponents", "httpclient"),
  "com.ibm.icu"                      % "icu4j"             % "58.2",
  "org.scalaz"                    %% "scalaz-scalacheck-binding"           % "7.2.12"                % "test",
  "com.h2database"                 % "h2"                                  % "1.4.178"               % "test",
  "mysql"                          % "mysql-connector-java"                % "5.1.38",
)

