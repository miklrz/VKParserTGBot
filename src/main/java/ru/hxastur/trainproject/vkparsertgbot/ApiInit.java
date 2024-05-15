package ru.hxastur.trainproject.vkparsertgbot;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.UserAuthResponse;

import java.util.Properties;


public class ApiInit {
    TransportClient transportClient = new HttpTransportClient();
    VkApiClient vk = new VkApiClient(transportClient);

    Properties properties = new Properties();

    UserAuthResponse authResponse = vk.oAuth()
            .userAuthorizationCodeFlow(properties.getProperty("APP_ID"), properties.getProperty("CLIENT_SECRET"),
                    properties.getProperty("REDIRECT_URI"), code).execute();

    UserActor actor = new UserActor(authResponse.getUserId(), authResponse.getAccessToken());
}
