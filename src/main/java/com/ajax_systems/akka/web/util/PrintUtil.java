package com.ajax_systems.akka.web.util;

import com.ajax_systems.akka.service.dto.BookDTO;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PrintUtil {

    static final Config config = ConfigFactory.load();

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    private static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    private static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private static final String ANSI_GRAY_BACKGROUND = "\u001B[47m";
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    private static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    private static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    private static final String SORT_DEFAULT = "id";

    private static final String[] headData = new String[]{ "ID", "NUMBER", "PRICE", "TITLE", "ABOUT", "AUTHOR" };

    private static final String formatSeparator = "+-------------+-------------+----------------------+---------------+----------------+---------------+";

    private static final String formatHeadData =
            '\n' +
                "|" + ANSI_PURPLE + " %1$-11s " + ANSI_RESET +
                "|" + ANSI_PURPLE + " %2$-11s " + ANSI_RESET +
                "|" + ANSI_PURPLE + " %3$-20s " + ANSI_RESET +
                "|" + ANSI_PURPLE + " %4$-13s " + ANSI_RESET +
                "|" + ANSI_PURPLE + " %5$-14s " + ANSI_RESET +
                "|" + ANSI_PURPLE + " %6$-13s " + ANSI_RESET +
                "|\n";

    private static final String getFormatOutData(String sort) {
        if (sort==null)
            sort = SORT_DEFAULT;

        return "|" + (sort.equals("id") ? ANSI_BLACK_BACKGROUND : "") + ANSI_YELLOW + " %1$-11s " + ANSI_RESET +
                "|" + (sort.equals("number") ? ANSI_BLACK_BACKGROUND : "") + ANSI_YELLOW + " %2$-11s " + ANSI_RESET +
                "|" + (sort.equals("price") ? ANSI_BLACK_BACKGROUND : "") + ANSI_YELLOW + " %3$-20s " + ANSI_RESET +
                "|" + (sort.equals("title") ? ANSI_BLACK_BACKGROUND : "") + ANSI_YELLOW + " %4$-10s " + ANSI_RESET +
                "|" + (sort.equals("about") ? ANSI_BLACK_BACKGROUND : "") + ANSI_YELLOW + " %5$-10s " + ANSI_RESET +
                "|" + (sort.equals("author") ? ANSI_BLACK_BACKGROUND : "") + ANSI_YELLOW + " %6$-10s " + ANSI_RESET +
                "|\n";
    }

    static final Pattern WRITER_PATTERN = Pattern.compile(".*(" + config.getString("csv-processor.writer-pattern") + ").*");

    public static void print(List<BookDTO> books, String sort) throws UnsupportedEncodingException {
        System.out.format(formatHeadData, headData);
        System.out.println(formatSeparator);

        for (BookDTO book: books) {
            String id = String.valueOf(book.getId());
            String number = String.valueOf(book.getNumber());
            String price = String.valueOf(book.getPrice());
            String about = new String(book.getAbout().getBytes("UTF-8"), 0, book.getAbout().length(), "GB18030");
            String author = new String(book.getAuthor().getBytes("UTF-8"), 0, book.getAuthor().length(), "GB18030");
            String title = new String(book.getTitle().getBytes("UTF-8"), 0, book.getTitle().length(), "GB18030");
            String[] outData = new String[]{id, number, price, title, about, author};

            System.out.format(getFormatOutData(sort), outData);
        }

        System.out.println(formatSeparator);
    }

    public static String matchWriter(String writer) {
        Matcher matcher = WRITER_PATTERN.matcher(writer);
        if (matcher.find())
            return matcher.group(1);
        return "UNKNOWN";
    }
}
