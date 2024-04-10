import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class CurrencyConverter {
    public static Currency Convert(String from, String to, double value) throws IOException {
        URL url = new URL("https://v6.exchangerate-api.com/v6/97e0634de16fbcf555efd18a/pair/" + from + "/" + to + "/" + value);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.connect();

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();

        Gson gson = new Gson();

        return gson.fromJson(content.toString(), Currency.class);

    }
}
