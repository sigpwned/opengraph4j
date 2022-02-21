package com.sigpwned.unpedantical.opengraph.type;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import com.sigpwned.unpedantical.opengraph.OpenGraphAudio;
import com.sigpwned.unpedantical.opengraph.OpenGraphImage;
import com.sigpwned.unpedantical.opengraph.OpenGraphMetadata;
import com.sigpwned.unpedantical.opengraph.OpenGraphVideo;
import com.sigpwned.unpedantical.opengraph.util.Genders;

public class ProfileOpenGraphMetadata extends OpenGraphMetadata {
  public static final String TYPE = "profile";

  /**
   * A name normally given to an individual by a parent or self-chosen.
   */
  private final String firstName;

  /**
   * A name inherited from a family or marriage and by which the individual is commonly known.
   */
  private final String lastName;

  /**
   * A short unique string to identify them.
   */
  private final String username;

  /**
   * Their gender.
   * 
   * @see Genders
   */
  private final String gender;

  private ProfileOpenGraphMetadata(Builder builder) {
    super(builder.getType(), builder.getTitle(), builder.getUrl(), builder.getDescription(),
        builder.getDeterminer(), builder.getLocale(), builder.getAlternateLocales(),
        builder.getSiteName(), builder.getImages(), builder.getVideos(), builder.getAudios());
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.username = builder.username;
    this.gender = builder.gender;
  }

  public ProfileOpenGraphMetadata(String title, String url, String description, String determiner,
      String locale, List<String> alternateLocales, String siteName, List<OpenGraphImage> images,
      List<OpenGraphVideo> videos, List<OpenGraphAudio> audios, String firstName, String lastName,
      String username, String gender) {
    super(TYPE, title, url, description, determiner, locale, alternateLocales, siteName, images,
        videos, audios);
    this.firstName = firstName;
    this.lastName = lastName;
    this.username = username;
    this.gender = gender;
  }

  public Optional<String> getFirstName() {
    return Optional.ofNullable(firstName);
  }

  public Optional<String> getLastName() {
    return Optional.ofNullable(lastName);
  }

  public Optional<String> getUsername() {
    return Optional.ofNullable(username);
  }

  public Optional<String> getGender() {
    return Optional.ofNullable(gender);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Objects.hash(firstName, gender, lastName, username);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    ProfileOpenGraphMetadata other = (ProfileOpenGraphMetadata) obj;
    return Objects.equals(firstName, other.firstName) && Objects.equals(gender, other.gender)
        && Objects.equals(lastName, other.lastName) && Objects.equals(username, other.username);
  }

  @Override
  public String toString() {
    return "ProfileOpenGraphMetadata [firstName=" + firstName + ", lastName=" + lastName
        + ", username=" + username + ", gender=" + gender + ", getType()=" + getType()
        + ", getTitle()=" + getTitle() + ", getUrl()=" + getUrl() + ", getDescription()="
        + getDescription() + ", getDeterminer()=" + getDeterminer() + ", getLocale()=" + getLocale()
        + ", getAlternateLocales()=" + getAlternateLocales() + ", getSiteName()=" + getSiteName()
        + ", getImages()=" + getImages() + ", getVideos()=" + getVideos() + ", getAudios()="
        + getAudios() + "]";
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link ProfileOpenGraphMetadata}.
   */
  public static final class Builder extends OpenGraphMetadata.Builder {
    private String firstName;
    private String lastName;
    private String username;
    private String gender;

    public Builder() {
      super(TYPE);
    }

    private Builder(ProfileOpenGraphMetadata instance) {
      super(instance);
      firstName = instance.firstName;
      lastName = instance.lastName;
      username = instance.username;
      gender = instance.gender;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
      return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
      this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
      return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
      this.lastName = lastName;
    }

    /**
     * @return the username
     */
    public String getUsername() {
      return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
      this.username = username;
    }

    /**
     * @return the gender
     */
    public String getGender() {
      return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
      this.gender = gender;
    }

    /**
     * Builder method for firstName parameter.
     * 
     * @param firstName field to set
     * @return builder
     */
    public Builder withFirstName(String firstName) {
      setFirstName(firstName);
      return this;
    }

    /**
     * Builder method for lastName parameter.
     * 
     * @param lastName field to set
     * @return builder
     */
    public Builder withLastName(String lastName) {
      setLastName(lastName);
      return this;
    }

    /**
     * Builder method for username parameter.
     * 
     * @param username field to set
     * @return builder
     */
    public Builder withUsername(String username) {
      setUsername(username);
      return this;
    }

    /**
     * Builder method for gender parameter.
     * 
     * @param gender field to set
     * @return builder
     */
    public Builder withGender(String gender) {
      setGender(gender);
      return this;
    }

    /**
     * Builder method of the builder.
     * 
     * @return built class
     */
    public ProfileOpenGraphMetadata build() {
      return new ProfileOpenGraphMetadata(this);
    }
  }
}
