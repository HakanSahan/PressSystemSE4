package be.springPressOrder.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class WeatherController {

    @RequestMapping("/weather")
    String getWeather() {

        try {
            String httpsURL = "https://fcc-weather-api.glitch.me/api/current?lat=35&lon=139";
            URL myUrl = null;
            myUrl = new URL(httpsURL);
            HttpsURLConnection conn = (HttpsURLConnection)myUrl.openConnection();
            InputStream is = conn.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);

            String inputLine;

            while ((inputLine = br.readLine()) != null) {
                System.out.println(inputLine);
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
       /* try {
        //URL url = new URL("https://fcc-weather-api.glitch.me/api/current?lat=35&lon=139");
        URL url = new URL("https://fcc-weather-api.glitch.me/api/current");
        HttpURLConnection con = null;
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");
            Map<String, String> parameters = new HashMap<>();
            parameters.put("lat", "35");
            parameters.put("lon", "139");

            con.setDoOutput(true);
            DataOutputStream out = new DataOutputStream(con.getOutputStream());
            out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
            out.flush();
            out.close();

            con.setConnectTimeout(5000);
            con.setReadTimeout(5000);
            int status = con.getResponseCode();

            Reader streamReader = null;

            if (status > 299) {
                streamReader = new InputStreamReader(con.getErrorStream());
            } else {
                streamReader = new InputStreamReader(con.getInputStream());
            }
            return FullResponseBuilder.getFullResponse(con);
        } catch (IOException e) {
            e.printStackTrace();
        }*/
        return "weather";
    }
}
