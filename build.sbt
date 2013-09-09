organization := "me.lessis"

name := "bintry"

version := "0.2.0"

description := "your packages, delivered fresh"

// We need the latest scala version on a BC series
crossScalaVersions := Seq("2.9.2", "2.9.3", "2.10.2")

libraryDependencies <+= scalaBinaryVersion {
  case x if x startsWith "2.9" => "net.databinder.dispatch" % "dispatch-json4s-native_2.9.3" % "0.11.0"
  case _ => "net.databinder.dispatch" %% "dispatch-json4s-native" % "0.11.0"
}

libraryDependencies <++= scalaVersion {
  case "2.9.2" => Seq("net.virtual-void" %% "futures-backport" % "1")
  case _ => Nil
}

publishTo := Some(Opts.resolver.sonatypeStaging)

publishMavenStyle := true

publishArtifact in Test := false

licenses <<= (version)(v =>
      Seq("MIT" ->
          url("https://github.com/softprops/bintry/blob/%s/LICENSE" format v)))

homepage := some(url("https://github.com/softprops/bintry/#readme"))

pomExtra := (
  <scm>
    <url>git@github.com:softprops/bintry.git</url>
    <connection>scm:git:git@github.com:softprops/bintry.git</connection>
  </scm>
  <developers>
    <developer>
      <id>softprops</id>
      <name>Doug Tangren</name>
      <url>https://github.com/softprops</url>
    </developer>
  </developers>)


seq(lsSettings:_*)

(LsKeys.tags in LsKeys.lsync) := Seq("bintray", "dispatch", "http")
