package work.garaku.code.example.mybatis_dynamic_sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main implements CommandLineRunner {
  @Autowired
  private FriendMapperCaller mapperCaller;


  public static void main(String[] args) {
    SpringApplication.run(Main.class);
  }

  @Override
  public void run(String... args) {
    mapperCaller.execute();
  }
}
