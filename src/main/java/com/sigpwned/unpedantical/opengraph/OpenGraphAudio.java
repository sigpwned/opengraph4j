package com.sigpwned.unpedantical.opengraph;

import java.util.Objects;
import java.util.Optional;

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

  public OpenGraphAudio(String url, String secureUrl, String type) {
    if(url == null)
      throw new NullPointerException();
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
  public int hashCode() {
    return Objects.hash(secureUrl, type, url);
  }

  @Override
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
  public String toString() {
    return "OpenGraphAudio [url=" + url + ", secureUrl=" + secureUrl + ", type=" + type + "]";
  }
}
