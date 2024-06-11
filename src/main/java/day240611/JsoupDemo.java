package day240611;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class JsoupDemo {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.connect("https://www.baidu.com").get();
        System.out.println(document.title());
    }
}
