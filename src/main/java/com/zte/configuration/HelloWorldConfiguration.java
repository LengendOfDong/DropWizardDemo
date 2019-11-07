package com.zte.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * 当从YAML文件反序列化该类时，它将从YAML对象中提取两个根级别字段：template(模板)，以及
 * defaultName要使用的名称。template和defaultName都标注了@NotEmpty，所以如果YAML配置文件
 * 有任何空值或者缺少template的信息会抛出异常，并且应用程序将无法启动
 * 另外，template和defaultName的getter和setter都有注释@JsonProperty,这允许Jackson既可以从YAML
 * 文件反序列化属性，也可以序列化它。
 * @author dadongge
 * @date 2019/11/6
 */
public class HelloWorldConfiguration extends Configuration {
    @NotEmpty
    private String template;

    @NotEmpty
    private String defaultName = "Stranger";

    @JsonProperty
    public String getTemplate(){
        return template;
    }

    @JsonProperty
    public void setTemplate(String template){
        this.template = template;
    }

    @JsonProperty
    public String getDefaultName(){
        return defaultName;
    }

    @JsonProperty
    public void setDefaultName(String name){
        this.defaultName = name;
    }

    public static void main(String[] args){
        HelloWorldConfiguration helloWorldConfiguration = new HelloWorldConfiguration();
        System.out.println(helloWorldConfiguration.getDefaultName());
        System.out.println(helloWorldConfiguration.getTemplate());
    }
}
