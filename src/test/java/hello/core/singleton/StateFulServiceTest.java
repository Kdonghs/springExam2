package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StateFulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StateFulService bean = ac.getBean(StateFulService.class);
        StateFulService bean1 = ac.getBean(StateFulService.class);

        bean.oder("user1", 10000);
        bean1.oder("user2",20000);

        int price = bean.getPrice();
        System.out.println("price = " + price);
        Assertions.assertEquals(price,20000);
    }

    static class TestConfig{
        @Bean
        public StateFulService stateFulService(){
            return new StateFulService();
        }
    }
}