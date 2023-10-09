package com.app.config;

import com.app.type.properties.CloudinaryProperties;
import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

@Configuration
public class CloudinaryConfig {

    @Autowired
    CloudinaryProperties cloudinaryProperties;

    @Bean
    public Cloudinary cloudinary(){
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", cloudinaryProperties.getCloudName());
        config.put("api_key", cloudinaryProperties.getCloudApiKey());
        config.put("api_secret", cloudinaryProperties.getCloudSecretKey());
        return new Cloudinary(config);
    }
}

