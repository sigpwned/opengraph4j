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

public class BookOpenGraphMetadata extends OpenGraphMetadata {
  public static final String TYPE = "book";

  /**
   * Who wrote this book.
   */
  private final List<URI> authors;

  /**
   * The ISBN
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

  private BookOpenGraphMetadata(Builder builder) {
    super(builder.getType(), builder.getTitle(), builder.getUrl(), builder.getDescription(),
        builder.getDeterminer(), builder.getLocale(), builder.getAlternateLocales(),
        builder.getSiteName(), builder.getImages(), builder.getVideos(), builder.getAudios());
    this.authors = builder.authors;
    this.isbn = builder.isbn;
    this.releaseDate = builder.releaseDate;
    this.tags = builder.tags;
  }

  public BookOpenGraphMetadata(String title, String url, String description, String determiner,
      String locale, List<String> alternateLocales, String siteName, List<OpenGraphImage> images,
      List<OpenGraphVideo> videos, List<OpenGraphAudio> audios, List<URI> authors, String isbn,
      OffsetDateTime releaseDate, List<String> tags) {
    super(TYPE, title, url, description, determiner, locale, alternateLocales, siteName, images,
        videos, audios);
    this.authors = authors != null && !authors.isEmpty() ? unmodifiableList(authors) : emptyList();
    this.isbn = isbn;
    this.releaseDate = releaseDate;
    this.tags = tags != null && !tags.isEmpty() ? unmodifiableList(tags) : emptyList();
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

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link BookOpenGraphMetadata}.
   */
  public static final class Builder extends OpenGraphMetadata.Builder {
    private List<URI> authors = Collections.emptyList();
    private String isbn;
    private OffsetDateTime releaseDate;
    private List<String> tags = Collections.emptyList();

    public Builder() {
      super(TYPE);
    }

    private Builder(BookOpenGraphMetadata instance) {
      super(instance);
      authors = instance.authors;
      isbn = instance.isbn;
      releaseDate = instance.releaseDate;
      tags = instance.tags;
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
     * @return the isbn
     */
    public String getIsbn() {
      return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
      this.isbn = isbn;
    }

    /**
     * @return the releaseDate
     */
    public OffsetDateTime getReleaseDate() {
      return releaseDate;
    }

    /**
     * @param releaseDate the releaseDate to set
     */
    public void setReleaseDate(OffsetDateTime releaseDate) {
      this.releaseDate = releaseDate;
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
     * Builder method for isbn parameter.
     * 
     * @param isbn field to set
     * @return builder
     */
    public Builder withIsbn(String isbn) {
      setIsbn(isbn);
      return this;
    }

    /**
     * Builder method for releaseDate parameter.
     * 
     * @param releaseDate field to set
     * @return builder
     */
    public Builder withReleaseDate(OffsetDateTime releaseDate) {
      setReleaseDate(releaseDate);
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
    public BookOpenGraphMetadata build() {
      return new BookOpenGraphMetadata(this);
    }
  }
}
