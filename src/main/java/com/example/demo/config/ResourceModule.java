package com.example.demo.config;

import com.example.demo.resource.HelloWorldResource;
import com.example.demo.health.TemplateHealthCheck;
import com.example.demo.annotation.Count;
import com.example.demo.annotation.DefaultName;
import com.example.demo.annotation.Template;
import com.google.inject.AbstractModule;

public class ResourceModule extends AbstractModule {


    public HelloWorldResource provideHelloWorld(@Template String template,
                                                @DefaultName String defaultName,
                                                @Count Integer count) {
        return new HelloWorldResource(template, defaultName, count);
    }

    public TemplateHealthCheck provideHealthCheck(@Template String template){
        return new TemplateHealthCheck(template);
    }

}
