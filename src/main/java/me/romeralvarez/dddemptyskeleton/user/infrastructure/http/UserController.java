package me.romeralvarez.dddemptyskeleton.user.infrastructure.http;


import me.romeralvarez.dddemptyskeleton.user.application.UserCreator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserCreator userCreator;

  public UserController(UserCreator userCreator) {
    this.userCreator = userCreator;
  }

  @PostMapping("/create")
  public ResponseEntity<Void> createUser(@RequestBody UserRequest userRequest) {

    userCreator.createUser(userRequest.username(), userRequest.firstName(), userRequest.lastName(), userRequest.password(), userRequest.isIncognitoMode());
    return ResponseEntity.ok().build();
  }
}
