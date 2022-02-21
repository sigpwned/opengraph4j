package com.sigpwned.unpedantical.opengraph.type.video;

import java.net.URI;
import java.util.Objects;

public class OpenGraphVideoActor {
  public static OpenGraphVideoActor of(URI profile, String role) {
    return new OpenGraphVideoActor(profile, role);
  }

  private final URI profile;
  private final String role;

  private OpenGraphVideoActor(Builder builder) {
    this.profile = builder.profile;
    this.role = builder.role;
  }

  public OpenGraphVideoActor(URI profile, String role) {
    if (profile == null)
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

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static Builder builder(URI uri) {
    return new Builder(uri);
  }

  /**
   * Builder to build {@link OpenGraphVideoActor}.
   */
  public static final class Builder {
    private final URI profile;
    private String role;

    public Builder(URI profile) {
      if (profile == null)
        throw new NullPointerException();
      this.profile = profile;
    }

    private Builder(OpenGraphVideoActor openGraphVideoActor) {
      this.profile = openGraphVideoActor.profile;
      this.role = openGraphVideoActor.role;
    }

    /**
     * @return the profile
     */
    public URI getProfile() {
      return profile;
    }

    /**
     * @return the role
     */
    public String getRole() {
      return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(String role) {
      this.role = role;
    }

    /**
     * Builder method for role parameter.
     * 
     * @param role field to set
     * @return builder
     */
    public Builder withRole(String role) {
      setRole(role);
      return this;
    }

    /**
     * Builder method of the builder.
     * 
     * @return built class
     */
    public OpenGraphVideoActor build() {
      return new OpenGraphVideoActor(this);
    }
  }
}
