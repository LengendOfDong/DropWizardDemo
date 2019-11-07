# DropWizardDemo
This is my  first dropwizard project. 
# 入门
此项目将完成一个简单的DropWizard的Hello World项目。在此过程中，我们将解释各种底层库及其应用，以及DropWizard中的重要概念，并建议一些组织技术来帮助您的项目能持续健康地增长。

# 概览
DropWizard跨越了作为lib库和框架之间的界限。其目标是为生产就绪的Web应用程序所需的所有内容提供高性能，高可靠的实现。并且这些功能被封装到可重用的库中，因此您的应用程序很精简和专注，从而缩短了产品上线时间和维护负担。

# 用于HTTP的Jetty
因为您的Web应用程序不能没有HTTP，DropWizard使用Jetty,一个令人难以置信的调优HTTP服务器直接嵌入到您的项目中。DropWizard项目没有将应用程序交给复杂的应用程序服务器，而是有一个**main**方法运行HTTP服务器。将您的应用程序作为一个简单的过程运行，消除了生产中Java的许多令人讨厌的方面（没有PermGen问题，没有应用程序服务器配置和维护，没有神秘的部署工具，没有隐藏的应用程序日志，没有尝试调整单个垃圾收集器与多个应用程序工作负载一起工作）并允许您使用所有现有的Unix进程管理工具。

# 用于REST的Jersey
为了构建RESTful Web应用程序，我们发现在功能或性能方面没有任何东西胜过Jersey（JAX-RS参考实现）。它允许您编写干净，可测试的类，这些类可以优雅地将HTTP请求映射到简单的Java对象。它支持流输出，矩阵URI参数，条件GET请求等等。

# 用于JSON的Jackson
在数据格式方面，JSON已成为网络的通用语言，而Jackson则是JVM上的JSON之王。除了快速闪电之外，它还有一个复杂的对象映射器，允许您直接导出域模型。

# 用于监控的Metrics
指标有助于分析问题，为您提供无与伦比的洞悉您的生产环境中的代码的行为。

# 其他集成的工具
除了[Jetty](https://www.eclipse.org/jetty/),Jersey和Jackson之外，DropWizard还包括一些库，可以帮助您更快速高效地开发。
- Guava除了高度优化的不可变数据结构外，还提供了越来越多的类来加速Java的开发
- Logback和slf4j用于高性能和灵活的日志记录
- Hibernate Validator是JSR 349参考实现，它提供了一个简单的声明性框架，用于验证用户输入并生成有用且易于i18n的错误消息。
- 在Apache的HttpClient和Jersey客户端允许都与其他Web服务低成本和高层次的互动
- JDBI是使用Java的关系数据库最直接的方法。
- Liquibase是在整个开发和发布周期中检查数据库模式的好方法，应用高级数据库重构而不是一次性DDL脚本。
- Freemarker和Mustache是简单的模板系统，适用于面向用户的更多应用程序。
- Joda Time是一个非常完整，理智的库，用于处理日期和时间。
