package edu.project3;

import edu.project3.terminal.Terminal;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class LoggerParser {
    private final static DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss");
    private final static Pattern MONTH_PATTERN = Pattern.compile("[A-Z][a-z]+");
    private static final Pattern IP_PATTERN = Pattern.compile("(\\d+\\.){3}\\d");
    private static final Pattern IPV6_PATTERN = Pattern.compile("((^|:)([0-9a-fA-F]{0,4})){1,8}");
    private static final Pattern USER_PATTERN = Pattern.compile("\\s-\\s[^\\[]+\\[");
    private static final Pattern DATETIME_PATTERN = Pattern.compile("\\d{2}/[A-z]{3,}/\\d{4}(:\\d{2}){3}");
    private static final Pattern GROUP_DATA_PATTERN = Pattern.compile("\"[^\"]+\"");
    private static final Pattern STATUS_WITH_BYTES_PATTERN = Pattern.compile("\"\\s\\d{3}\\s\\d+\\s\"");

    private LoggerParser() {
    }

    public static List<Request> parse(String input) {
        var lines = input.split("\n");

        List<Request> res = new ArrayList<>(lines.length);

        for (String line : lines) {
            var ipMatcher = IP_PATTERN.matcher(line);
            var ipv6Matcher = IPV6_PATTERN.matcher(line);
            var userMatcher = USER_PATTERN.matcher(line);
            var dateTimeMatcher = DATETIME_PATTERN.matcher(line);
            var groupDataMatcher = GROUP_DATA_PATTERN.matcher(line);
            var statusWithBytesMatcher = STATUS_WITH_BYTES_PATTERN.matcher(line);

            var justIp = ipMatcher.find();

            if (!(justIp || ipv6Matcher.find())
                || !userMatcher.find()
                || !dateTimeMatcher.find()
                || !statusWithBytesMatcher.find()
                || !groupDataMatcher.find()
            ) {
                Terminal.getLogger().error(String.format("Can't parse log: %s", line));
                return List.of();
            }

            var ip = justIp ? ipMatcher.group() : ipv6Matcher.group();

            var userGroup = userMatcher.group();
            var user = userGroup.substring(3, userGroup.length() - 2);

            var timeGroup = dateTimeMatcher.group();
            LocalDateTime time;
            try {
                time = LocalDateTime.parse(timeGroup, DATE_TIME_FORMATTER);
            } catch (DateTimeParseException e) {
                Terminal.getLogger().error(String.format("Illegal datetime: %s", timeGroup));
                return List.of();
            }

            var q = groupDataMatcher.group()
                .substring(1, groupDataMatcher.group().length() - 1)
                .split(" ");

            Request.MethodRequest methodRequest;
            try {
                methodRequest = Enum.valueOf(Request.MethodRequest.class, q[0]);
            } catch (IllegalArgumentException e) {
                Terminal.getLogger().error(String.format("Illegal method: %s", q[0]));
                return List.of();
            }

            URI uri;
            try {
                uri = new URI(q[1]);
            } catch (URISyntaxException e) {
                Terminal.getLogger().error(e.getMessage());
                return List.of();
            }
            var protocol = q[2];

            var y = statusWithBytesMatcher.group()
                .substring(2, statusWithBytesMatcher.group().length() - 2)
                .split(" ");

            var status = Integer.parseInt(y[0]);
            var bytes = Long.parseLong(y[1]);

            if(!groupDataMatcher.find()) {
                Terminal.getLogger().error(String.format("Can't parse log: %s", line));
                return List.of();
            }

            var httpReferer = groupDataMatcher.group()
                .substring(1, groupDataMatcher.group().length() - 1);

            if(!groupDataMatcher.find()) {
                Terminal.getLogger().error(String.format("Can't parse log: %s", line));
                return List.of();
            }


            var userAgentGroup = groupDataMatcher.group();
            var userAgent = userAgentGroup.substring(1, userAgentGroup.length() - 1);

            res.add(
                new Request(
                    ip, user, time, methodRequest, uri, protocol, status, bytes, httpReferer, userAgent
                )
            );
        }

        return res;
    }
}
