package module5.spring.simple.swap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanB {

    private final BeanC beanC;

    @Autowired
    public BeanB(final BeanC beanC) {
        this.beanC = beanC;
    }
}
