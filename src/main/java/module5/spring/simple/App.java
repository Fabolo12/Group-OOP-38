package module5.spring.simple;

import module5.spring.simple.config.AppConfig;
import module5.spring.simple.models.Computer;
import module5.spring.simple.repositories.MySqlDriver;
import module5.spring.simple.services.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {
    public static void main(String[] args) {
        AbstractApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MySqlDriver mysql = appContext.getBean(MySqlDriver.class);
        System.out.println("MySQL driver info:");
        System.out.println(mysql.getInfo());

        System.out.println("UserService Information");
        UserService userService = appContext.getBean(UserService.class);
        System.out.println(userService.getDriverInfo());

        final Computer computer = appContext.getBean(Computer.class);
        System.out.println(computer);
    }
}
