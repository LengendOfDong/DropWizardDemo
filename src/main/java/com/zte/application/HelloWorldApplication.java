package com.zte.application;

import com.zte.configuration.HelloWorldConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 *
 * @author dadongge
 * @date 2019/11/7
 */
public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }
    @Override
    public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment) throws Exception {

    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<HelloWorldConfiguration> bootstrap) {
        //nothing to do yet
    }
}
