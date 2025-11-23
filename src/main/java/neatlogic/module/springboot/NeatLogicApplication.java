/*
 *
 * Copyright (C) 2025  TechSure Co., Ltd.  All Rights Reserved.
 * This file is part of the NeatLogic software.
 * Licensed under the NeatLogic Sustainable Use License (NSUL), Version 4.x – 2025.
 * You may use this file only in compliance with the License.
 * See the LICENSE file distributed with this work for the full license text.
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 */

package neatlogic.module.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.admin.SpringApplicationAdminJmxAutoConfiguration;
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration;
import org.springframework.boot.autoconfigure.availability.ApplicationAvailabilityAutoConfiguration;
import org.springframework.boot.autoconfigure.context.LifecycleAutoConfiguration;
import org.springframework.boot.autoconfigure.context.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebAutoConfiguration;
import org.springframework.boot.autoconfigure.freemarker.FreeMarkerAutoConfiguration;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
import org.springframework.boot.autoconfigure.http.HttpMessageConvertersAutoConfiguration;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JmsAutoConfiguration;
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration;
import org.springframework.boot.autoconfigure.netty.NettyAutoConfiguration;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.boot.autoconfigure.sql.init.SqlInitializationAutoConfiguration;
import org.springframework.boot.autoconfigure.task.TaskExecutionAutoConfiguration;
import org.springframework.boot.autoconfigure.task.TaskSchedulingAutoConfiguration;
import org.springframework.boot.autoconfigure.transaction.TransactionAutoConfiguration;
import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.HttpEncodingAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.websocket.servlet.WebSocketServletAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(
        exclude = {
                AopAutoConfiguration.class,
                ApplicationAvailabilityAutoConfiguration.class,
                JmxAutoConfiguration.class,
                LifecycleAutoConfiguration.class,
                MultipartAutoConfiguration.class,
                HttpMessageConvertersAutoConfiguration.class,
                RestTemplateAutoConfiguration.class,
                TaskExecutionAutoConfiguration.class,
                TaskSchedulingAutoConfiguration.class,
                PropertyPlaceholderAutoConfiguration.class,
                SqlInitializationAutoConfiguration.class,
                SpringApplicationAdminJmxAutoConfiguration.class,
                HttpEncodingAutoConfiguration.class,
                ErrorMvcAutoConfiguration.class,
                WebSocketServletAutoConfiguration.class,
                DataSourceAutoConfiguration.class,
                DataSourceTransactionManagerAutoConfiguration.class,
                FreeMarkerAutoConfiguration.class,
                GsonAutoConfiguration.class,
                JacksonAutoConfiguration.class,
                JmsAutoConfiguration.class,
                MongoDataAutoConfiguration.class,
                MongoRepositoriesAutoConfiguration.class,
                NettyAutoConfiguration.class,
                PersistenceExceptionTranslationAutoConfiguration.class,
                QuartzAutoConfiguration.class,
                SpringDataWebAutoConfiguration.class,
                TransactionAutoConfiguration.class,
                EmbeddedWebServerFactoryCustomizerAutoConfiguration.class,
                WebMvcAutoConfiguration.class,
                DispatcherServletAutoConfiguration.class
        }
)
public class NeatLogicApplication {
    /*
    Linux环境部署项目
    将neatlogic-springboot模块打成neatlogic-springboot-0.4.0.0-SNAPSHOT.jar，随便放在某个目录下，然后将本模块下的config目录复制到该目录下，如下所示：
    /neatloigc
        neatlogic-springboot-0.4.0.0-SNAPSHOT.jar
        logs
        config
            application.properties
            config.properties
            logback.xml
            serverid.conf

    执行命令时将下面命令转成一行，参数之间用空格隔开

    java
    -Dlog4j.home=/neatlogic/logs
    -Dlog4j.priority=trace
    -Dfile.encoding=UTF-8
    -Dnacos.home=192.168.0.10:8848
    -Dnacos.namespace=neatlogic
    -DenableNoSecret=true
    -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005
    -XX:+HeapDumpOnOutOfMemoryError
    -Xlog:gc*:file=/neatlogic/logs/gc.log:time,uptime,level,tags
    -Djava.io.tmpdir=/neatlogic/tmp
    -Djava.awt.headless=true
    -DenableNoSecret=true
    --add-opens=java.base/java.lang=ALL-UNNAMED
    --add-opens=java.base/java.io=ALL-UNNAMED
    --add-opens=java.base/java.util=ALL-UNNAMED
    --add-opens=java.base/java.util.concurrent=ALL-UNNAMED
    --add-opens=java.rmi/sun.rmi.transport=ALL-UNNAMED
    -Xbootclasspath/a:./config
    -jar neatlogic-springboot-0.4.0.0-SNAPSHOT.jar
    */

    /*
    Windows环境部署项目
    将neatlogic-springboot模块打成neatlogic-springboot-0.4.0.0-SNAPSHOT.jar，随便放在某个目录下，然后将本模块下的config目录复制到该目录下，如下所示：
    /neatloigc
        neatlogic-springboot-0.4.0.0-SNAPSHOT.jar
        logs
        config
            application.properties
            config.properties
            logback.xml
            serverid.conf

    执行命令时将下面命令转成一行，参数之间用空格隔开

    java
    "-Dlog4j.home=D:\\neatlogic\\logs"
    "-Dlog4j.priority=trace"
    "-Dfile.encoding=UTF-8"
    "-Dnacos.home=192.168.0.10:8848"
    "-Dnacos.namespace=neatlogic"
    "-DenableNoSecret=true"
    "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=5005"
    "-XX:+HeapDumpOnOutOfMemoryError"
    "-Xlog:gc*:file=D:\\neatlogic\\logs\\gc.log:time,uptime,level,tags"
    "-Djava.io.tmpdir=D:\\neatlogic\\tmp" "-Djava.awt.headless=true"
    "-DenableNoSecret=true"
    "--add-opens=java.base/java.lang=ALL-UNNAMED"
    "--add-opens=java.base/java.io=ALL-UNNAMED"
    "--add-opens=java.base/java.util=ALL-UNNAMED"
    "--add-opens=java.base/java.util.concurrent=ALL-UNNAMED"
    "--add-opens=java.rmi/sun.rmi.transport=ALL-UNNAMED"
    "-Xbootclasspath/a:./config"
    -jar neatlogic-springboot-0.4.0.0-SNAPSHOT.jar
    */

    /*
    研发环境启动项目
    用IntelliJ IDEA启动项目时需要将config目录标记为资源根目录(右键config目录 → Mark Directory as → Resources Root),再设置VM options如下：

    -Dlog4j.home=D:\logs2
    -Dlog4j.priority=trace
    -Dfile.encoding=UTF-8
    -Dnacos.home=192.168.0.10:8848
    -Dnacos.namespace=neatlogic
    -DenableNoSecret=true
    --add-opens=java.base/java.lang=ALL-UNNAMED
    --add-opens=java.base/java.io=ALL-UNNAMED
    --add-opens=java.base/java.util=ALL-UNNAMED
    --add-opens=java.base/java.util.concurrent=ALL-UNNAMED
    --add-opens=java.rmi/sun.rmi.transport=ALL-UNNAMED
     */
    /*
    参数解析：
    //nacos配置，会优先使用nacos，获取不到config则会从config.properties中获取
    -Dnacos.home=192.168.0.10:8848
    -Dnacos.namespace=neatlogic
    //日志级别
    -Dlog4j.priority=ERROR
    //设为true，输入用户名后可使用任意密码登录，只能在研发阶段使用！
    -DenableNoSecret=false
    //确保JVM使用UTF-8编码来解释和处理文本数据,否则可能会导致中文乱码
    -Dfile.encoding=UTF-8
     */

    /*
    运行NeatLogicApplication.main方法启动Springboot时报错Error running 'NeatLogicApplication' Error running NeatLogicApplication. Command line is too long. Shorten the command line and rerun.
    ‌错误原因‌
    1.Windows 命令行长度限制‌
        Windows 对命令行参数的总长度限制为 8191 字符‌（CMD）或 32767 字符‌（PowerShell）。
        Spring Boot 项目依赖较多时，生成的类路径（CLASSPATH）可能超过此限制。
    2.‌触发场景‌
        项目依赖过多（如大型微服务项目）。
        使用默认的启动配置（JAR Manifest 模式）。
    ‌解决方案‌
    1. ‌修改启动配置（推荐）‌
    在 IDEA 中调整启动配置的 ‌缩短命令行‌ 选项：
        打开 Run/Debug Configurations。
        找到你的 Spring Boot 启动配置（如 NeatLogicApplication）。
        在 Modify options 中选择 Shorten command line‌。
        选择以下模式：
            1.JAR Manifest‌：将类路径写入临时文件（适用于大多数场景）。
    */

    /*
    运行NeatLogicApplication.main方法启动Springboot项目时报错ERROR: nacos获取不到配置且本地config.properties获取失败,请确认nacos服务是否正常或config.properties文件是否存在,如果存在,文件权限是否正常
    错误原因‌
    neatlogic-springboot/target/classes目录下没有application.properties、config.properties、logback.xml、serverid.conf这些文件
    解决方法：
        1.需要将config目录标记为资源根目录(右键config目录 → Mark Directory as → Resources Root)
        2.将neatlogic-springboot/target目录删除，再运行NeatLogicApplication.main方法启动Springboot项目
     */
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(NeatLogicApplication.class);
        ConfigurableApplicationContext run = application.run(args);
    }
}
