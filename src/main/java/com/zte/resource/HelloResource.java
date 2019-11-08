package com.zte.resource;

import com.codahale.metrics.annotation.Timed;
import com.zte.pojo.Saying;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 资源就是对外提供的服务，通过读取配置，获取配置中的数据，然后将
 * 配置数据与用户传入的参数进行结合，返回相应的数据，对外提供服务。
 * 此例中就是通过将用户传入的name参数，与配置中的模板进行结合，然后
 * 将返回的Saying实例进行转换，变成application/json数据返回。
 * @author dadongge
 * @date 2019/11/9
 */
@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
public class HelloResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public HelloResource(String template,String defaultName){
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Saying sayHello(@QueryParam("name")Optional<String> name){
        final String value = String.format(template,name.orElse(defaultName));
        return new Saying(counter.incrementAndGet(),value);
    }
}
