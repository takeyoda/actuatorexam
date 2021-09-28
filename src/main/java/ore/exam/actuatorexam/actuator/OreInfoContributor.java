package ore.exam.actuatorexam.actuator;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

@Component
public class OreInfoContributor implements InfoContributor {
  private final DateTimeFormatter formatter =
      DateTimeFormatter.ofPattern("yyyy/MM/dd (E) HH:mm:ss.SSS");

  @Override
  public void contribute(Info.Builder builder) {
    Map<String, Object> detail =
        Map.of("date", formatter.format(ZonedDateTime.now(ZoneId.systemDefault())));
    builder.withDetail("ore", detail);
  }
}
