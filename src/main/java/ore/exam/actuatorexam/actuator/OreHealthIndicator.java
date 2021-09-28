package ore.exam.actuatorexam.actuator;

import java.util.Random;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.stereotype.Component;

@Component
public class OreHealthIndicator extends AbstractHealthIndicator {
  private final Random random = new Random();

  @Override
  protected void doHealthCheck(Health.Builder builder) throws Exception {
    if (random.nextBoolean()) {
      builder.up();
    } else {
      builder.down();
    }
    builder.withDetail("someNumber", random.nextInt());
  }
}
