package dp.spring.local.helloworld;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorldBasic implements HelloWorldCapable {

  private final Logger logger = LoggerFactory.getLogger(this.getClass());

  @Override
  public void sayHi(String who) {

    logger.info(who + "{}", Integer.valueOf(who.charAt(who.length() - 1)));
  }
}