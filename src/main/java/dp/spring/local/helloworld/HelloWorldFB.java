package dp.spring.local.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldFB implements HelloWorldCapable {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public void sayHi(String who) {
    logger.info(who + " fb");
  }
}
