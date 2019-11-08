package com.zte.resource;

import com.codahale.metrics.annotation.Timed;
import com.zte.pojo.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Path("/hello-world")告诉Jersey,这个资源可以在URI上访问/hello-world
 * @Produce(MediaType.APPLICATION_JSON)让Jersey的内容协商代码知道这个资源产生的表示形式是application/json
 * AtomicLong为我们提供了一种廉价，线程安全的方法来生成唯一ID
 * @author dadongge
 * @date 2019/11/8
 */
@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class HelloWorldResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloWorldResource(String template,String defaultName){
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name") Optional<String> name){
        final String value = String.format(template,name.orElse(defaultName));
        return new Saying(counter.incrementAndGet(),value);
    }
}
