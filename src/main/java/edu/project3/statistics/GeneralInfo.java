package edu.project3.statistics;

import edu.project3.Pair;
import edu.project3.Request;
import edu.project3.terminal.TerminalRequest;
import java.util.List;

public class GeneralInfo extends Statistics {
    @Override
    public void setAndCalculateData(TerminalRequest terminalRequest, List<Request> list) {
        table.add(new Pair("Метрика", "Значение"));
        table.add(new Pair("Файл", terminalRequest.uri().getPath()));
        var from = terminalRequest.filterFrom();
        var to = terminalRequest.filterTo();

        table.add(new Pair("Начальная дата", from != null ? String.valueOf(from) : "-"));
        table.add(new Pair("Конечная дата", to != null ? String.valueOf(to) : "-"));
        table.add(new Pair("Количество запросов", String.valueOf(list.size())));
        table.add(
            new Pair("Средний размер ответа",
                list.stream()
                    .map(Request::bytesSent)
                    .reduce(0L, Long::sum, Long::sum ) / list.size() + "b"
            )
        );
    }

    @Override
    public String getTitle() {
        return "Общая информация";
    }
}
