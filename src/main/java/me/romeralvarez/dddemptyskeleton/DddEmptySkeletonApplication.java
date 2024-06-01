package me.romeralvarez.dddemptyskeleton;

import me.romeralvarez.dddemptyskeleton.shared.domain.Service;
import me.romeralvarez.dddemptyskeleton.user.domain.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@ComponentScan(
    includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class),
    value = {"me.romeralvarez"}

)
public class DddEmptySkeletonApplication {

  public static void main(String[] args) {
    SpringApplication.run(DddEmptySkeletonApplication.class, args);
  }

}
