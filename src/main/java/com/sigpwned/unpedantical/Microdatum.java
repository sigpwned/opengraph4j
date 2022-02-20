package com.sigpwned.unpedantical;

import java.util.Objects;

public class Microdatum<T> {
  public static <T> Microdatum<T> of(Authority authority, T value) {
    return new Microdatum<>(authority, value);
  }

  private final Authority authority;
  private final T value;

  public Microdatum(Authority authority, T value) {
    this.authority = authority;
    this.value = value;
  }
  
  public Authority getAuthority() {
    return authority;
  }

  public T getValue() {
    return value;
  }

  @Override
  public int hashCode() {
    return Objects.hash(authority, value);
  }

  @Override
  @SuppressWarnings("rawtypes")
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Microdatum other = (Microdatum) obj;
    return authority == other.authority && Objects.equals(value, other.value);
  }

  @Override
  public String toString() {
    return "Microdatum [authority=" + authority + ", value=" + value + "]";
  }
}
