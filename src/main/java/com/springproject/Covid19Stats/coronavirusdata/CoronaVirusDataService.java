package com.springproject.Covid19Stats.coronavirusdata;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

@Service
@EnableScheduling
public class CoronaVirusDataService {
    public List<CoronaVirusDataModel> getAllStates() {
        return allStates;
    }

    public List<CoronaVirusDataModel> getAllStates2() {
        return allStates2;
    }

    private List<CoronaVirusDataModel> allStates = new ArrayList<>();
    private List<CoronaVirusDataModel> allStates2 = new ArrayList<>();


    private static final String STATE_DATA_URl = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";
    private static final String DAILY_DATA_URL = "https://raw.githubusercontent.com/datasets/covid-19/main/data/worldwide-aggregate.csv";

    @PostConstruct
    @Scheduled(cron="* * * * * * ")
    public void fetchVirusData() throws IOException, InterruptedException {
        List<CoronaVirusDataModel> stats = new ArrayList<>();
        List<CoronaVirusDataModel> stats2 = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        
        HttpRequest request1 = HttpRequest.newBuilder()
                .uri(URI.create(STATE_DATA_URl))
                .build();
        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(URI.create(DAILY_DATA_URL))
                .build();
        HttpResponse<String> httpResponse1 = client.send(request1, HttpResponse.BodyHandlers.ofString());
        HttpResponse<String> httpResponse2 = client.send(request2, HttpResponse.BodyHandlers.ofString());

        StringReader csvBody1 = new StringReader(httpResponse1.body());
        StringReader csvBody2 = new StringReader(httpResponse2.body());

        Iterable<CSVRecord> records1 = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBody1);
        Iterable<CSVRecord> records2 = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBody2);
        for(CSVRecord record : records1){
            CoronaVirusDataModel temp = new CoronaVirusDataModel();
            temp.setState(record.get("Province/State"));
            temp.setCountry(record.get("Country/Region"));
            temp.setToday(record.get(record.size() - 1));
            stats.add(temp);
        }
        for(CSVRecord record : records2){
            CoronaVirusDataModel temp = new CoronaVirusDataModel();
            temp.setDate(record.get("Date"));
            temp.setDeaths(record.get("Deaths"));
            temp.setConfirmed(record.get("Confirmed"));
            temp.setRecovered(record.get("Recovered"));
            temp.setIncreaseRate(record.get("Increase rate"));
            stats2.add(temp);
        }
        this.allStates = stats;
        this.allStates2 = stats2;

    }
}

