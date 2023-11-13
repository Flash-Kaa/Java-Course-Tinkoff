package edu.project3.statistics;

import edu.project3.Pair;
import edu.project3.Request;
import edu.project3.terminal.TerminalRequest;
import java.util.HashMap;
import java.util.List;

public class ClientMemoryInfo extends Statistics{
    @Override
    public void setAndCalculateData(TerminalRequest terminalRequest, List<Request> list) {
        var map = new HashMap<String, Long>();
        for (var i : list) {
            map.put(i.ip(), map.getOrDefault(i.ip(), 0L) + i.bytesSent());
        }

        table.add(new Pair("Ip", "Отправленно ресурсов"));
        for(var i : map.keySet()) {
            table.add(new Pair(i, map.get(i).toString()));
        }
    }

    @Override
    public String getTitle() {
        return "Размер отправленных ресурсов каждому пользователю";
    }
}
