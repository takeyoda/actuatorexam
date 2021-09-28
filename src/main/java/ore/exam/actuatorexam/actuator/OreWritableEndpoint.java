package ore.exam.actuatorexam.actuator;

import ore.exam.actuatorexam.components.SomeComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;

@Endpoint(id = "orew")
@Component
public class OreWritableEndpoint {
  @Autowired private SomeComponent someComponent;

  @ReadOperation
  public long get() {
    return someComponent.get();
  }

  @WriteOperation
  public void set(long value) {
    someComponent.set(value);
  }
}
