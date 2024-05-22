package at.campus02.pr3.NETZWERK.ToAnalyse;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class SubmitPostRequest {

    public static void main(String[] args) {

        String url = "https://wikipedia.org/";
        String email = "yourname@gmail.com";
        String password = "yourpass";

        try {
            URL urlObj = new URL(url);

            HttpURLConnection httpCon = (HttpURLConnection) urlObj.openConnection();

            httpCon.setDoOutput(true);
            httpCon.setRequestMethod("POST");

            String parameters = "username=" + email;
            parameters += "password=" + password;

            OutputStreamWriter writer = new OutputStreamWriter(
                    httpCon.getOutputStream());
            writer.write(parameters);
            writer.flush();

            System.out.println("Response Code: " +httpCon.getResponseCode());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
