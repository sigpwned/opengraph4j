package com.sigpwned.unpedantical.opengraph;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import java.util.List;
import java.util.Objects;
import com.sigpwned.unpedantical.opengraph.util.Determiners;

public abstract class OpenGraphMetadata {
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

  protected OpenGraphMetadata(String type, String title, String url, String description,
      String determiner, String locale, List<String> alternateLocales, String siteName,
      List<OpenGraphImage> images, List<OpenGraphVideo> videos, List<OpenGraphAudio> audios) {
    this.type = type;
    this.title = title;
    this.url = url;
    this.description = description;
    this.determiner = determiner;
    this.locale = locale;
    this.alternateLocales =
        alternateLocales != null && !alternateLocales.isEmpty() ? unmodifiableList(alternateLocales)
            : emptyList();
    this.siteName = siteName;
    this.images = images != null && !images.isEmpty() ? unmodifiableList(images) : emptyList();
    this.videos = videos != null && !videos.isEmpty() ? unmodifiableList(videos) : emptyList();
    this.audios = audios != null && !audios.isEmpty() ? unmodifiableList(audios) : emptyList();
  }

  public String getType() {
    return type;
  }

  public String getTitle() {
    return title;
  }

  public String getUrl() {
    return url;
  }

  public String getDescription() {
    return description;
  }

  public String getDeterminer() {
    return determiner;
  }

  public String getLocale() {
    return locale;
  }

  public List<String> getAlternateLocales() {
    return alternateLocales;
  }

  public String getSiteName() {
    return siteName;
  }

  public List<OpenGraphImage> getImages() {
    return images;
  }

  public List<OpenGraphVideo> getVideos() {
    return videos;
  }

  public List<OpenGraphAudio> getAudios() {
    return audios;
  }

  @Override
  public int hashCode() {
    return Objects.hash(alternateLocales, audios, description, determiner, images, locale, siteName,
        title, type, url, videos);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OpenGraphMetadata other = (OpenGraphMetadata) obj;
    return Objects.equals(alternateLocales, other.alternateLocales)
        && Objects.equals(audios, other.audios) && Objects.equals(description, other.description)
        && Objects.equals(determiner, other.determiner) && Objects.equals(images, other.images)
        && Objects.equals(locale, other.locale) && Objects.equals(siteName, other.siteName)
        && Objects.equals(title, other.title) && Objects.equals(type, other.type)
        && Objects.equals(url, other.url) && Objects.equals(videos, other.videos);
  }

  @Override
  public String toString() {
    return "OpenGraphMetadata [type=" + type + ", title=" + title + ", url=" + url
        + ", description=" + description + ", determiner=" + determiner + ", locale=" + locale
        + ", alternateLocales=" + alternateLocales + ", siteName=" + siteName + ", images=" + images
        + ", videos=" + videos + ", audios=" + audios + "]";
  }
}
