package com.sigpwned.unpedantical.opengraph;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;

public class OpenGraphVideo {
  public static OpenGraphVideo of(String url, String secureUrl, String type, Integer width,
      Integer height, String alt) {
    return new OpenGraphVideo(url, secureUrl, type, width, height, alt);
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

  /**
   * The number of pixels wide.
   */
  private final Integer width;

  /**
   * The number of pixels high.
   */
  private final Integer height;

  /**
   * A description of what is in the image (not a caption). If the page specifies an og:image it
   * should specify og:image:alt.
   */
  private final String alt;

  public OpenGraphVideo(String url, String secureUrl, String type, Integer width, Integer height,
      String alt) {
    if (url == null)
      throw new NullPointerException();
    this.url = url;
    this.secureUrl = secureUrl;
    this.type = type;
    this.width = width;
    this.height = height;
    this.alt = alt;
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

  public OptionalInt getWidth() {
    return width != null ? OptionalInt.of(width) : OptionalInt.empty();
  }

  public OptionalInt getHeight() {
    return height != null ? OptionalInt.of(height) : OptionalInt.empty();
  }

  public Optional<String> getAlt() {
    return Optional.ofNullable(alt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(alt, height, secureUrl, type, url, width);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OpenGraphVideo other = (OpenGraphVideo) obj;
    return Objects.equals(alt, other.alt) && Objects.equals(height, other.height)
        && Objects.equals(secureUrl, other.secureUrl) && Objects.equals(type, other.type)
        && Objects.equals(url, other.url) && Objects.equals(width, other.width);
  }

  @Override
  public String toString() {
    return "Image [url=" + url + ", secureUrl=" + secureUrl + ", type=" + type + ", width=" + width
        + ", height=" + height + ", alt=" + alt + "]";
  }
}
