package pl.sdacademy.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class FooBeanB {
//    private final ApplicationContext applicationContext;
//
//    public FooBeanB(ApplicationContext applicationContext) {
//        this.applicationContext = applicationContext;
//    }
//
//    private void doFoo(){
//       FooBeanA fooBeanA = applicationContext.getBean(
//               FooBeanA.class);
//    }
//

    private final FooBeanA fooBeanA;

    public FooBeanB(@Lazy FooBeanA fooBeanA) {
        this.fooBeanA = fooBeanA;
    }
}
