package com.sigpwned.unpedantical.opengraph.type.video;

import java.net.URI;
import java.util.Objects;

public class OpenGraphVideoActor {
  public static OpenGraphVideoActor of(URI profile, String role) {
    return new OpenGraphVideoActor(profile, role);
  }
  
  private final URI profile;
  private final String role;
  
  public OpenGraphVideoActor(URI profile, String role) {
    if(profile == null)
      throw new NullPointerException();
    this.profile = profile;
    this.role = role;
  }

  public URI getProfile() {
    return profile;
  }

  public String getRole() {
    return role;
  }

  @Override
  public int hashCode() {
    return Objects.hash(profile, role);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OpenGraphVideoActor other = (OpenGraphVideoActor) obj;
    return Objects.equals(profile, other.profile) && Objects.equals(role, other.role);
  }

  @Override
  public String toString() {
    return "OpenGraphActor [profile=" + profile + ", role=" + role + "]";
  }
}
