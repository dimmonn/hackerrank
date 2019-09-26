package dp.spring.local.helloworld;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"dp.spring.local.helloworld"})
public class TalkConfiguration {

  @Bean
  @Qualifier("hwBasic")
  HelloWorldCapable getHwBasic() {
    return new HelloWorldBasic();
  }

  @Bean
  @Qualifier("hwFb")
  HelloWorldCapable getHwFb() {
    return new HelloWorldFB();
  }
}
