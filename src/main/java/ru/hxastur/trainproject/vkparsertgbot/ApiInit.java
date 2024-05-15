package ru.hxastur.trainproject.vkparsertgbot;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.client.actors.ServiceActor;
import com.vk.api.sdk.client.actors.UserActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.GroupAuthResponse;
import com.vk.api.sdk.objects.UserAuthResponse;
import com.vk.api.sdk.objects.wall.GetFilter;
import com.vk.api.sdk.objects.wall.responses.GetResponse;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ApiInit {

    public static void main(String[] args) throws ClientException, ApiException, IOException {
        TransportClient transportClient = new HttpTransportClient();
        VkApiClient vk = new VkApiClient(transportClient);
        File file = new File("C:/Users/mmyty/IdeaProjects/VKParserTGBot/src/main/resources/vk.properties");
        Properties properties = new Properties();
        properties.load(new FileReader(file));
//        UserAuthResponse authResponse = vk.oAuth()
//                .userAuthorizationCodeFlow(
//                        Integer.valueOf(properties.getProperty("APP_ID")),
//                        properties.getProperty("CLIENT_SECRET"),
//                        properties.getProperty("REDIRECT_URI"),
//                        properties.getProperty("CODE"))
//                .execute();

//        GroupAuthResponse authResponse = vk.oAuth()
//                .groupAuthorizationCodeFlow(Integer.valueOf(properties.getProperty("APP_ID")), properties.getProperty("CLIENT_SECRET"),
//                        properties.getProperty("REDIRECT_URI"), properties.getProperty("CODE"))
//                .execute();

//        GroupActor actor = new GroupActor(groupId, authResponse.getAccessTokens().get(groupId));

//        UserActor actor = new UserActor((long)authResponse.getUserId(), authResponse.getAccessToken());
        ServiceActor serviceActor = new ServiceActor(Integer.valueOf(
                properties.getProperty("APP_ID")),
                properties.getProperty("SERVICE_KEY"));

        GetResponse getResponse = vk.wall().get(serviceActor)
                .ownerId(Long.valueOf(properties.getProperty("GROUP_ID")))
                .domain(properties.getProperty("GROUP_DOMAIN"))
                .count(1)
                .execute();

    }
}
