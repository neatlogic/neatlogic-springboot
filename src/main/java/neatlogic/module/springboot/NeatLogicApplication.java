/*
 * Copyright (C) 2024  深圳极向量科技有限公司 All Rights Reserved.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
    生产环境部署项目
    将neatlogic-springboot模块打成neatlogic-springboot-0.3.0.0-SNAPSHOT.jar，随便放在某个目录下，然后将本模块下的config目录复制到该目录下，如下所示：
    /neatloigc
        neatlogic-springboot-0.3.0.0-SNAPSHOT.jar
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
    -Xdebug
    -Xnoagent
    -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=5005
    -XX:+UseConcMarkSweepGC
    -XX:+PrintGCDetails
    -XX:+PrintGCTimeStamps
    -XX:+HeapDumpOnOutOfMemoryError
    -verbose:gc
    -Xloggc:/neatlogic/logs/gc.log
    -Djava.io.tmpdir=/neatlogic/tmp
    -Djava.awt.headless=true
    -DenableNoSecret=true
    -Xbootclasspath/a:./config
    -jar neatlogic-springboot-0.3.0.0-SNAPSHOT.jar
    */

    /*
    研发环境启动项目
    用IntelliJ IDEA启动项目时需要将config目录标记为资源根目录,再设置VM options如下：

    -Dlog4j.home=D:\logs2
    -Dlog4j.priority=trace
    -Dfile.encoding=UTF-8
    -Dnacos.home=192.168.0.10:8848
    -Dnacos.namespace=neatlogic
    -DenableNoSecret=true
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
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(NeatLogicApplication.class);
        ConfigurableApplicationContext run = application.run(args);
    }
}
