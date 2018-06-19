package com.ajax_systems.akka.web.util;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class CsvUtil {

    public static final Config config = ConfigFactory.load();

    public static final String CSV_EXT = "csv";

    public static final String JSON_EXT = "json";

    static final Pattern WRITER_PATTERN = Pattern.compile(".*(" + config.getString("csv-processor.writer-pattern") + "),.*");

    public static String matchWriter(String writer) {
        Matcher matcher = WRITER_PATTERN.matcher(writer);
        if (matcher.find())
            return matcher.group(1);
        return "UNKNOWN";
    }
}
