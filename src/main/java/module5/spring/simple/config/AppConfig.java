package module5.spring.simple.config;

import module5.spring.simple.models.Computer;
import module5.spring.simple.repositories.DataBaseDriver;
import module5.spring.simple.repositories.OracleDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan("module5.spring.simple")
@PropertySource("classpath:application.properties")
public class AppConfig {

    private final Environment environment;

    @Autowired
    public AppConfig(final Environment environment) {
        this.environment = environment;
    }

    @Bean(initMethod = "turnOn", destroyMethod = "turnOff")
    Computer computer() {
        return new Computer();
    }

    @Bean
    @Primary
    DataBaseDriver oracleDriver() {
        OracleDriver oracleDriver = new OracleDriver();
        oracleDriver.setDriver(environment.getProperty("db.driver"));
        oracleDriver.setUrl(environment.getProperty("db.url"));
        oracleDriver.setPort(Integer.parseInt(environment.getProperty("db.port")));
        oracleDriver.setUser(environment.getProperty("db.user"));
        oracleDriver.setPassword(environment.getProperty("db.password"));

        return oracleDriver;
    }
}
