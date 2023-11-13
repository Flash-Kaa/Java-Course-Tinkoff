package edu.project3;

import edu.project3.terminal.TerminalRequest;
import edu.project3.readers.FileReader;
import edu.project3.readers.ReaderHTTP;
import edu.project3.statistics.Statistics;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.regex.Pattern;

public class LoggerAnalyzer {
    private final Thread THREAD;
    private final FutureTask<String> TASK;


    public LoggerAnalyzer(TerminalRequest request, List<Statistics> statisticsTypes) {
        String logs;

        var matcher = Pattern.compile("^http").matcher(request.uri().toString());
        if(matcher.find()) {
            logs = new ReaderHTTP().read(request.uri());
        } else {
            logs = new FileReader().read(request.uri());
        }

        TASK = new FutureTask<>(
            () -> {
                var parsed = LoggerParser.parse(logs);
                var filter = new Filter(parsed);
                var filtered = filter.betweenDates(request.filterFrom(), request.filterTo()).toList();

                var sb = new StringBuilder();
                for(var i : statisticsTypes) {
                    i.setAndCalculateData(request, filtered);
                }

                var titleType = request.resultFormat() == TerminalRequest.ResultFormat.ADOC ? "====" : "####";

                for(var i : statisticsTypes) {
                    sb.append("\n\n")
                        .append(titleType)
                        .append(" ")
                        .append(i.getTitle())
                        .append(i.getTable());
                }

                return sb.toString();
            }
        );

        THREAD = new Thread(TASK);
        THREAD.start();
    }

    public String getAnalysis() {
        try {
            return TASK.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
