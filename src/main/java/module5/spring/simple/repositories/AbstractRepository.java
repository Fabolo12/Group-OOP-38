package module5.spring.simple.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class AbstractRepository {

    private MySqlDriver driver;

    @Autowired
    public void setManager(final MySqlDriver driver) {
        this.driver = driver;
    }

}
