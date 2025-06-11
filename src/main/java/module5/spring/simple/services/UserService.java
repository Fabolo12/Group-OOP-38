package module5.spring.simple.services;

import module5.spring.simple.repositories.DataBaseDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private DataBaseDriver driver;

    @Autowired
    public UserService(final DataBaseDriver driver) {
        this.driver = driver;
    }

    public String getDriverInfo() {
        return driver.getInfo();
    }
}
