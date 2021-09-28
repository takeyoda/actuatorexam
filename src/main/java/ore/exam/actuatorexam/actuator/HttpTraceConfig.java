package ore.exam.actuatorexam.actuator;

import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
public class HttpTraceConfig {

  @Bean
  public HttpTraceRepository httpTraceRepository() {
    InMemoryHttpTraceRepository repo = new InMemoryHttpTraceRepository();
    repo.setCapacity(10);
    return repo;
  }
}
