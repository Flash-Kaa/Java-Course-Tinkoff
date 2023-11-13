package edu.project3;

import edu.project3.statistics.ClientMemoryInfo;
import edu.project3.statistics.ClientRequestCountInfo;
import edu.project3.statistics.GeneralInfo;
import edu.project3.statistics.PopularHourInfo;
import edu.project3.statistics.RequestMethodCountInfo;
import edu.project3.statistics.ResourcesCountInfo;
import edu.project3.statistics.Statistics;
import edu.project3.statistics.StatusCodesCountInfo;
import edu.project3.statistics.UserAgentCountInfo;
import edu.project3.terminal.Terminal;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        var t1 = Terminal.expectRequest();
        /*var read = new ReaderHTTP().read(t1.uri());
        var list = LoggerParser.parse(read);
        var filter = new Filter(list);
        var filteredList = filter.betweenDates(t1.filterFrom(), t1.filterTo()).toList();

        //java -jar nginx-log-stats.jar --path https://raw.githubusercontent.com/elastic/examples/master/Common%20Data%20Formats/nginx_logs/nginx_logs --from 2015-06-01 --format adoc

        var sb = new StringBuilder();*/

        var l = new ArrayList<Statistics>(){{
            add(new GeneralInfo());
            add(new ResourcesCountInfo());
            add(new StatusCodesCountInfo());
            add(new ClientMemoryInfo());
            add(new RequestMethodCountInfo());
            add(new ClientRequestCountInfo());
            add(new UserAgentCountInfo());
            add(new PopularHourInfo());
        }};

        var a = new LoggerAnalyzer(t1, l);
        Terminal.getLogger().info(a.getAnalysis());

        /*for(var i : l) {
            i.setAndCalculateData(t1, filteredList);
        }

        for(var i : l) {
            sb.append("\n\n")
                .append(i.getTitle())
                .append(i.getTable());
        }
        Terminal.getLogger().info(sb.toString());*/
    }
}
