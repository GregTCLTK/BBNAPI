package com.bbn.api;

import com.google.gson.JsonObject;
import okhttp3.*;

import java.awt.*;
import java.io.IOException;

/**
 * @author GregTCLTK / Skidder
 */

public class BigBotNetworkClient {

    private final String token;

    public BigBotNetworkClient(String token) {
        this.token = token;
    }

    public void sendMessage(String ChannelID, String MessageContent, Color Color) throws IOException {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("content", MessageContent);
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonObject.toString());

        Request request = new Request.Builder()
                .url("https://discordapp.com/api/v6/channels/" + ChannelID + "/messages")
                .post(body)
                .addHeader("Authorization", "Bot " + token)
                .build();


        new OkHttpClient().newCall(request).execute().close();

    }
}
