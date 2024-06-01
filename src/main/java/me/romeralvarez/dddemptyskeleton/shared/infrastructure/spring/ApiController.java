package me.romeralvarez.dddemptyskeleton.shared.infrastructure.spring;

import me.romeralvarez.dddemptyskeleton.shared.domain.DomainError;
import me.romeralvarez.dddemptyskeleton.shared.domain.bus.command.Command;
import me.romeralvarez.dddemptyskeleton.shared.domain.bus.command.CommandBus;
import me.romeralvarez.dddemptyskeleton.shared.domain.bus.command.CommandHandlerExecutionError;
import me.romeralvarez.dddemptyskeleton.shared.domain.bus.query.QueryBus;
import me.romeralvarez.dddemptyskeleton.shared.domain.bus.query.Query;
import me.romeralvarez.dddemptyskeleton.shared.domain.bus.query.QueryHandlerExecutionError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;

public abstract class ApiController {
  private final QueryBus queryBus;
  private final CommandBus commandBus;

  public ApiController(QueryBus queryBus, CommandBus commandBus) {
    this.queryBus   = queryBus;
    this.commandBus = commandBus;
  }

  protected void dispatch(Command command) throws CommandHandlerExecutionError {
    commandBus.dispatch(command);
  }

  protected <R> R ask(Query query) throws QueryHandlerExecutionError {
    return queryBus.ask(query);
  }

  abstract public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping();

  @ExceptionHandler(DomainError.class)
  public ResponseEntity<String> handleDomainError(DomainError error) {
    HashMap<Class<? extends DomainError>, HttpStatus> mapping = errorMapping();
    HttpStatus status = mapping.getOrDefault(error.getClass(), HttpStatus.INTERNAL_SERVER_ERROR);
    return ResponseEntity.status(status).body(error.getMessage());
  }
}
