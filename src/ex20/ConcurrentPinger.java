package ex20;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Callable;

public class ConcurrentPinger implements Callable<String>
{

    private final String url;

    public ConcurrentPinger(String url)
    {
        this.url = url;
    }

    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override public String call() throws Exception
    {
        String result = "Error";
        try {
            URL siteURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) siteURL
                    .openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int code = connection.getResponseCode();
            if (code == 200)
                result = "Green";
            if(code==301)
                result="Redirect";
        } catch (Exception e) {
            result = "->Red<-";
        }
        return result;
    }
}
