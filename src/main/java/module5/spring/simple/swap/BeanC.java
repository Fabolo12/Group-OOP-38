package module5.spring.simple.swap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BeanC {

    private BeanA beanA;

    @Lazy
    @Autowired
    public BeanC(final BeanA beanA) {
        this.beanA = beanA;
    }
}
