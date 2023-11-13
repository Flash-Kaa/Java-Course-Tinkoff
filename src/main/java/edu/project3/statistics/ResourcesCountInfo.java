package edu.project3.statistics;

import edu.project3.Pair;
import edu.project3.Request;
import edu.project3.terminal.TerminalRequest;
import java.net.URI;
import java.util.HashMap;
import java.util.List;

public class ResourcesCountInfo extends Statistics{
    @Override
    public void setAndCalculateData(TerminalRequest terminalRequest, List<Request> list) {
        var map = new HashMap<URI, Integer>();
        for (var i : list) {
            map.put(i.uri(), map.getOrDefault(i.uri(), 0) + 1);
        }

        table.add(new Pair("Ресурс", "Количество"));
        for(var i : map.keySet()) {
            table.add(new Pair(i.toString(), map.get(i).toString()));
        }
    }

    @Override
    public String getTitle() {
        return "Запрашиваемые ресурсы";
    }
}
