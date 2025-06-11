package module4.lecture8.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

public class Main {
    public static void main(String[] args) {
        final ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        final MyBean bean1 = context.getBean(MyBean.class);
        System.out.println("Bean created: " + bean1);
        final MyBean bean2 = context.getBean(MyBean.class);
        System.out.println("Bean created: " + bean2);
        System.out.println("Are beans equal? " + (bean1 == bean2));

        System.out.println("--------------------");

        final Box box1 = context.getBean(Box.class);
        System.out.println("Box created: " + box1);
        final Box box2 = context.getBean(Box.class);
        System.out.println("Box created: " + box2);
        System.out.println("Are boxes equal? " + (box1 == box2));

    }

    static class MyBean {

        private Box box;

        public MyBean(final Box box) {
            this.box = box;
            System.out.println("MyBean constructor called");
        }
    }

    static class Box {
        public Box() {
            System.out.println("Box constructor called");
        }
    }

    class MyBean2 {

    }
}

@Configuration
class MyConfig {
    @Bean
    @Scope("singleton") // Default scope is singleton
    public Main.MyBean myService() {
        return new Main.MyBean(box());
    }

    @Bean
    @Scope("prototype")
    public Main.Box box() {
        return new Main.Box();
    }
}

