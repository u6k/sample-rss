
package jp.gr.java_conf.u6k.sample_rss;

import java.net.URL;

import com.sun.syndication.feed.synd.SyndContent;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

public class Main {

    public static void main(String[] args) throws Exception {
        // String url = "http://news.atode.cc/rss.php";
        // String url = "http://blog.livedoor.jp/coleblog/atom.xml";
        // String url = "http://fullrss.net/a/http/blog.livedoor.jp/coleblog/atom.xml";
        String url = "http://www.ideaxidea.com/feed/atom";
        // String url = "http://fullrss.net/a/http/news.atode.cc/rss.php";
        // String url = "http://rss.weather.yahoo.co.jp/rss/days/4310.xml";

        SyndFeedInput in = new SyndFeedInput();
        SyndFeed feed = in.build(new XmlReader(new URL(url)));

        System.out.println("Title: " + feed.getTitle());
        System.out.println("Link: " + feed.getLink());

        for (Object en : feed.getEntries()) {
            SyndEntry entry = (SyndEntry) en;
            System.out.println("Item:");
            System.out.println("  Title: " + entry.getTitle());
            System.out.println("  Link: " + entry.getLink());
            // System.out.println("  Text: " + entry.getDescription().getValue());

            for (Object co : entry.getContents()) {
                SyndContent content = (SyndContent) co;
                System.out.println("  Content: " + content.getValue());
            }
        }
    }

}
