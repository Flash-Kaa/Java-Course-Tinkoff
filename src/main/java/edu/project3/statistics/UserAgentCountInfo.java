package edu.project3.statistics;

import edu.project3.Pair;
import edu.project3.Request;
import edu.project3.terminal.TerminalRequest;
import java.util.HashMap;
import java.util.List;

public class UserAgentCountInfo extends Statistics{
    @Override
    public void setAndCalculateData(TerminalRequest terminalRequest, List<Request> list) {
        var map = new HashMap<String, Integer>();
        for (var i : list) {
            map.put(i.userAgent(), map.getOrDefault(i.userAgent(), 0) + 1);
        }

        table.add(new Pair("Место", "Количество"));
        for(var i : map.keySet()) {
            table.add(new Pair(i, map.get(i).toString()));
        }
    }

    @Override
    public String getTitle() {
        return "Откуда совершен запрос";
    }
}
