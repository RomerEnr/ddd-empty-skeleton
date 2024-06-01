package me.romeralvarez.dddemptyskeleton.user.infrastructure.http;



public record UserRequest (String username, String firstName, String lastName, String email, String password, boolean isIncognitoMode) {
}
