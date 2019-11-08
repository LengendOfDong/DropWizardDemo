package com.zte.application;

import com.zte.configuration.HelloWorldConfiguration;
import com.zte.resource.HelloResource;
import com.zte.resource.HelloWorldResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

/**
 * Dropwizard应用程序可以包含许多资源类，每个资源类都对应于自己的URI，只需添加另一个@Path注释资源类，并使用
 * 新类的实例调用register方法即可
 * 此处加入了HelloResource这个新资源，通过配置类中的参数将其实例化，然后通过register方法进行注册
 * @author dadongge
 * @date 2019/11/7
 */
public class HelloWorldApplication extends Application<HelloWorldConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }
    @Override
    public void run(HelloWorldConfiguration helloWorldConfiguration, Environment environment) throws Exception {
        final HelloWorldResource resource = new HelloWorldResource(helloWorldConfiguration.getTemplate(),helloWorldConfiguration.getDefaultName());
        environment.jersey().register(resource);
        final HelloResource helloResource = new HelloResource(helloWorldConfiguration.getTemplate(),helloWorldConfiguration.getDefaultName());
        environment.jersey().register(helloResource);
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
