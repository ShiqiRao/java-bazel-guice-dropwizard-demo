package com.example.demo.config;

import io.dropwizard.Configuration;

public class HelloWorldConfiguration extends Configuration {

    private String template;

    private String defaultName = "Stranger";

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String name) {
        this.defaultName = name;
    }
}