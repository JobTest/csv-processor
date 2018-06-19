package com.ajax_systems.akka;

import com.ajax_systems.akka.console.CsvConsole;
import com.ajax_systems.akka.module.ConsoleModule;
import com.ajax_systems.akka.module.WebModule;
import com.ajax_systems.akka.web.util.Cli;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.ajax_systems.akka.web.route.CsvRoute;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import java.util.concurrent.ExecutionException;


public class CsvProcessor {

    private static final Config config = ConfigFactory.load();

    public static void main(String... args) throws InterruptedException, ExecutionException {

        Cli cli = new Cli(args);
        cli.actions();

        switch (cli.getRun()) {
            case "console" : {
                System.out.println("You starting as CONSOLE application");
                Injector injector = Guice.createInjector(new ConsoleModule());
                injector.getInstance(CsvConsole.class)
                        .startConsole(cli.getBooksByWriter(), cli.getSort());
                System.exit(0);
                break;
            }
            case "web" : {
                System.out.println("You starting as WEB application");
                Injector injector = Guice.createInjector(new WebModule());
                injector.getInstance(CsvRoute.class)
                        .startServer(config.getString("csvRoute.host"), config.getInt("csvRoute.port"));
                break;
            }
            default:
                System.out.println("Here you can set parameter 'console' or 'web'?");
                break;
        }
    }
}
