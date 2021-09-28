package ore.exam.actuatorexam.micrometer;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tag;
import io.micrometer.core.instrument.Tags;
import io.micrometer.core.instrument.binder.BaseUnits;
import io.micrometer.core.instrument.binder.MeterBinder;
import ore.exam.actuatorexam.components.SomeComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeComponentMeterBinder implements MeterBinder {

  @Autowired private SomeComponent someComponent;

  @Override
  public void bindTo(MeterRegistry registry) {
    Iterable<Tag> tag =
        Tags.of("ContainerId", "123", "ComponentId", Integer.toString(someComponent.hashCode()));
    Gauge.builder("someComponent", someComponent, SomeComponent::get)
        .description("custom meter example")
        .baseUnit(BaseUnits.MESSAGES)
        .tags(tag)
        .register(registry);
  }
}
