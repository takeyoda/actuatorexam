package ore.exam.actuatorexam.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
  "ore.exam.actuatorexam.actuator",
  "ore.exam.actuatorexam.components",
  "ore.exam.actuatorexam.micrometer"
})
public class App {

  public static void main(String[] args) {
    SpringApplication.run(App.class, args);
  }
}
