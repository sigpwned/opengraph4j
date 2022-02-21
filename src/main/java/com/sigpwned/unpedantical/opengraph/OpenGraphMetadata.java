package com.sigpwned.unpedantical.opengraph;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.sigpwned.unpedantical.opengraph.util.Determiners;

/**
 * @see ogp.me
 */
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
    if (type == null)
      throw new IllegalArgumentException("no type");
    if (title == null)
      throw new IllegalArgumentException("no title");
    if (images == null || images.isEmpty())
      throw new IllegalArgumentException("no image");
    if (url == null)
      throw new IllegalArgumentException("no url");
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

  /**
   * Builder to build {@link OpenGraphMetadata}.
   */
  public static class Builder {
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

    public Builder(String type) {
      if (type == null)
        throw new NullPointerException();
      this.type = type;
    }
    
    protected Builder(OpenGraphMetadata instance) {
      type = instance.type;
      title = instance.title;
      url = instance.url;
      description = instance.description;
      determiner = instance.determiner;
      locale = instance.locale;
      alternateLocales = instance.alternateLocales;
      siteName = instance.siteName;
      images = instance.images;
      videos = instance.videos;
      audios = instance.audios;
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
  }
}
