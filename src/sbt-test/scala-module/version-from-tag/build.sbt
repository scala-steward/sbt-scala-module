import complete.DefaultParsers._

val checkRelease = inputKey[Unit]("Assert a clean release version derived from a tag")
val checkSnapshot = inputKey[Unit]("Assert a snapshot version with the given prefix")

lazy val root = project.in(file(".")).settings(
  checkRelease := {
    val expected = spaceDelimited("<version>").parsed.head
    val actual = version.value
    assert(actual == expected, s"expected version '$expected', got '$actual'")
    assert(!isSnapshot.value, s"expected a release, but isSnapshot is true (version '$actual')")
    // sbt-dynver >= 5.1.1 only reports isTag for the GitTag subclass it parses itself
    assert(dynverGitDescribeOutput.value.exists(_.ref.isTag), "expected dynver to detect a tag")
  },

  checkSnapshot := {
    val prefix = spaceDelimited("<prefix>").parsed.head
    val actual = version.value
    assert(actual.startsWith(prefix) && actual.endsWith("-SNAPSHOT"), s"expected version '$prefix...-SNAPSHOT', got '$actual'")
    assert(isSnapshot.value, s"expected a snapshot, but isSnapshot is false (version '$actual')")
  }
)
