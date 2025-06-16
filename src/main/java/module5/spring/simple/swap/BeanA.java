package module5.spring.simple.swap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanA {

    private final BeanB beanB;

    @Autowired
    public BeanA(final BeanB beanB) {
        this.beanB = beanB;
    }
}
