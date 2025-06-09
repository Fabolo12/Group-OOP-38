package module4.lecture8.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class Main {
    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        final MyBean bean1 = context.getBean(MyBean.class);
        System.out.println("Bean created: " + bean1);
        final MyBean bean2 = context.getBean(MyBean.class);
        System.out.println("Bean created: " + bean2);
        System.out.println("Are beans equal? " + (bean1 == bean2));
    }
}

@Configuration
class MyConfig {
     @Bean
     public MyBean myService() {
         return new MyBean();
     }
}

class MyBean {
    public MyBean() {
        System.out.println("MyBean constructor called");
    }
}

class MyBean2 {

}