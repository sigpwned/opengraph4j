package com.sigpwned.unpedantical.opengraph.type.video;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import java.net.URI;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import com.sigpwned.unpedantical.opengraph.OpenGraphAudio;
import com.sigpwned.unpedantical.opengraph.OpenGraphImage;
import com.sigpwned.unpedantical.opengraph.OpenGraphMetadata;
import com.sigpwned.unpedantical.opengraph.OpenGraphVideo;

public class VideoOtherOpenGraphMetadata extends OpenGraphMetadata {
  private final List<OpenGraphVideoActor> actors;
  private final List<URI> directors;
  private final List<URI> writers;
  private final Integer duration;
  private final OffsetDateTime releaseDate;
  private final List<String> tags;

  public VideoOtherOpenGraphMetadata(String type, String title, String url, String description,
      String determiner, String locale, List<String> alternateLocales, String siteName,
      List<OpenGraphImage> images, List<OpenGraphVideo> videos, List<OpenGraphAudio> audios,
      List<OpenGraphVideoActor> actors, List<URI> directors, List<URI> writers, Integer duration,
      OffsetDateTime releaseDate, List<String> tags) {
    super(type, title, url, description, determiner, locale, alternateLocales, siteName, images,
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
    VideoOtherOpenGraphMetadata other = (VideoOtherOpenGraphMetadata) obj;
    return Objects.equals(actors, other.actors) && Objects.equals(directors, other.directors)
        && Objects.equals(duration, other.duration)
        && Objects.equals(releaseDate, other.releaseDate) && Objects.equals(tags, other.tags)
        && Objects.equals(writers, other.writers);
  }

  @Override
  public String toString() {
    return "VideoMovieOpenGraphMetadata [actors=" + actors + ", directors=" + directors
        + ", writers=" + writers + ", duration=" + duration + ", releaseDate=" + releaseDate
        + ", tags=" + tags + "]";
  }
}
