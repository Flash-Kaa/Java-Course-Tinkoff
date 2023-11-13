package edu.project3.statistics;

import edu.project3.Pair;
import edu.project3.Request;
import edu.project3.terminal.TerminalRequest;
import java.util.HashMap;
import java.util.List;

public class PopularHourInfo extends Statistics{
    @Override
    public void setAndCalculateData(TerminalRequest terminalRequest, List<Request> list) {
        var map = new HashMap<Integer, Integer>();
        for (var i : list) {
            var hour = i.dateTime().getHour();
            map.put(hour, map.getOrDefault(hour, 0) + 1);
        }

        table.add(new Pair("Час", "Количество запросов"));
        for(var i : map.keySet()) {
            table.add(new Pair(i.toString(), map.get(i).toString()));
        }
    }

    @Override
    public String getTitle() {
        return "Запросы по часам";
    }
}
