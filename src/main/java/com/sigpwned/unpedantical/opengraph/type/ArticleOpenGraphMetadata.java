package com.sigpwned.unpedantical.opengraph.type;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import com.sigpwned.unpedantical.opengraph.OpenGraphAudio;
import com.sigpwned.unpedantical.opengraph.OpenGraphImage;
import com.sigpwned.unpedantical.opengraph.OpenGraphMetadata;
import com.sigpwned.unpedantical.opengraph.OpenGraphVideo;

public class ArticleOpenGraphMetadata extends OpenGraphMetadata {
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

  public ArticleOpenGraphMetadata(String type, String title, String url, String description,
      String determiner, String locale, List<String> alternateLocales, String siteName,
      List<OpenGraphImage> images, List<OpenGraphVideo> videos, List<OpenGraphAudio> audios,
      OffsetDateTime publishedTime, OffsetDateTime modifiedTime, OffsetDateTime expirationTime,
      List<URI> authors, String section, List<String> tags) {
    super(type, title, url, description, determiner, locale, alternateLocales, siteName, images,
        videos, audios);
    this.publishedTime = publishedTime;
    this.modifiedTime = modifiedTime;
    this.expirationTime = expirationTime;
    this.authors = authors!=null && !authors.isEmpty() ? unmodifiableList(authors) : emptyList();
    this.section = section;
    this.tags = tags!=null && !tags.isEmpty() ? unmodifiableList(tags) : emptyList();
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
}
