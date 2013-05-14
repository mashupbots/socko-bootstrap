//
// Socko Bootstrap HelloApp build file
//

import sbt._
import Keys._
import com.typesafe.sbteclipse.plugin.EclipsePlugin._
import sbt.Project.Initialize
import sbtassembly.Plugin._
import AssemblyKeys._

//
// Build setup
//
object SockoBuild extends Build {

  //
  // Settings
  //
  lazy val defaultSettings = Defaults.defaultSettings ++ Seq(
    // Info
    organization := "org.mashupbots.socko-bootstrap",
    version      := "0.1.0",
    scalaVersion := "2.10.1",
    organizationHomepage := Some(url("http://www.sockoweb.org")),

    // Repositories
    resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
        
    // sbtEclipse - see examples https://github.com/typesafehub/sbteclipse/blob/master/sbteclipse-plugin/src/sbt-test/sbteclipse/02-contents/project/Build.scala
    EclipseKeys.createSrc := EclipseCreateSrc.ValueSet(EclipseCreateSrc.Unmanaged, EclipseCreateSrc.Source, EclipseCreateSrc.Resource),
    EclipseKeys.withSource := true    
  )
  
  // Compile settings
  lazy val compileJdk6Settings = Seq(
    scalacOptions ++= Seq("-encoding", "UTF-8", "-deprecation", "-unchecked", "-optimize", "-feature", "-target:jvm-1.6"),
    javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation", "-source", "1.6", "-target", "1.6")
  )
  lazy val compileJdk7Settings = Seq(
    scalacOptions ++= Seq("-encoding", "UTF-8", "-deprecation", "-unchecked", "-optimize", "-feature", "-target:jvm-1.7"),
    javacOptions ++= Seq("-Xlint:unchecked", "-Xlint:deprecation", "-source", "1.7", "-target", "1.7")
  )
       
  //
  // Projects
  //
  lazy val hello = Project(id = "hello",
                         base = file("."),
                         settings = defaultSettings ++ compileJdk7Settings ++ Seq(
                           libraryDependencies ++= Seq(Dependency.socko)
                         ))
                         
}

object Dependency {
  val socko         = "org.mashupbots.socko" %% "socko-webserver" % "0.3.0"
}




