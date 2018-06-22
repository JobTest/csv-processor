package com.ajax_systems.akka.module;

import com.ajax_systems.akka.console.CsvConsole;
import com.google.inject.AbstractModule;


public class ConsoleModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CsvConsole.class);
    }
}
