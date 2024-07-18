package org.example.api;

import jakarta.ws.rs.ApplicationPath;
import org.example.api.controller.CarResource;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/api")
public class HelloApplication extends ResourceConfig {
    public HelloApplication() {
        packages("org.example.api.controller");
        register(CarResource.class);
    }
}
