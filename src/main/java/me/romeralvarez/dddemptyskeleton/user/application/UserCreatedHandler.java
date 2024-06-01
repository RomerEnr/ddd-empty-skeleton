package me.romeralvarez.dddemptyskeleton.user.application;

import me.romeralvarez.dddemptyskeleton.shared.domain.Service;
import me.romeralvarez.dddemptyskeleton.shared.domain.bus.event.DomainEventSubscriber;
import me.romeralvarez.dddemptyskeleton.user.domain.event.OnUserCreated;
import org.springframework.context.event.EventListener;

@Service
@DomainEventSubscriber(OnUserCreated.class)
public class UserCreatedHandler {

    @EventListener
    public void on(OnUserCreated event) {
        System.out.println("User created: " + event);
    }
}
