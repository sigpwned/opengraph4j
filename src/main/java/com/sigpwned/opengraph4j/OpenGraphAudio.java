package com.sigpwned.opengraph4j;

import java.util.Objects;
import java.util.Optional;
import javax.annotation.processing.Generated;

/**
 * An audio clip associated with an OpenGraph entity
 * 
 * @see https://ogp.me/#aidstructuredhrefstructuredstructuredpropertiesa
 */
public class OpenGraphAudio {
  public static OpenGraphAudio of(String url, String secureUrl, String type) {
    return new OpenGraphAudio(url, secureUrl, type);
  }

  /**
   * Identical to og:image.
   */
  private final String url;

  /**
   * An alternate url to use if the webpage requires HTTPS.
   */
  private final String secureUrl;

  /**
   * A MIME type for this image.
   */
  private final String type;

  @Generated("SparkTools")
  private OpenGraphAudio(Builder builder) {
    this(builder.getUrl(), builder.getSecureUrl(), builder.getType());
  }

  public OpenGraphAudio(String url, String secureUrl, String type) {
    if (url == null)
      throw new IllegalArgumentException("no url");
    this.url = url;
    this.secureUrl = secureUrl;
    this.type = type;
  }

  public String getUrl() {
    return url;
  }

  public Optional<String> getSecureUrl() {
    return Optional.ofNullable(secureUrl);
  }

  public Optional<String> getType() {
    return Optional.ofNullable(type);
  }

  @Override
  @Generated("Eclipse")
  public int hashCode() {
    return Objects.hash(secureUrl, type, url);
  }

  @Override
  @Generated("Eclipse")
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OpenGraphAudio other = (OpenGraphAudio) obj;
    return Objects.equals(secureUrl, other.secureUrl) && Objects.equals(type, other.type)
        && Objects.equals(url, other.url);
  }

  @Override
  @Generated("Eclipse")
  public String toString() {
    return "OpenGraphAudio [url=" + url + ", secureUrl=" + secureUrl + ", type=" + type + "]";
  }

  @Generated("SparkTools")
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Generated("SparkTools")
  public static Builder builder(String url) {
    return new Builder(url);
  }

  /**
   * Builder to build {@link OpenGraphAudio}.
   */
  @Generated("SparkTools")
  public static final class Builder {
    private final String url;
    private String secureUrl;
    private String type;

    public Builder(String url) {
      if (url == null)
        throw new NullPointerException();
      this.url = url;
    }

    private Builder(OpenGraphAudio instance) {
      this.url = instance.url;
      this.secureUrl = instance.secureUrl;
      this.type = instance.type;
    }

    /**
     * @return the secureUrl
     */
    public String getSecureUrl() {
      return secureUrl;
    }

    /**
     * @param secureUrl the secureUrl to set
     */
    public void setSecureUrl(String secureUrl) {
      this.secureUrl = secureUrl;
    }

    /**
     * @return the type
     */
    public String getType() {
      return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
      this.type = type;
    }

    /**
     * @return the url
     */
    public String getUrl() {
      return url;
    }

    /**
     * Builder method for secureUrl parameter.
     * 
     * @param secureUrl field to set
     * @return builder
     */
    public Builder withSecureUrl(String secureUrl) {
      setSecureUrl(secureUrl);
      return this;
    }

    /**
     * Builder method for type parameter.
     * 
     * @param type field to set
     * @return builder
     */
    public Builder withType(String type) {
      setType(type);
      return this;
    }

    /**
     * Builder method of the builder.
     * 
     * @return built class
     */
    public OpenGraphAudio build() {
      return new OpenGraphAudio(this);
    }
  }
}
