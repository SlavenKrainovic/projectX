package com.bilionDolarProject.projectX.config;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JacksonConfig {
    
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Double.class, new JsonDeserializer<Double>() {
            @Override
            public Double deserialize(JsonParser p, DeserializationContext ctxt) {
                try {
                    String value = p.getValueAsString();
                    if (value == null || value.isEmpty()) {
                        return null;
                    }
                    return Double.parseDouble(value);
                } catch (Exception e) {
                    return null;
                }
            }
        });
        
        mapper.registerModule(module);
        return mapper;
    }
}
