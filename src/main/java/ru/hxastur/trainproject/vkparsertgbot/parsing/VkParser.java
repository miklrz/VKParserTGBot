package ru.hxastur.trainproject.vkparsertgbot.parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class VkParser {
    public void parse(String postUrl){
        System.out.println(getVkPost(postUrl));
    }
    public Document getVkPost(String postUrl){
        Document doc = null;
        try {
            doc = Jsoup.connect(postUrl)
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("http://www.google.com")
                    .get();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return doc;
    }
}
