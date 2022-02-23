package hello.core.beanFind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac= new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력")
    void findAllBean(){
        String [] beanDefName = ac.getBeanDefinitionNames();
        for (String s: beanDefName){
            Object bean = ac.getBean(s);
            System.out.println("bean = "+bean);
        }

    }

    @Test
    @DisplayName("애플리케이션 빈 출력")
    void findAppBean(){
        String [] beanDefName = ac.getBeanDefinitionNames();
        for (String s: beanDefName){
            BeanDefinition definition = ac.getBeanDefinition(s);
            if (definition.getRole() == BeanDefinition.ROLE_APPLICATION){
                Object bean = ac.getBean(s);
                System.out.println("bean = "+bean);
            }
        }

    }
}
