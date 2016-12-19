package artbit.com.artbit.util;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by JoenSeonHee on 2016-12-19.
 */

public class SqlConnector {

    private final String TAG = "SqlConnector";

    private static volatile SqlConnector connector;

    private SqlConnector() {
    }

    public static synchronized SqlConnector getInstance() {
        if (connector == null)
            connector = new SqlConnector();
        return connector;
    }

    public String post(String url, String data) {
        HttpURLConnection connection = connect(url);

        if (connection == null) return null;

        if (!data.contains("data=")) data = "data=" + data;

        try {
            PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(connection.getOutputStream(), "UTF-8"));
            printWriter.write(data);
            printWriter.flush();
            printWriter.close();
        } catch (IOException e) {

            Log.e(TAG, "POST ERROR");
            e.printStackTrace();
        }

        return write(connection);
    }

    public String get(String url) {
        return write(connect(url));
    }

    private HttpURLConnection connect(String url) {
        try {
            URL url1 = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) url1.openConnection();

            connection.setDefaultUseCaches(false);
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
            connection.setRequestMethod("POST");

            return connection;
        } catch (IOException e) {
            Log.e(TAG, "Connection Error");
            e.printStackTrace();
            return null;
        }
    }

    private String write(HttpURLConnection connection) {
        String result = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
            StringBuilder builder = new StringBuilder();
            while ((bufferedReader.readLine()) != null) builder.append(bufferedReader.readLine());
            result = builder.toString();
        } catch (IOException e) {
            Log.e(TAG, "Write Error");
            e.printStackTrace();
        }

        return result;
    }
}
