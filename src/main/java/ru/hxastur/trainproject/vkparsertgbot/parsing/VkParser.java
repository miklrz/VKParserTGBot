package ru.hxastur.trainproject.vkparsertgbot.parsing;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class VkParser {
    public void parse(String postUrl){
        Document vkPost = getVkPost(postUrl);
        Elements el = vkPost.select("div#page_wall_posts");
        Elements el1 = el.select("._post post page_block all own post--withPostBottomAction  post--with-likes deep_active Post--redesign");
        System.out.println(el1);
    }

    public Document getVkPost(String postUrl){
        Document doc = null;
        try {
            doc = Jsoup.connect(postUrl)
                    .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36")
                    .referrer("http://www.google.com")
                    .get();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return doc;
    }
}
