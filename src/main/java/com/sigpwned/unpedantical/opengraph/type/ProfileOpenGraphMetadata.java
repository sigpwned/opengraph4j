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

  public ProfileOpenGraphMetadata(String type, String title, String url, String description,
      String determiner, String locale, List<String> alternateLocales, String siteName,
      List<OpenGraphImage> images, List<OpenGraphVideo> videos, List<OpenGraphAudio> audios,
      String firstName, String lastName, String username, String gender) {
    super(type, title, url, description, determiner, locale, alternateLocales, siteName, images,
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
}
