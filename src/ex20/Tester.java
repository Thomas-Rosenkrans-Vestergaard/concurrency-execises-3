package ex20;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Tester
{
    public static void main(String[] args) throws Exception
    {
        ExecutorService      executorService = Executors.newCachedThreadPool();
        List<Future<String>> futures         = new ArrayList<>();

        String[] hostList = {"http://crunchify.com", "http://yahoo.com",
                             "http://www.ebay.com", "http://google.com",
                             "http://www.example.co", "https://paypal.com",
                             "http://bing.com/", "http://techcrunch.com/",
                             "http://mashable.com/", "http://thenextweb.com/",
                             "http://wordpress.com/", "http://cphbusiness.dk/",
                             "http://example.com/", "http://sjsu.edu/",
                             "http://ebay.co.uk/", "http://google.co.uk/",
                             "http://www.wikipedia.org/",
                             "http://dr.dk", "http://pol.dk", "https://www.google.dk",
                             "http://phoronix.com", "http://www.webupd8.org/",
                             "https://studypoint-plaul.rhcloud.com/", "http://stackoverflow.com",
                             "http://docs.oracle.com", "https://fronter.com",
                             "http://imgur.com/", "http://www.imagemagick.org"
        };

        for (String url : hostList)
            futures.add(executorService.submit(new ConcurrentPinger(url)));

        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        executorService.shutdown();
    }
}
