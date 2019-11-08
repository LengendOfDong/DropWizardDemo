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
 * 在sayHello内部，我们递增计数器，使用格式化模板String.format(String,Object...),并返回一个Saying新实例
 * 因为sayHello带有注释@Timed,Dropwizard会自动将其调用的持续时间和速率记录为Metrics Timer
 * 一旦sayHello返回，Jersey就会获取Saying实例并查找可以将Saying实例写为application/json的转换类。Dropwizard
 * 内置了一个这样的转换类，允许使用Java对象生成JSON对象，JSON对象生成Java对象。
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
