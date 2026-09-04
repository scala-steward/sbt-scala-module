sys.props.get("plugin.version") match {
  case Some(v) => addSbtPlugin("org.scala-lang.modules" % "sbt-scala-module" % v)
  case None    => sys.error("The system property 'plugin.version' is not defined.")
}
