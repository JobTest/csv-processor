package com.ajax_systems.akka

import com.ajax_systems.akka.module.{ConsoleModule, WebModule}
import com.ajax_systems.akka.web.route.CsvRoute
import com.google.inject.{Guice}
import com.typesafe.config.{Config, ConfigFactory}
import com.ajax_systems.akka.web.util.Cli
import com.ajax_systems.akka.console.CsvConsole


object CsvProcessor extends App {

  val config: Config = ConfigFactory.load

  val cli: Cli = new Cli(args)
  cli.actions

  cli.getRun match {
    case "console" => {
      println("You starting as CONSOLE application")
      val injector = Guice.createInjector(new ConsoleModule)
      val component = injector.getInstance(classOf[CsvConsole])
        .startConsole(cli.getBooksByWriter(), cli.getSort())
      System.exit(0)
    }
    case "web" => {
      println("You starting as WEB application")
      val injector = Guice.createInjector(new WebModule)
      val component = injector.getInstance(classOf[CsvRoute])
        .startServer(config.getString("server.host"), config.getInt("server.port"))
    }
    case _ => println("Here you can set parameter 'console' or 'web'?")
  }
}
