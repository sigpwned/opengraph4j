package com.sigpwned.unpedantical.opengraph.type;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import com.sigpwned.unpedantical.opengraph.OpenGraphAudio;
import com.sigpwned.unpedantical.opengraph.OpenGraphImage;
import com.sigpwned.unpedantical.opengraph.OpenGraphMetadata;
import com.sigpwned.unpedantical.opengraph.OpenGraphVideo;

public class ArticleOpenGraphMetadata extends OpenGraphMetadata {
  public static final String TYPE = "article";

  public static ArticleOpenGraphMetadata of(String title, String url, String description,
      String determiner, String locale, List<String> alternateLocales, String siteName,
      List<OpenGraphImage> images, List<OpenGraphVideo> videos, List<OpenGraphAudio> audios,
      OffsetDateTime publishedTime, OffsetDateTime modifiedTime, OffsetDateTime expirationTime,
      List<URI> authors, String section, List<String> tags) {
    return new ArticleOpenGraphMetadata(title, url, description, determiner, locale,
        alternateLocales, siteName, images, videos, audios, publishedTime, modifiedTime,
        expirationTime, authors, section, tags);
  }

  /**
   * When the article was first published.
   */
  private final OffsetDateTime publishedTime;

  /**
   * When the article was last changed.
   */
  private final OffsetDateTime modifiedTime;

  /**
   * When the article is out of date after.
   */
  private final OffsetDateTime expirationTime;

  /**
   * Writers of the article.
   */
  private final List<URI> authors;

  /**
   * A high-level section name. E.g. Technology
   */
  private final String section;

  /**
   * Tag words associated with this article.
   */
  private final List<String> tags;

  private ArticleOpenGraphMetadata(Builder builder) {
    super(builder.getType(), builder.getTitle(), builder.getUrl(), builder.getDescription(),
        builder.getDeterminer(), builder.getLocale(), builder.getAlternateLocales(),
        builder.getSiteName(), builder.getImages(), builder.getVideos(), builder.getAudios());
    this.publishedTime = builder.publishedTime;
    this.modifiedTime = builder.modifiedTime;
    this.expirationTime = builder.expirationTime;
    this.authors = builder.authors;
    this.section = builder.section;
    this.tags = builder.tags;
  }

  public ArticleOpenGraphMetadata(String title, String url, String description, String determiner,
      String locale, List<String> alternateLocales, String siteName, List<OpenGraphImage> images,
      List<OpenGraphVideo> videos, List<OpenGraphAudio> audios, OffsetDateTime publishedTime,
      OffsetDateTime modifiedTime, OffsetDateTime expirationTime, List<URI> authors, String section,
      List<String> tags) {
    super(TYPE, title, url, description, determiner, locale, alternateLocales, siteName, images,
        videos, audios);
    this.publishedTime = publishedTime;
    this.modifiedTime = modifiedTime;
    this.expirationTime = expirationTime;
    this.authors = authors != null && !authors.isEmpty() ? unmodifiableList(authors) : emptyList();
    this.section = section;
    this.tags = tags != null && !tags.isEmpty() ? unmodifiableList(tags) : emptyList();
  }

  public Optional<OffsetDateTime> getPublishedTime() {
    return Optional.ofNullable(publishedTime);
  }

  public Optional<OffsetDateTime> getModifiedTime() {
    return Optional.ofNullable(modifiedTime);
  }

  public Optional<OffsetDateTime> getExpirationTime() {
    return Optional.ofNullable(expirationTime);
  }

  public List<URI> getAuthors() {
    return authors;
  }

  public Optional<String> getSection() {
    return Optional.ofNullable(section);
  }

  public List<String> getTags() {
    return tags;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result
        + Objects.hash(authors, expirationTime, modifiedTime, publishedTime, section, tags);
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
    ArticleOpenGraphMetadata other = (ArticleOpenGraphMetadata) obj;
    return Objects.equals(authors, other.authors)
        && Objects.equals(expirationTime, other.expirationTime)
        && Objects.equals(modifiedTime, other.modifiedTime)
        && Objects.equals(publishedTime, other.publishedTime)
        && Objects.equals(section, other.section) && Objects.equals(tags, other.tags);
  }

  @Override
  public String toString() {
    return "ArticleOpenGraphMetadata [publishedTime=" + publishedTime + ", modifiedTime="
        + modifiedTime + ", expirationTime=" + expirationTime + ", authors=" + authors
        + ", section=" + section + ", tags=" + tags + ", getType()=" + getType() + ", getTitle()="
        + getTitle() + ", getUrl()=" + getUrl() + ", getDescription()=" + getDescription()
        + ", getDeterminer()=" + getDeterminer() + ", getLocale()=" + getLocale()
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
   * Builder to build {@link ArticleOpenGraphMetadata}.
   */
  public static final class Builder extends OpenGraphMetadata.Builder {
    private OffsetDateTime publishedTime;
    private OffsetDateTime modifiedTime;
    private OffsetDateTime expirationTime;
    private List<URI> authors = Collections.emptyList();
    private String section;
    private List<String> tags = Collections.emptyList();

    public Builder() {
      super(TYPE);
    }

    private Builder(ArticleOpenGraphMetadata instance) {
      super(instance);
      publishedTime = instance.publishedTime;
      modifiedTime = instance.modifiedTime;
      expirationTime = instance.expirationTime;
      authors = instance.authors;
      section = instance.section;
      tags = instance.tags;
    }

    /**
     * @return the publishedTime
     */
    public OffsetDateTime getPublishedTime() {
      return publishedTime;
    }

    /**
     * @param publishedTime the publishedTime to set
     */
    public void setPublishedTime(OffsetDateTime publishedTime) {
      this.publishedTime = publishedTime;
    }

    /**
     * @return the modifiedTime
     */
    public OffsetDateTime getModifiedTime() {
      return modifiedTime;
    }

    /**
     * @param modifiedTime the modifiedTime to set
     */
    public void setModifiedTime(OffsetDateTime modifiedTime) {
      this.modifiedTime = modifiedTime;
    }

    /**
     * @return the expirationTime
     */
    public OffsetDateTime getExpirationTime() {
      return expirationTime;
    }

    /**
     * @param expirationTime the expirationTime to set
     */
    public void setExpirationTime(OffsetDateTime expirationTime) {
      this.expirationTime = expirationTime;
    }

    /**
     * @return the authors
     */
    public List<URI> getAuthors() {
      return authors;
    }

    /**
     * @param authors the authors to set
     */
    public void setAuthors(List<URI> authors) {
      if (authors == null)
        throw new NullPointerException();
      this.authors = authors;
    }

    /**
     * @return the section
     */
    public String getSection() {
      return section;
    }

    /**
     * @param section the section to set
     */
    public void setSection(String section) {
      this.section = section;
    }

    /**
     * @return the tags
     */
    public List<String> getTags() {
      return tags;
    }

    /**
     * @param tags the tags to set
     */
    public void setTags(List<String> tags) {
      if (tags == null)
        throw new NullPointerException();
      this.tags = tags;
    }

    /**
     * Builder method for publishedTime parameter.
     * 
     * @param publishedTime field to set
     * @return builder
     */
    public Builder withPublishedTime(OffsetDateTime publishedTime) {
      setPublishedTime(publishedTime);
      return this;
    }

    /**
     * Builder method for modifiedTime parameter.
     * 
     * @param modifiedTime field to set
     * @return builder
     */
    public Builder withModifiedTime(OffsetDateTime modifiedTime) {
      setModifiedTime(modifiedTime);
      return this;
    }

    /**
     * Builder method for expirationTime parameter.
     * 
     * @param expirationTime field to set
     * @return builder
     */
    public Builder withExpirationTime(OffsetDateTime expirationTime) {
      setExpirationTime(expirationTime);
      return this;
    }

    /**
     * Builder method for authors parameter.
     * 
     * @param authors field to set
     * @return builder
     */
    public Builder withAuthors(List<URI> authors) {
      setAuthors(authors);
      return this;
    }

    /**
     * Builder method for section parameter.
     * 
     * @param section field to set
     * @return builder
     */
    public Builder withSection(String section) {
      setSection(section);
      return this;
    }

    /**
     * Builder method for tags parameter.
     * 
     * @param tags field to set
     * @return builder
     */
    public Builder withTags(List<String> tags) {
      setTags(tags);
      return this;
    }

    /**
     * Builder method of the builder.
     * 
     * @return built class
     */
    public ArticleOpenGraphMetadata build() {
      return new ArticleOpenGraphMetadata(this);
    }
  }
}
