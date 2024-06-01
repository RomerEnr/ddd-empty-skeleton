package me.romeralvarez.dddemptyskeleton.user.domain.event;

import lombok.NoArgsConstructor;
import me.romeralvarez.dddemptyskeleton.shared.domain.bus.event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.UUID;

@NoArgsConstructor
public class OnUserCreated extends DomainEvent {
  private UUID userId;
  private String username;
  private String firstName;
  private String lastName;
  private String password;
  private boolean isIncognitoMode;

  public OnUserCreated(UUID userId, String username, String firstName, String lastName, String password, boolean isIncognitoMode) {
    super(userId.toString());
    this.userId = userId;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.isIncognitoMode = isIncognitoMode;
  }

  public OnUserCreated(String aggregateId, String eventId, String occurredOn, UUID userId, String username, String firstName, String lastName, String password, boolean isIncognitoMode) {
    super(aggregateId, eventId, occurredOn);
    this.userId = userId;
    this.username = username;
    this.firstName = firstName;
    this.lastName = lastName;
    this.password = password;
    this.isIncognitoMode = isIncognitoMode;
  }


  @Override
  public String eventName() {
    return "user.created";
  }

  @Override
  public HashMap<String, Serializable> toPrimitives() {
    return new HashMap<String, Serializable>() {{
      put("userId", userId.toString());
      put("username", username);
      put("firstName", firstName);
      put("lastName", lastName);
      put("password", password);
      put("isIncognitoMode", Boolean.toString(isIncognitoMode));
    }};
  }

  @Override
  public DomainEvent fromPrimitives(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
    return new OnUserCreated(
        aggregateId,
        eventId,
        occurredOn,
        UUID.fromString((String) body.get("userId")),
        (String) body.get("username"),
        (String) body.get("firstName"),
        (String) body.get("lastName"),
        (String) body.get("password"),
        Boolean.parseBoolean((String) body.get("isIncognitoMode"))
    );
  }
}