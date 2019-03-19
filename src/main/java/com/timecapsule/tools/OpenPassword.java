package com.timecapsule.tools;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OpenPassword {

    public static String buildOpenPassword(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

}
