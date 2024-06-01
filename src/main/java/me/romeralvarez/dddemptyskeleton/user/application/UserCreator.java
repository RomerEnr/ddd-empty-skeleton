package me.romeralvarez.dddemptyskeleton.user.application;

import lombok.extern.slf4j.Slf4j;
import me.romeralvarez.dddemptyskeleton.shared.domain.Service;
import me.romeralvarez.dddemptyskeleton.shared.domain.bus.event.EventBus;
import me.romeralvarez.dddemptyskeleton.user.domain.User;

@Service
@Slf4j
public class UserCreator {
  private EventBus eventBus;

  public UserCreator (EventBus eventBus) {
    this.eventBus = eventBus;
  }

  public void createUser(String username, String firstName, String lastName, String password, boolean isIncognitoMode) {
    User user = User.create(username, firstName, lastName, password, isIncognitoMode);
    log.info("User created: {}", user);
    eventBus.publish(user.pullDomainEvents());
  }
}
