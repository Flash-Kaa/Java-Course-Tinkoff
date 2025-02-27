package edu.project3.statistics;

import edu.project3.Pair;
import edu.project3.Request;
import edu.project3.terminal.TerminalRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RequestMethodCountInfo extends Statistics {
    @Override
    public void setAndCalculateData(TerminalRequest terminalRequest, List<Request> list) {
        Map<Request.MethodRequest, Integer> map = new HashMap<>();
        for (Request i : list) {
            map.put(i.methodRequest(), map.getOrDefault(i.methodRequest(), 0) + 1);
        }

        table.add(new Pair("Метод", "Количество"));
        for (Map.Entry<Request.MethodRequest, Integer> i : map.entrySet()) {
            table.add(new Pair(i.getKey().toString(), i.getValue().toString()));
        }
    }

    @Override
    public String getTitle() {
        return "Метод запроса";
    }
}
