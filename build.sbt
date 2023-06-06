enablePlugins(SbtPlugin)

name                := "sbt-scala-module"
sonatypeProfileName := "org.scala-lang"
organization        := "org.scala-lang.modules"
homepage            := Some(url("https://github.com/scala/sbt-scala-module"))
licenses            := Seq(("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0")))
developers          := List(Developer("", "", "", url("https://scala-lang.org")))

addSbtPlugin("com.typesafe.sbt" % "sbt-osgi" % "0.9.6")
addSbtPlugin("de.heikoseeberger" % "sbt-header" % "5.9.0")
addSbtPlugin("com.github.sbt" % "sbt-ci-release" % "1.5.12") // set version, scmInfo, publishing settings
addSbtPlugin("ch.epfl.scala" % "sbt-version-policy" % "2.1.1")  // brings in MiMa
