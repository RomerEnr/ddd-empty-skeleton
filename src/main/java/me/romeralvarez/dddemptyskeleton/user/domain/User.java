package me.romeralvarez.dddemptyskeleton.user.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import me.romeralvarez.dddemptyskeleton.shared.domain.AggregateRoot;
import me.romeralvarez.dddemptyskeleton.user.domain.event.OnUserCreated;

import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class User extends AggregateRoot {
  private UUID userId;
  private String username;
  private String firstName;
  private String lastName;
  private String password;
  private boolean isIncognitoMode;

  public User(UUID userId, String username, String firstName, String lastName, String password, boolean isIncognitoMode) {
    this.userId = userId;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.isIncognitoMode = isIncognitoMode;
  }

  public static User create(String username, String firstName, String lastName, String password, boolean isIncognitoMode) {
    UUID userId = UUID.randomUUID();
    User user = new User(userId, username, firstName, lastName, password, isIncognitoMode);

    OnUserCreated event = new OnUserCreated(
        user.userId,
        user.username,
        user.firstName,
        user.lastName,
        user.password,
        user.isIncognitoMode
    );
    user.record(event);

    return user;
  }
}