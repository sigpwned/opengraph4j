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

public class BookOpenGraphMetadata extends OpenGraphMetadata {
  /**
   * Who wrote this book.
   */
  private final List<URI> authors;
  
  /**
   *The ISBN
   */
  private final String isbn;
  
  /**
   * The date the book was released.
   */
  private final OffsetDateTime releaseDate;
  
  /**
   * Tag words associated with this book.
   */
  private final List<String> tags;

  public BookOpenGraphMetadata(String type, String title, String url, String description,
      String determiner, String locale, List<String> alternateLocales, String siteName,
      List<OpenGraphImage> images, List<OpenGraphVideo> videos, List<OpenGraphAudio> audios,
      List<URI> authors, String isbn, OffsetDateTime releaseDate, List<String> tags) {
    super(type, title, url, description, determiner, locale, alternateLocales, siteName, images,
        videos, audios);
    this.authors = authors!=null && !authors.isEmpty() ? unmodifiableList(authors) : emptyList();
    this.isbn = isbn;
    this.releaseDate = releaseDate;
    this.tags = tags!=null && !tags.isEmpty() ? unmodifiableList(tags) : emptyList();
  }

  public List<URI> getAuthors() {
    return authors;
  }
  
  public Optional<String> getIsbn() {
    return Optional.ofNullable(isbn);
  }

  public Optional<OffsetDateTime> getReleaseDate() {
    return Optional.ofNullable(releaseDate);
  }

  public List<String> getTags() {
    return tags;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Objects.hash(authors, isbn, releaseDate, tags);
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
    BookOpenGraphMetadata other = (BookOpenGraphMetadata) obj;
    return Objects.equals(authors, other.authors) && Objects.equals(isbn, other.isbn)
        && Objects.equals(releaseDate, other.releaseDate) && Objects.equals(tags, other.tags);
  }

  @Override
  public String toString() {
    return "BookOpenGraphMetadata [authors=" + authors + ", isbn=" + isbn + ", releaseDate="
        + releaseDate + ", tags=" + tags + ", getType()=" + getType() + ", getTitle()=" + getTitle()
        + ", getUrl()=" + getUrl() + ", getDescription()=" + getDescription() + ", getDeterminer()="
        + getDeterminer() + ", getLocale()=" + getLocale() + ", getAlternateLocales()="
        + getAlternateLocales() + ", getSiteName()=" + getSiteName() + ", getImages()="
        + getImages() + ", getVideos()=" + getVideos() + ", getAudios()=" + getAudios() + "]";
  }
}
