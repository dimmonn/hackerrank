package dp.spring.local.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class HWClient implements HelloWorldConsumer {

  private HelloWorldCapable helloWorldCapable;

  @Autowired
  @Qualifier("hwBasic")
  public void setHelloWorldCapable(final HelloWorldCapable helloWorldCapable) {
    this.helloWorldCapable = helloWorldCapable;
  }

  @Override
  public void say(int i) {
    helloWorldCapable.sayHi("hey dude" + i);
  }


  public static void main(String[] args) throws InterruptedException {
    AnnotationConfigApplicationContext config = new AnnotationConfigApplicationContext(
        TalkConfiguration.class);
    HelloWorldConsumer helloWorldBasic = config.getBean(HWClient.class);
    for (int i = 0; i < 10000000; i++) {
      Thread.sleep(1000);
      helloWorldBasic.say(i);
    }

  }
}
