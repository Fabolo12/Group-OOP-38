package module5.spring.simple.repositories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("MySqlDriver")
@PropertySource("classpath:mysqldatabase.properties")
public class MySqlDriver implements DataBaseDriver {
    @Value("${databaseName}")
    private String databaseName;

    @Value("${disableStatementPooling}")
    private String disableStatementPooling;

    @Override
    public String getInfo() {
        return "[ Driver: mySql" +
                ", databaseName: " + databaseName +
                ", disableStatementPooling: " + disableStatementPooling +
                " ]";
    }
}
