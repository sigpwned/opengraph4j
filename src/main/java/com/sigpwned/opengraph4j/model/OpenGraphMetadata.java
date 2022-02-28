package com.sigpwned.opengraph4j.model;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.sigpwned.opengraph4j.annotation.Generated;
import com.sigpwned.opengraph4j.util.Determiners;

/**
 * The main OpenGraph metadata class. It models all required and optional metadata, but does not
 * model all OpenGraph metadata types. While these "main" metadata are reasonably well-documented
 * and ubiquitous across the web, the more complex types are not in practice.
 * 
 * @see https://ogp.me/
 */
public class OpenGraphMetadata {
  public static OpenGraphMetadata of(String type, String title, String url, String description,
      String determiner, String locale, List<String> alternateLocales, String siteName,
      List<OpenGraphImage> images, List<OpenGraphVideo> videos, List<OpenGraphAudio> audios,
      OffsetDateTime articlePublishedTime, OffsetDateTime articleModifiedTime,
      OffsetDateTime articleExpirationTime, List<String> articleAuthors, String articleSection,
      List<String> articleTags, List<String> bookAuthors, String bookIsbn,
      OffsetDateTime bookReleaseDate, List<String> bookTags, String profileFirstName,
      String profileLastName, String profileUsername, String profileGender) {
    return new OpenGraphMetadata(type, title, url, description, determiner, locale,
        alternateLocales, siteName, images, videos, audios, articlePublishedTime,
        articleModifiedTime, articleExpirationTime, articleAuthors, articleSection, articleTags,
        bookAuthors, bookIsbn, bookReleaseDate, bookTags, profileFirstName, profileLastName,
        profileUsername, profileGender);
  }

  /**
   * The type of your object, e.g., "video.movie". Depending on the type you specify, other
   * properties may also be required.
   */
  private final String type;

  /**
   * The title of your object as it should appear within the graph, e.g., "The Rock".
   */
  private final String title;

  /**
   * The canonical URL of your object that will be used as its permanent ID in the graph, e.g.,
   * "https://www.imdb.com/title/tt0117500/".
   */
  private final String url;

  /**
   * A one to two sentence description of your object.
   */
  private final String description;

  /**
   * The word that appears before this object's title in a sentence. An enum of (a, an, the, "",
   * auto). If auto is chosen, the consumer of your data should chose between "a" or "an". Default
   * is "" (blank).
   * 
   * @see Determiners
   */
  private final String determiner;

  /**
   * The locale these tags are marked up in. Of the format language_TERRITORY. Default is en_US.
   */
  private final String locale;

  /**
   * An array of other locales this page is available in.
   */
  private final List<String> alternateLocales;

  /**
   * If your object is part of a larger web site, the name which should be displayed for the overall
   * site. e.g., "IMDb".
   */
  private final String siteName;

  /**
   * An image URL which should represent your object within the graph.
   */
  private final List<OpenGraphImage> images;

  /**
   * A URL to a video file that complements this object.
   */
  private final List<OpenGraphVideo> videos;

  /**
   * A URL to an audio file to accompany this object.
   */
  private final List<OpenGraphAudio> audios;

  /**
   * When the article was first published.
   */
  private final OffsetDateTime articlePublishedTime;

  /**
   * When the article was last changed.
   */
  private final OffsetDateTime articleModifiedTime;

  /**
   * When the article is out of date after.
   */
  private final OffsetDateTime articleExpirationTime;

  /**
   * Writers of the article.
   */
  private final List<String> articleAuthors;

  /**
   * A high-level section name. E.g. Technology
   */
  private final String articleSection;

  /**
   * Tag words associated with this article.
   */
  private final List<String> articleTags;

  /**
   * Who wrote this book.
   */
  private final List<String> bookAuthors;

  /**
   * The ISBN
   */
  private final String bookIsbn;

  /**
   * The date the book was released.
   */
  private final OffsetDateTime bookReleaseDate;

  /**
   * Tag words associated with this book.
   */
  private final List<String> bookTags;

  /**
   * A name normally given to an individual by a parent or self-chosen.
   */
  private final String profileFirstName;

  /**
   * A name inherited from a family or marriage and by which the individual is commonly known.
   */
  private final String profileLastName;

  /**
   * A short unique string to identify them.
   */
  private final String profileUsername;

  /**
   * Their gender.
   */
  private final String profileGender;

  @Generated("SparkTools")
  private OpenGraphMetadata(Builder builder) {
    this.type = builder.type;
    this.title = builder.title;
    this.url = builder.url;
    this.description = builder.description;
    this.determiner = builder.determiner;
    this.locale = builder.locale;
    this.alternateLocales = builder.alternateLocales;
    this.siteName = builder.siteName;
    this.images = builder.images;
    this.videos = builder.videos;
    this.audios = builder.audios;
    this.articlePublishedTime = builder.articlePublishedTime;
    this.articleModifiedTime = builder.articleModifiedTime;
    this.articleExpirationTime = builder.articleExpirationTime;
    this.articleAuthors = builder.articleAuthors;
    this.articleSection = builder.articleSection;
    this.articleTags = builder.articleTags;
    this.bookAuthors = builder.bookAuthors;
    this.bookIsbn = builder.bookIsbn;
    this.bookReleaseDate = builder.bookReleaseDate;
    this.bookTags = builder.bookTags;
    this.profileFirstName = builder.profileFirstName;
    this.profileLastName = builder.profileLastName;
    this.profileUsername = builder.profileUsername;
    this.profileGender = builder.profileGender;
  }

  public OpenGraphMetadata(String type, String title, String url, String description,
      String determiner, String locale, List<String> alternateLocales, String siteName,
      List<OpenGraphImage> images, List<OpenGraphVideo> videos, List<OpenGraphAudio> audios,
      OffsetDateTime articlePublishedTime, OffsetDateTime articleModifiedTime,
      OffsetDateTime articleExpirationTime, List<String> articleAuthors, String articleSection,
      List<String> articleTags, List<String> bookAuthors, String bookIsbn,
      OffsetDateTime bookReleaseDate, List<String> bookTags, String profileFirstName,
      String profileLastName, String profileUsername, String profileGender) {
    // NOTE: The spec requires type. We do not.
    // NOTE: The spec requires title. We do not.
    // NOTE: The spec requires at least one image. We do not.
    // NOTE: The spec requires a url. We do not.

    this.type = type;
    this.title = title;
    this.url = url;
    this.description = description;
    this.determiner = determiner;
    this.locale = locale;
    this.alternateLocales =
        alternateLocales != null ? unmodifiableList(alternateLocales) : emptyList();
    this.siteName = siteName;
    this.images = images != null ? unmodifiableList(images) : emptyList();
    this.videos = videos != null ? unmodifiableList(videos) : emptyList();
    this.audios = audios != null ? unmodifiableList(audios) : emptyList();
    this.articlePublishedTime = articlePublishedTime;
    this.articleModifiedTime = articleModifiedTime;
    this.articleExpirationTime = articleExpirationTime;
    this.articleAuthors = articleAuthors != null ? unmodifiableList(articleAuthors) : emptyList();
    this.articleSection = articleSection;
    this.articleTags = articleTags != null ? unmodifiableList(articleTags) : emptyList();
    this.bookAuthors = bookAuthors != null ? unmodifiableList(bookAuthors) : emptyList();
    this.bookIsbn = bookIsbn;
    this.bookReleaseDate = bookReleaseDate;
    this.bookTags = bookTags != null ? unmodifiableList(bookTags) : emptyList();
    this.profileFirstName = profileFirstName;
    this.profileLastName = profileLastName;
    this.profileUsername = profileUsername;
    this.profileGender = profileGender;
  }

  /**
   * @return the type
   */
  public String getType() {
    return type;
  }

  /**
   * @return the title
   */
  public String getTitle() {
    return title;
  }

  /**
   * @return the url
   */
  public String getUrl() {
    return url;
  }

  /**
   * @return the description
   */
  public String getDescription() {
    return description;
  }

  /**
   * @return the determiner
   */
  public String getDeterminer() {
    return determiner;
  }

  /**
   * @return the locale
   */
  public String getLocale() {
    return locale;
  }

  /**
   * @return the alternateLocales
   */
  public List<String> getAlternateLocales() {
    return alternateLocales;
  }

  /**
   * @return the siteName
   */
  public String getSiteName() {
    return siteName;
  }

  /**
   * @return the images
   */
  public List<OpenGraphImage> getImages() {
    return images;
  }

  /**
   * @return the videos
   */
  public List<OpenGraphVideo> getVideos() {
    return videos;
  }

  /**
   * @return the audios
   */
  public List<OpenGraphAudio> getAudios() {
    return audios;
  }

  /**
   * @return the articlePublishedTime
   */
  public OffsetDateTime getArticlePublishedTime() {
    return articlePublishedTime;
  }

  /**
   * @return the articleModifiedTime
   */
  public OffsetDateTime getArticleModifiedTime() {
    return articleModifiedTime;
  }

  /**
   * @return the articleExpirationTime
   */
  public OffsetDateTime getArticleExpirationTime() {
    return articleExpirationTime;
  }

  /**
   * @return the articleAuthors
   */
  public List<String> getArticleAuthors() {
    return articleAuthors;
  }

  /**
   * @return the articleSection
   */
  public String getArticleSection() {
    return articleSection;
  }

  /**
   * @return the articleTags
   */
  public List<String> getArticleTags() {
    return articleTags;
  }

  /**
   * @return the bookAuthors
   */
  public List<String> getBookAuthors() {
    return bookAuthors;
  }

  /**
   * @return the bookIsbn
   */
  public String getBookIsbn() {
    return bookIsbn;
  }

  /**
   * @return the bookReleaseDate
   */
  public OffsetDateTime getBookReleaseDate() {
    return bookReleaseDate;
  }

  /**
   * @return the bookTags
   */
  public List<String> getBookTags() {
    return bookTags;
  }

  /**
   * @return the profileFirstName
   */
  public String getProfileFirstName() {
    return profileFirstName;
  }

  /**
   * @return the profileLastName
   */
  public String getProfileLastName() {
    return profileLastName;
  }

  /**
   * @return the profileUsername
   */
  public String getProfileUsername() {
    return profileUsername;
  }

  /**
   * @return the profileGender
   */
  public String getProfileGender() {
    return profileGender;
  }

  @Override
  @Generated("Eclipse")
  public int hashCode() {
    return Objects.hash(alternateLocales, articleAuthors, articleExpirationTime,
        articleModifiedTime, articlePublishedTime, articleSection, articleTags, audios, bookAuthors,
        bookIsbn, bookReleaseDate, bookTags, description, determiner, images, locale,
        profileFirstName, profileGender, profileLastName, profileUsername, siteName, title, type,
        url, videos);
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
    OpenGraphMetadata other = (OpenGraphMetadata) obj;
    return Objects.equals(alternateLocales, other.alternateLocales)
        && Objects.equals(articleAuthors, other.articleAuthors)
        && Objects.equals(articleExpirationTime, other.articleExpirationTime)
        && Objects.equals(articleModifiedTime, other.articleModifiedTime)
        && Objects.equals(articlePublishedTime, other.articlePublishedTime)
        && Objects.equals(articleSection, other.articleSection)
        && Objects.equals(articleTags, other.articleTags) && Objects.equals(audios, other.audios)
        && Objects.equals(bookAuthors, other.bookAuthors)
        && Objects.equals(bookIsbn, other.bookIsbn)
        && Objects.equals(bookReleaseDate, other.bookReleaseDate)
        && Objects.equals(bookTags, other.bookTags)
        && Objects.equals(description, other.description)
        && Objects.equals(determiner, other.determiner) && Objects.equals(images, other.images)
        && Objects.equals(locale, other.locale)
        && Objects.equals(profileFirstName, other.profileFirstName)
        && Objects.equals(profileGender, other.profileGender)
        && Objects.equals(profileLastName, other.profileLastName)
        && Objects.equals(profileUsername, other.profileUsername)
        && Objects.equals(siteName, other.siteName) && Objects.equals(title, other.title)
        && Objects.equals(type, other.type) && Objects.equals(url, other.url)
        && Objects.equals(videos, other.videos);
  }

  @Override
  @Generated("Eclipse")
  public String toString() {
    return "OpenGraphMetadata [type=" + type + ", title=" + title + ", url=" + url
        + ", description=" + description + ", determiner=" + determiner + ", locale=" + locale
        + ", alternateLocales=" + alternateLocales + ", siteName=" + siteName + ", images=" + images
        + ", videos=" + videos + ", audios=" + audios + ", articlePublishedTime="
        + articlePublishedTime + ", articleModifiedTime=" + articleModifiedTime
        + ", articleExpirationTime=" + articleExpirationTime + ", articleAuthors=" + articleAuthors
        + ", articleSection=" + articleSection + ", articleTags=" + articleTags + ", bookAuthors="
        + bookAuthors + ", bookIsbn=" + bookIsbn + ", bookReleaseDate=" + bookReleaseDate
        + ", bookTags=" + bookTags + ", profileFirstName=" + profileFirstName + ", profileLastName="
        + profileLastName + ", profileUsername=" + profileUsername + ", profileGender="
        + profileGender + "]";
  }

  /**
   * Creates a builder from the values of this object
   */
  @Generated("SparkTools")
  public Builder toBuilder() {
    return new Builder(this);
  }

  /**
   * Creates a builder to build {@link OpenGraphMetadata} and initialize it with the given object.
   * 
   * @param openGraphMetadata to initialize the builder with
   * @return created builder
   */
  @Generated("SparkTools")
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link OpenGraphMetadata}.
   */
  @Generated("SparkTools")
  public static final class Builder {
    private String type;
    private String title;
    private String url;
    private String description;
    private String determiner;
    private String locale;
    private List<String> alternateLocales = new ArrayList<>();
    private String siteName;
    private List<OpenGraphImage> images = new ArrayList<>();
    private List<OpenGraphVideo> videos = new ArrayList<>();
    private List<OpenGraphAudio> audios = new ArrayList<>();
    private OffsetDateTime articlePublishedTime;
    private OffsetDateTime articleModifiedTime;
    private OffsetDateTime articleExpirationTime;
    private List<String> articleAuthors = new ArrayList<>();
    private String articleSection;
    private List<String> articleTags = new ArrayList<>();
    private List<String> bookAuthors = new ArrayList<>();
    private String bookIsbn;
    private OffsetDateTime bookReleaseDate;
    private List<String> bookTags = new ArrayList<>();
    private String profileFirstName;
    private String profileLastName;
    private String profileUsername;
    private String profileGender;

    public Builder() {}

    private Builder(OpenGraphMetadata openGraphMetadata) {
      this.type = openGraphMetadata.type;
      this.title = openGraphMetadata.title;
      this.url = openGraphMetadata.url;
      this.description = openGraphMetadata.description;
      this.determiner = openGraphMetadata.determiner;
      this.locale = openGraphMetadata.locale;
      this.alternateLocales = openGraphMetadata.alternateLocales;
      this.siteName = openGraphMetadata.siteName;
      this.images = openGraphMetadata.images;
      this.videos = openGraphMetadata.videos;
      this.audios = openGraphMetadata.audios;
      this.articlePublishedTime = openGraphMetadata.articlePublishedTime;
      this.articleModifiedTime = openGraphMetadata.articleModifiedTime;
      this.articleExpirationTime = openGraphMetadata.articleExpirationTime;
      this.articleAuthors = openGraphMetadata.articleAuthors;
      this.articleSection = openGraphMetadata.articleSection;
      this.articleTags = openGraphMetadata.articleTags;
      this.bookAuthors = openGraphMetadata.bookAuthors;
      this.bookIsbn = openGraphMetadata.bookIsbn;
      this.bookReleaseDate = openGraphMetadata.bookReleaseDate;
      this.bookTags = openGraphMetadata.bookTags;
      this.profileFirstName = openGraphMetadata.profileFirstName;
      this.profileLastName = openGraphMetadata.profileLastName;
      this.profileUsername = openGraphMetadata.profileUsername;
      this.profileGender = openGraphMetadata.profileGender;
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
     * Builder method for title parameter.
     * 
     * @param title field to set
     * @return builder
     */
    public Builder withTitle(String title) {
      setTitle(title);
      return this;
    }

    /**
     * Builder method for url parameter.
     * 
     * @param url field to set
     * @return builder
     */
    public Builder withUrl(String url) {
      setUrl(url);
      return this;
    }

    /**
     * Builder method for description parameter.
     * 
     * @param description field to set
     * @return builder
     */
    public Builder withDescription(String description) {
      setDescription(description);
      return this;
    }

    /**
     * Builder method for determiner parameter.
     * 
     * @param determiner field to set
     * @return builder
     */
    public Builder withDeterminer(String determiner) {
      setDeterminer(determiner);
      return this;
    }

    /**
     * Builder method for locale parameter.
     * 
     * @param locale field to set
     * @return builder
     */
    public Builder withLocale(String locale) {
      setLocale(locale);
      return this;
    }

    /**
     * Builder method for alternateLocales parameter.
     * 
     * @param alternateLocales field to set
     * @return builder
     */
    public Builder withAlternateLocales(List<String> alternateLocales) {
      setAlternateLocales(alternateLocales);
      return this;
    }

    /**
     * Builder method for siteName parameter.
     * 
     * @param siteName field to set
     * @return builder
     */
    public Builder withSiteName(String siteName) {
      setSiteName(siteName);
      return this;
    }

    /**
     * Builder method for images parameter.
     * 
     * @param images field to set
     * @return builder
     */
    public Builder withImages(List<OpenGraphImage> images) {
      setImages(images);
      return this;
    }

    /**
     * Builder method for videos parameter.
     * 
     * @param videos field to set
     * @return builder
     */
    public Builder withVideos(List<OpenGraphVideo> videos) {
      setVideos(videos);
      return this;
    }

    /**
     * Builder method for audios parameter.
     * 
     * @param audios field to set
     * @return builder
     */
    public Builder withAudios(List<OpenGraphAudio> audios) {
      setAudios(audios);
      return this;
    }

    /**
     * Builder method for articlePublishedTime parameter.
     * 
     * @param articlePublishedTime field to set
     * @return builder
     */
    public Builder withArticlePublishedTime(OffsetDateTime articlePublishedTime) {
      setArticlePublishedTime(articlePublishedTime);
      return this;
    }

    /**
     * Builder method for articleModifiedTime parameter.
     * 
     * @param articleModifiedTime field to set
     * @return builder
     */
    public Builder withArticleModifiedTime(OffsetDateTime articleModifiedTime) {
      setArticleModifiedTime(articleModifiedTime);
      return this;
    }

    /**
     * Builder method for articleExpirationTime parameter.
     * 
     * @param articleExpirationTime field to set
     * @return builder
     */
    public Builder withArticleExpirationTime(OffsetDateTime articleExpirationTime) {
      setArticleExpirationTime(articleExpirationTime);
      return this;
    }

    /**
     * Builder method for articleAuthors parameter.
     * 
     * @param articleAuthors field to set
     * @return builder
     */
    public Builder withArticleAuthors(List<String> articleAuthors) {
      setArticleAuthors(articleAuthors);
      return this;
    }

    /**
     * Builder method for articleSection parameter.
     * 
     * @param articleSection field to set
     * @return builder
     */
    public Builder withArticleSection(String articleSection) {
      setArticleSection(articleSection);
      return this;
    }

    /**
     * Builder method for articleTags parameter.
     * 
     * @param articleTags field to set
     * @return builder
     */
    public Builder withArticleTags(List<String> articleTags) {
      setArticleTags(articleTags);
      return this;
    }

    /**
     * Builder method for bookAuthors parameter.
     * 
     * @param bookAuthors field to set
     * @return builder
     */
    public Builder withBookAuthors(List<String> bookAuthors) {
      setBookAuthors(bookAuthors);
      return this;
    }

    /**
     * Builder method for bookIsbn parameter.
     * 
     * @param bookIsbn field to set
     * @return builder
     */
    public Builder withBookIsbn(String bookIsbn) {
      setBookIsbn(bookIsbn);
      return this;
    }

    /**
     * Builder method for bookReleaseDate parameter.
     * 
     * @param bookReleaseDate field to set
     * @return builder
     */
    public Builder withBookReleaseDate(OffsetDateTime bookReleaseDate) {
      setBookReleaseDate(bookReleaseDate);
      return this;
    }

    /**
     * Builder method for bookTags parameter.
     * 
     * @param bookTags field to set
     * @return builder
     */
    public Builder withBookTags(List<String> bookTags) {
      setBookTags(bookTags);
      return this;
    }

    /**
     * Builder method for profileFirstName parameter.
     * 
     * @param profileFirstName field to set
     * @return builder
     */
    public Builder withProfileFirstName(String profileFirstName) {
      setProfileFirstName(profileFirstName);
      return this;
    }

    /**
     * Builder method for profileLastName parameter.
     * 
     * @param profileLastName field to set
     * @return builder
     */
    public Builder withProfileLastName(String profileLastName) {
      setProfileLastName(profileLastName);
      return this;
    }

    /**
     * Builder method for profileUsername parameter.
     * 
     * @param profileUsername field to set
     * @return builder
     */
    public Builder withProfileUsername(String profileUsername) {
      setProfileUsername(profileUsername);
      return this;
    }

    /**
     * Builder method for profileGender parameter.
     * 
     * @param profileGender field to set
     * @return builder
     */
    public Builder withProfileGender(String profileGender) {
      setProfileGender(profileGender);
      return this;
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
     * @return the title
     */
    public String getTitle() {
      return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
      this.title = title;
    }

    /**
     * @return the url
     */
    public String getUrl() {
      return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
      this.url = url;
    }

    /**
     * @return the description
     */
    public String getDescription() {
      return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
      this.description = description;
    }

    /**
     * @return the determiner
     */
    public String getDeterminer() {
      return determiner;
    }

    /**
     * @param determiner the determiner to set
     */
    public void setDeterminer(String determiner) {
      this.determiner = determiner;
    }

    /**
     * @return the locale
     */
    public String getLocale() {
      return locale;
    }

    /**
     * @param locale the locale to set
     */
    public void setLocale(String locale) {
      this.locale = locale;
    }

    /**
     * @return the alternateLocales
     */
    public List<String> getAlternateLocales() {
      return alternateLocales;
    }

    /**
     * @param alternateLocales the alternateLocales to set
     */
    public void setAlternateLocales(List<String> alternateLocales) {
      if (alternateLocales == null)
        throw new NullPointerException();
      this.alternateLocales = alternateLocales;
    }

    /**
     * @return the siteName
     */
    public String getSiteName() {
      return siteName;
    }

    /**
     * @param siteName the siteName to set
     */
    public void setSiteName(String siteName) {
      this.siteName = siteName;
    }

    /**
     * @return the images
     */
    public List<OpenGraphImage> getImages() {
      return images;
    }

    /**
     * @param images the images to set
     */
    public void setImages(List<OpenGraphImage> images) {
      if (images == null)
        throw new NullPointerException();
      this.images = images;
    }

    /**
     * @return the videos
     */
    public List<OpenGraphVideo> getVideos() {
      return videos;
    }

    /**
     * @param videos the videos to set
     */
    public void setVideos(List<OpenGraphVideo> videos) {
      if (videos == null)
        throw new NullPointerException();
      this.videos = videos;
    }

    /**
     * @return the audios
     */
    public List<OpenGraphAudio> getAudios() {
      return audios;
    }

    /**
     * @param audios the audios to set
     */
    public void setAudios(List<OpenGraphAudio> audios) {
      if (audios == null)
        throw new NullPointerException();
      this.audios = audios;
    }

    /**
     * @return the articlePublishedTime
     */
    public OffsetDateTime getArticlePublishedTime() {
      return articlePublishedTime;
    }

    /**
     * @param articlePublishedTime the articlePublishedTime to set
     */
    public void setArticlePublishedTime(OffsetDateTime articlePublishedTime) {
      this.articlePublishedTime = articlePublishedTime;
    }

    /**
     * @return the articleModifiedTime
     */
    public OffsetDateTime getArticleModifiedTime() {
      return articleModifiedTime;
    }

    /**
     * @param articleModifiedTime the articleModifiedTime to set
     */
    public void setArticleModifiedTime(OffsetDateTime articleModifiedTime) {
      this.articleModifiedTime = articleModifiedTime;
    }

    /**
     * @return the articleExpirationTime
     */
    public OffsetDateTime getArticleExpirationTime() {
      return articleExpirationTime;
    }

    /**
     * @param articleExpirationTime the articleExpirationTime to set
     */
    public void setArticleExpirationTime(OffsetDateTime articleExpirationTime) {
      this.articleExpirationTime = articleExpirationTime;
    }

    /**
     * @return the articleAuthors
     */
    public List<String> getArticleAuthors() {
      return articleAuthors;
    }

    /**
     * @param articleAuthors the articleAuthors to set
     */
    public void setArticleAuthors(List<String> articleAuthors) {
      if (articleAuthors == null)
        throw new NullPointerException();
      this.articleAuthors = articleAuthors;
    }

    /**
     * @return the articleSection
     */
    public String getArticleSection() {
      return articleSection;
    }

    /**
     * @param articleSection the articleSection to set
     */
    public void setArticleSection(String articleSection) {
      this.articleSection = articleSection;
    }

    /**
     * @return the articleTags
     */
    public List<String> getArticleTags() {
      return articleTags;
    }

    /**
     * @param articleTags the articleTags to set
     */
    public void setArticleTags(List<String> articleTags) {
      if (articleTags == null)
        throw new NullPointerException();
      this.articleTags = articleTags;
    }

    /**
     * @return the bookAuthors
     */
    public List<String> getBookAuthors() {
      return bookAuthors;
    }

    /**
     * @param bookAuthors the bookAuthors to set
     */
    public void setBookAuthors(List<String> bookAuthors) {
      if (bookAuthors == null)
        throw new NullPointerException();
      this.bookAuthors = bookAuthors;
    }

    /**
     * @return the bookIsbn
     */
    public String getBookIsbn() {
      return bookIsbn;
    }

    /**
     * @param bookIsbn the bookIsbn to set
     */
    public void setBookIsbn(String bookIsbn) {
      this.bookIsbn = bookIsbn;
    }

    /**
     * @return the bookReleaseDate
     */
    public OffsetDateTime getBookReleaseDate() {
      return bookReleaseDate;
    }

    /**
     * @param bookReleaseDate the bookReleaseDate to set
     */
    public void setBookReleaseDate(OffsetDateTime bookReleaseDate) {
      this.bookReleaseDate = bookReleaseDate;
    }

    /**
     * @return the bookTags
     */
    public List<String> getBookTags() {
      return bookTags;
    }

    /**
     * @param bookTags the bookTags to set
     */
    public void setBookTags(List<String> bookTags) {
      this.bookTags = bookTags;
    }

    /**
     * @return the profileFirstName
     */
    public String getProfileFirstName() {
      return profileFirstName;
    }

    /**
     * @param profileFirstName the profileFirstName to set
     */
    public void setProfileFirstName(String profileFirstName) {
      this.profileFirstName = profileFirstName;
    }

    /**
     * @return the profileLastName
     */
    public String getProfileLastName() {
      return profileLastName;
    }

    /**
     * @param profileLastName the profileLastName to set
     */
    public void setProfileLastName(String profileLastName) {
      this.profileLastName = profileLastName;
    }

    /**
     * @return the profileUsername
     */
    public String getProfileUsername() {
      return profileUsername;
    }

    /**
     * @param profileUsername the profileUsername to set
     */
    public void setProfileUsername(String profileUsername) {
      this.profileUsername = profileUsername;
    }

    /**
     * @return the profileGender
     */
    public String getProfileGender() {
      return profileGender;
    }

    /**
     * @param profileGender the profileGender to set
     */
    public void setProfileGender(String profileGender) {
      this.profileGender = profileGender;
    }

    /**
     * Builder method of the builder.
     * 
     * @return built class
     */
    public OpenGraphMetadata build() {
      return new OpenGraphMetadata(this);
    }
  }
}
