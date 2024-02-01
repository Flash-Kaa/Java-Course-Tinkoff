package edu.project3.statistics;

import edu.project3.Pair;
import edu.project3.Request;
import edu.project3.terminal.TerminalRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PopularHourInfo extends Statistics {
    @Override
    public void setAndCalculateData(TerminalRequest terminalRequest, List<Request> list) {
        Map<Integer, Integer> map = new HashMap<>();
        for (Request i : list) {
            int hour = i.dateTime().getHour();
            map.put(hour, map.getOrDefault(hour, 0) + 1);
        }

        table.add(new Pair("Час", "Количество запросов"));
        for (Map.Entry<Integer, Integer> i : map.entrySet()) {
            table.add(new Pair(i.getKey().toString(), i.getValue().toString()));
        }
    }

    @Override
    public String getTitle() {
        return "Запросы по часам";
    }
}
