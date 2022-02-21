package com.sigpwned.unpedantical.opengraph.type.video;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import com.sigpwned.unpedantical.opengraph.OpenGraphAudio;
import com.sigpwned.unpedantical.opengraph.OpenGraphImage;
import com.sigpwned.unpedantical.opengraph.OpenGraphMetadata;
import com.sigpwned.unpedantical.opengraph.OpenGraphVideo;

public class VideoMovieOpenGraphMetadata extends OpenGraphMetadata {
  public static final String TYPE = "video.movie";

  public static VideoMovieOpenGraphMetadata of(String title, String url, String description,
      String determiner, String locale, List<String> alternateLocales, String siteName,
      List<OpenGraphImage> images, List<OpenGraphVideo> videos, List<OpenGraphAudio> audios,
      List<OpenGraphVideoActor> actors, List<URI> directors, List<URI> writers, Integer duration,
      OffsetDateTime releaseDate, List<String> tags) {
    return new VideoMovieOpenGraphMetadata(title, url, description, determiner, locale,
        alternateLocales, siteName, images, videos, audios, actors, directors, writers, duration,
        releaseDate, tags);
  }

  private final List<OpenGraphVideoActor> actors;
  private final List<URI> directors;
  private final List<URI> writers;
  private final Integer duration;
  private final OffsetDateTime releaseDate;
  private final List<String> tags;

  private VideoMovieOpenGraphMetadata(Builder builder) {
    super(TYPE, builder.getTitle(), builder.getUrl(), builder.getDescription(),
        builder.getDeterminer(), builder.getLocale(), builder.getAlternateLocales(),
        builder.getSiteName(), builder.getImages(), builder.getVideos(), builder.getAudios());
    this.actors = builder.actors;
    this.directors = builder.directors;
    this.writers = builder.writers;
    this.duration = builder.duration;
    this.releaseDate = builder.releaseDate;
    this.tags = builder.tags;
  }

  public VideoMovieOpenGraphMetadata(String title, String url, String description,
      String determiner, String locale, List<String> alternateLocales, String siteName,
      List<OpenGraphImage> images, List<OpenGraphVideo> videos, List<OpenGraphAudio> audios,
      List<OpenGraphVideoActor> actors, List<URI> directors, List<URI> writers, Integer duration,
      OffsetDateTime releaseDate, List<String> tags) {
    super(TYPE, title, url, description, determiner, locale, alternateLocales, siteName, images,
        videos, audios);
    this.actors = actors != null && !actors.isEmpty() ? unmodifiableList(actors) : emptyList();
    this.directors =
        directors != null && !directors.isEmpty() ? unmodifiableList(directors) : emptyList();
    this.writers = writers != null && !writers.isEmpty() ? unmodifiableList(writers) : emptyList();
    this.duration = duration;
    this.releaseDate = releaseDate;
    this.tags = tags != null && !tags.isEmpty() ? unmodifiableList(tags) : emptyList();
  }

  public List<OpenGraphVideoActor> getActors() {
    return actors;
  }

  public List<URI> getDirectors() {
    return directors;
  }

  public List<URI> getWriters() {
    return writers;
  }

  public OptionalInt getDuration() {
    return duration != null ? OptionalInt.of(duration) : OptionalInt.empty();
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
    result = prime * result + Objects.hash(actors, directors, duration, releaseDate, tags, writers);
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
    VideoMovieOpenGraphMetadata other = (VideoMovieOpenGraphMetadata) obj;
    return Objects.equals(actors, other.actors) && Objects.equals(directors, other.directors)
        && Objects.equals(duration, other.duration)
        && Objects.equals(releaseDate, other.releaseDate) && Objects.equals(tags, other.tags)
        && Objects.equals(writers, other.writers);
  }

  @Override
  public String toString() {
    return "VideoMovieOpenGraphMetadata [actors=" + actors + ", directors=" + directors
        + ", writers=" + writers + ", duration=" + duration + ", releaseDate=" + releaseDate
        + ", tags=" + tags + ", getType()=" + getType() + ", getTitle()=" + getTitle()
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
   * Builder to build {@link VideoMovieOpenGraphMetadata}.
   */
  public static final class Builder extends OpenGraphMetadata.Builder {
    private List<OpenGraphVideoActor> actors = new ArrayList<>();
    private List<URI> directors = new ArrayList<>();
    private List<URI> writers = new ArrayList<>();
    private Integer duration;
    private OffsetDateTime releaseDate;
    private List<String> tags = new ArrayList<>();

    public Builder() {
      super(TYPE);
    }

    private Builder(VideoMovieOpenGraphMetadata m) {
      super(m);
      actors = new ArrayList<>(m.actors);
      directors = new ArrayList<>(m.directors);
      writers = new ArrayList<>(m.writers);
      duration = m.duration;
      releaseDate = m.releaseDate;
      tags = new ArrayList<>(m.tags);
    }

    /**
     * @return the actors
     */
    public List<OpenGraphVideoActor> getActors() {
      return actors;
    }

    /**
     * @param actors the actors to set
     */
    public void setActors(List<OpenGraphVideoActor> actors) {
      this.actors = actors;
    }

    /**
     * @return the directors
     */
    public List<URI> getDirectors() {
      return directors;
    }

    /**
     * @param directors the directors to set
     */
    public void setDirectors(List<URI> directors) {
      this.directors = directors;
    }

    /**
     * @return the writers
     */
    public List<URI> getWriters() {
      return writers;
    }

    /**
     * @param writers the writers to set
     */
    public void setWriters(List<URI> writers) {
      this.writers = writers;
    }

    /**
     * @return the duration
     */
    public Integer getDuration() {
      return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(Integer duration) {
      this.duration = duration;
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
      this.tags = tags;
    }

    /**
     * Builder method for actors parameter.
     * 
     * @param actors field to set
     * @return builder
     */
    public Builder withActors(List<OpenGraphVideoActor> actors) {
      setActors(actors);
      return this;
    }

    /**
     * Builder method for directors parameter.
     * 
     * @param directors field to set
     * @return builder
     */
    public Builder withDirectors(List<URI> directors) {
      setDirectors(directors);
      return this;
    }

    /**
     * Builder method for writers parameter.
     * 
     * @param writers field to set
     * @return builder
     */
    public Builder withWriters(List<URI> writers) {
      setWriters(writers);
      return this;
    }

    /**
     * Builder method for duration parameter.
     * 
     * @param duration field to set
     * @return builder
     */
    public Builder withDuration(Integer duration) {
      setDuration(duration);
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
    public VideoMovieOpenGraphMetadata build() {
      return new VideoMovieOpenGraphMetadata(this);
    }
  }
}
