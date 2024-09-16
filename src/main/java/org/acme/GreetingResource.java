package org.acme;

import dev.langchain4j.data.message.SystemMessage;
import dev.langchain4j.data.message.UserMessage;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.jlama.JlamaChatModel;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {

        ChatLanguageModel model = JlamaChatModel.builder()
                .modelName("tjake/TinyLlama-1.1B-Chat-v1.0-Jlama-Q4")
                .temperature(0.3f)
                .build();

        String response = model.generate(
                        SystemMessage.from("You are helpful chatbot who is a java expert."),
                        UserMessage.from("Write a java program to print hello world."))
                .content()
                .text();


        return response;
    }
}
