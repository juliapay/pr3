package at.campus02.pr3.NETZWERK.InputOutputURL;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        HttpURLConnection conn = null;
        InputStream is = null;

        String string = null;
        try {
            URL url = new URL("http://google.com");

            // (set connection and read timeouts on the connection)
            conn = (HttpURLConnection) url.openConnection();
            is = new BufferedInputStream(conn.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));


            System.out.println(url);

            while ((string = bufferedReader.readLine()) != null) {
                System.out.println(string);
            }

        } catch (Exception ex) {
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                }
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
    }
}
