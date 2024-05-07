package ru.hxastur.trainproject.vkparsertgbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.hxastur.trainproject.vkparsertgbot.parsing.VkParser;
import java.util.Scanner;

@SpringBootApplication
public class VkParserTgBotApplication {

    public static void main(String[] args) {
        VkParser parser = new VkParser();
        parser.parse("https://vk.com/dom.s.istoriey");
    }


}
