/*-
 * =================================LICENSE_START==================================
 * opengraph4j
 * ====================================SECTION=====================================
 * Copyright (C) 2022 Andy Boothe
 * ====================================SECTION=====================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ==================================LICENSE_END===================================
 */
package com.sigpwned.opengraph4j.model;

import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import com.sigpwned.opengraph4j.annotation.Generated;

/**
 * A video clip associated with an OpenGraph entity
 * 
 * @see <a href="https://ogp.me/#aidstructuredhrefstructuredstructuredpropertiesa">https://ogp.me/#aidstructuredhrefstructuredstructuredpropertiesa</a>
 */
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

  @Generated("SparkTools")
  private OpenGraphVideo(Builder builder) {
    this(builder.getUrl(), builder.getSecureUrl(), builder.getType(), builder.getWidth(),
        builder.getHeight(), builder.getAlt());
  }

  public OpenGraphVideo(String url, String secureUrl, String type, Integer width, Integer height,
      String alt) {
    if (url == null)
      throw new IllegalArgumentException("no url");
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
  @Generated("Eclipse")
  public int hashCode() {
    return Objects.hash(alt, height, secureUrl, type, url, width);
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
    OpenGraphVideo other = (OpenGraphVideo) obj;
    return Objects.equals(alt, other.alt) && Objects.equals(height, other.height)
        && Objects.equals(secureUrl, other.secureUrl) && Objects.equals(type, other.type)
        && Objects.equals(url, other.url) && Objects.equals(width, other.width);
  }

  @Override
  @Generated("Eclipse")
  public String toString() {
    return "Image [url=" + url + ", secureUrl=" + secureUrl + ", type=" + type + ", width=" + width
        + ", height=" + height + ", alt=" + alt + "]";
  }

  @Generated("SparkTools")
  public Builder toBuilder() {
    return new Builder(this);
  }

  /**
   * Creates a builder to build {@link OpenGraphVideo} and initialize it with the given values.
   * 
   * @param url The url to initialize the builder with
   * @return created builder
   */
  @Generated("SparkTools")
  public static Builder builder(String url) {
    return new Builder(url);
  }

  /**
   * Builder to build {@link OpenGraphVideo}.
   */
  @Generated("SparkTools")
  public static final class Builder {
    private final String url;
    private String secureUrl;
    private String type;
    private Integer width;
    private Integer height;
    private String alt;

    public Builder(String url) {
      if (url == null)
        throw new NullPointerException();
      this.url = url;
    }

    private Builder(OpenGraphVideo instance) {
      this.url = instance.url;
      this.secureUrl = instance.secureUrl;
      this.type = instance.type;
      this.width = instance.width;
      this.height = instance.height;
      this.alt = instance.alt;
    }

    /**
     * @return the url
     */
    public String getUrl() {
      return url;
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
     * @return the width
     */
    public Integer getWidth() {
      return width;
    }

    /**
     * @param width the width to set
     */
    public void setWidth(Integer width) {
      this.width = width;
    }

    /**
     * @return the height
     */
    public Integer getHeight() {
      return height;
    }

    /**
     * @param height the height to set
     */
    public void setHeight(Integer height) {
      this.height = height;
    }

    /**
     * @return the alt
     */
    public String getAlt() {
      return alt;
    }

    /**
     * @param alt the alt to set
     */
    public void setAlt(String alt) {
      this.alt = alt;
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
     * Builder method for width parameter.
     * 
     * @param width field to set
     * @return builder
     */
    public Builder withWidth(Integer width) {
      setWidth(width);
      return this;
    }

    /**
     * Builder method for height parameter.
     * 
     * @param height field to set
     * @return builder
     */
    public Builder withHeight(Integer height) {
      setHeight(height);
      return this;
    }

    /**
     * Builder method for alt parameter.
     * 
     * @param alt field to set
     * @return builder
     */
    public Builder withAlt(String alt) {
      setAlt(alt);
      return this;
    }

    /**
     * Builder method of the builder.
     * 
     * @return built class
     */
    public OpenGraphVideo build() {
      return new OpenGraphVideo(this);
    }
  }
}
