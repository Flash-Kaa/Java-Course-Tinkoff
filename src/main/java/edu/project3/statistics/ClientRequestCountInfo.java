package edu.project3.statistics;

import edu.project3.Pair;
import edu.project3.Request;
import edu.project3.terminal.TerminalRequest;
import java.util.HashMap;
import java.util.List;

public class ClientRequestCountInfo extends Statistics{
    @Override
    public void setAndCalculateData(TerminalRequest terminalRequest, List<Request> list) {
        var map = new HashMap<String, Integer>();
        for (var i : list) {
            map.put(i.ip(), map.getOrDefault(i.ip(), 0) + 1);
        }

        table.add(new Pair("Ip", "Количество запросов"));
        for(var i : map.keySet()) {
            table.add(new Pair(i, map.get(i).toString()));
        }
    }

    @Override
    public String getTitle() {
        return "Запросы с IP-адреса";
    }
}
