package ore.exam.actuatorexam.actuator;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

// https://docs.spring.io/spring-boot/docs/current/reference/html/actuator.html#actuator.endpoints
// https://spring.io/blog/2017/08/22/introducing-actuator-endpoints-in-spring-boot-2-0
@WebEndpoint(id = "ore")
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class OreEndpoint {

  @Autowired private WebRequest request;

  @ReadOperation
  public Result get() {
    final Result result = new Result();
    for (final Iterator<String> it = request.getHeaderNames(); it.hasNext(); ) {
      String name = it.next();
      String[] values = request.getHeaderValues(name);
      String valueString = values == null ? "" : String.join(",", values);
      result.headers.put(name, valueString);
    }
    for (final Map.Entry<String, String[]> param : request.getParameterMap().entrySet()) {
      String valueString = String.join(",", param.getValue());
      result.params.put(param.getKey(), valueString);
    }
    return result;
  }

  public static class Result {
    public final Map<String, String> headers = new TreeMap<>();
    public final Map<String, String> params = new TreeMap<>();
  }
}
