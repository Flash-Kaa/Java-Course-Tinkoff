package edu.project3.statistics;

import edu.project3.Pair;
import edu.project3.Request;
import edu.project3.terminal.TerminalRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserAgentCountInfo extends Statistics {
    @Override
    public void setAndCalculateData(TerminalRequest terminalRequest, List<Request> list) {
        Map<String, Integer> map = new HashMap<>();
        for (Request i : list) {
            map.put(i.userAgent(), map.getOrDefault(i.userAgent(), 0) + 1);
        }

        table.add(new Pair("Место", "Количество"));
        for (Map.Entry<String, Integer> i : map.entrySet()) {
            table.add(new Pair(i.getKey(), i.getValue().toString()));
        }
    }

    @Override
    public String getTitle() {
        return "Откуда совершен запрос";
    }
}
