package com.example.demo;

import com.example.demo.config.ConfigurationModule;
import com.example.demo.config.HelloWorldConfiguration;
import com.example.demo.config.ResourceModule;
import com.example.demo.health.TemplateHealthCheck;
import com.example.demo.resource.HelloWorldResource;
import com.google.inject.Guice;
import com.google.inject.Injector;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class App extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new App().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(HelloWorldConfiguration configuration,
                    Environment environment) {
        Injector injector = Guice.createInjector(new ConfigurationModule(configuration), new ResourceModule());
        environment.healthChecks().register("template", injector.getInstance(TemplateHealthCheck.class));
        environment.jersey().register(injector.getInstance(HelloWorldResource.class));
    }

}

