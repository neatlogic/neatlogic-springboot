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

package neatlogic.module.springboot.config;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.boot.web.servlet.DelegatingFilterProxyRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.web.filter.DelegatingFilterProxy;

import javax.servlet.Filter;
import javax.servlet.ServletException;

/**
 * 禁止springboot自动将容器中filter实例添加到Servlet容器中
 */
public class DisableFilterAutoConfiguration implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        ConfigurableListableBeanFactory beanFactory = (ConfigurableListableBeanFactory) registry;
        String[] names = beanFactory.getBeanNamesForType(Filter.class, true, false);
        for (String name : names) {
            String beanName = name + "_DisableFilterAutoConfigurationRegistrationBean";
            BeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClassName(DisableFilterAutoConfigurationRegistrationBean.class.getName());
            MutablePropertyValues values = beanDefinition.getPropertyValues();
            values.addPropertyValue("enabled", false);
            ConstructorArgumentValues constructorArgumentValues = beanDefinition.getConstructorArgumentValues();
            constructorArgumentValues.addIndexedArgumentValue(0, name);
            constructorArgumentValues.addIndexedArgumentValue(1, beanFactory);
            registry.registerBeanDefinition(beanName, beanDefinition);
        }
    }

    private static class DisableFilterAutoConfigurationRegistrationBean extends DelegatingFilterProxyRegistrationBean {
        private final ConfigurableListableBeanFactory beanFactory;
        public DisableFilterAutoConfigurationRegistrationBean(String targetBeanName, ConfigurableListableBeanFactory beanFactory) {
            super(targetBeanName, new ServletRegistrationBean<>());
            this.beanFactory = beanFactory;
        }

        @Override
        public DelegatingFilterProxy getFilter() {
            String targetBeanName = getTargetBeanName();
            // 这里获取bean实例是为了执行@PostConstruct方法，因为MasterJsonWebTokenValidFilter类是通过该方法向ServletContext中添加过滤器的
            // 否则会抛异常Filters cannot be added to context [/neatlogic] as the context has been initialised（由于上下文已初始化，因此无法将筛选器添加到上下文[/neatlogic]）
            Filter bean = beanFactory.getBean(targetBeanName, Filter.class);
            return new DelegatingFilterProxy(targetBeanName, null) {

                @Override
                protected void initFilterBean() throws ServletException {
                    // Don't initialize filter bean on init()
                }

            };
        }
    }
}
