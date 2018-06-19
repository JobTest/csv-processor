package com.ajax_systems.akka.module;

import com.ajax_systems.akka.web.route.CsvRoute;
import com.google.inject.AbstractModule;


public class WebModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CsvRoute.class);
    }
}
