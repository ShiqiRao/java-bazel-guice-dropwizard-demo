package com.example.demo.resource;

import com.codahale.metrics.annotation.Timed;
import com.example.demo.entity.Saying;
import com.example.demo.annotation.Count;
import com.example.demo.annotation.DefaultName;
import com.example.demo.annotation.Template;
import com.google.inject.Inject;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;
    private final Integer count;

    @Inject
    public HelloWorldResource(@Template String template,
                              @DefaultName String defaultName,
                              @Count Integer count) {
        this.template = template;
        this.defaultName = defaultName;
        this.count = count;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(String.format(template, name.orElse(defaultName))).append("\n");
        }
        return new Saying(counter.incrementAndGet(), sb.toString());
    }
}