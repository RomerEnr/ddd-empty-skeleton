package me.romeralvarez.dddemptyskeleton.shared.domain.bus.criteria;

public enum FilterOperator {
  EQUAL("="),
  NOT_EQUAL("!="),
  GT(">"),
  LT("<"),
  BETWEEN("BETWEEN"),
  LIKE("LIKE"),
  CONTAINS("CONTAINS"),
  NOT_CONTAINS("NOT_CONTAINS");

  private final String operator;

  FilterOperator(String operator) {
    this.operator = operator;
  }

  public static FilterOperator fromValue(String value) {
    return switch (value) {
      case "=" -> EQUAL;
      case "!=" -> NOT_EQUAL;
      case ">" -> GT;
      case "<" -> LT;
      case "BETWEEN" -> BETWEEN;
      case "LIKE" -> LIKE;
      case "CONTAINS" -> CONTAINS;
      case "NOT_CONTAINS" -> NOT_CONTAINS;
      default -> throw new IllegalArgumentException("Unsupported operator: " + value);
    };
  }

  public boolean isPositive() {
    return this != NOT_EQUAL && this != NOT_CONTAINS;
  }

  public String value() {
    return operator;
  }
}