package com.ajax_systems.akka.web.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public class Cli {

    private static final Logger log = Logger.getLogger(Cli.class.getName());

    private String[] args;

    private Options options = new Options();

    private String run;

    private String booksByWriter;

    private String sort;

    public Cli(String... args) {
        this.args = args;

        options.addOption("h", "help", false, "show help.");
        options.addOption("r", "run", true, "Here you can set parameter: 'console' or 'web'.");
        options.addOption("b", "books-by-writer", true, "Here you can set parameter: 'one' or 'two' or 'three' or 'four'.");
        options.addOption("s", "sort", true, "Here you can set parameter: 'number' or 'price'.");
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getBooksByWriter() {
        return booksByWriter;
    }

    public void setBooksByWriter(String booksByWriter) {
        this.booksByWriter = booksByWriter;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public void actions() {
        CommandLineParser parser = new BasicParser();

        try {
            CommandLine cmd = parser.parse(options, args);

            if (cmd.hasOption("h")){
                help();
            }

            if (cmd.hasOption("r") || cmd.hasOption("b") || cmd.hasOption("s")) {
                log.log(Level.INFO, "Using argument -r=" + cmd.getOptionValue("r"));
                run = cmd.getOptionValue("r");
                log.log(Level.INFO, "Using argument -b=" + cmd.getOptionValue("b"));
                booksByWriter = cmd.getOptionValue("b");
                log.log(Level.INFO, "Using argument -s=" + cmd.getOptionValue("s"));
                sort = cmd.getOptionValue("s");
            } else {
                log.log(Level.SEVERE, "Missing a option");
                help();
            }
        } catch (ParseException ex) {
            log.log(Level.SEVERE, "Failed to parse command line properties", ex);
            help();
        }
    }

    private void help() {
        HelpFormatter formatter = new HelpFormatter();
        formatter.printHelp("Main", options);
        System.exit(0);
    }
}
