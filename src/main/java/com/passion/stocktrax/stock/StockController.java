package com.passion.stocktrax.stock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Controller
@RequestMapping(path="/stocks") // This means URL's start with /accounts (after Application path)
public class StockController {

    private final String key = "cqGbhMruAI4HyqXtdprX6L7CRijjP5TobqZINbIK";

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody String getStock(@RequestParam String ticker, @RequestParam String date) throws IOException {
        URL url = new URL("https://api.stockdata.org/v1/data/eod?symbols=" + ticker + "&date_from=" + date + "&api_token=" + key);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        return content.toString();
    }
}
