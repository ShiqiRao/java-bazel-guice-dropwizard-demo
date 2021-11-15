package com.example.demo.config;

import com.example.demo.annotation.Count;
import com.example.demo.annotation.DefaultName;
import com.example.demo.annotation.Template;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class ConfigurationModule extends AbstractModule {

    private final HelloWorldConfiguration configuration;

    public ConfigurationModule(HelloWorldConfiguration configuration) {
        this.configuration = configuration;
    }

    @Provides
    @Template
    public String provideTemplate() {
        return configuration.getTemplate();
    }

    @Provides
    @DefaultName
    public String provideDefaultName() {
        return configuration.getDefaultName();
    }

    @Provides
    @Count
    public Integer provideCount() {
        return 3;
    }
}
