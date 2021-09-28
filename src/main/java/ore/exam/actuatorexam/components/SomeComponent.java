package ore.exam.actuatorexam.components;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class SomeComponent {
  private final AtomicLong value = new AtomicLong(0L);

  public void set(long value) {
    this.value.set(value);
  }

  public long get() {
    return this.value.get();
  }
}
