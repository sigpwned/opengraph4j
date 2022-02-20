package com.sigpwned.unpedantical.opengraph.type.music;

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

public class MusicAlbumOpenGraphMetadata extends OpenGraphMetadata {
  private final List<OpenGraphMusicSong> songs;
  private final List<URI> musicians;
  private final OffsetDateTime releaseDate;
  
  public MusicAlbumOpenGraphMetadata(String type, String title, String url, String description,
      String determiner, String locale, List<String> alternateLocales, String siteName,
      List<OpenGraphImage> images, List<OpenGraphVideo> videos, List<OpenGraphAudio> audios,
      Integer duration, List<OpenGraphMusicSong> songs, List<URI> musicians, OffsetDateTime releaseDate) {
    super(type, title, url, description, determiner, locale, alternateLocales, siteName, images,
        videos, audios);
    this.songs = songs != null && !songs.isEmpty() ? unmodifiableList(songs) : emptyList();
    this.musicians = musicians !=null && !musicians.isEmpty() ? unmodifiableList(musicians) : emptyList();
    this.releaseDate = releaseDate;
  }

  public List<OpenGraphMusicSong> getSongs() {
    return songs;
  }

  public List<URI> getMusicians() {
    return musicians;
  }
  
  public Optional<OffsetDateTime> getReleaseDate() {
    return Optional.ofNullable(releaseDate);
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Objects.hash(musicians, releaseDate, songs);
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
    MusicAlbumOpenGraphMetadata other = (MusicAlbumOpenGraphMetadata) obj;
    return Objects.equals(musicians, other.musicians)
        && Objects.equals(releaseDate, other.releaseDate) && Objects.equals(songs, other.songs);
  }

  @Override
  public String toString() {
    return "MusicAlbumOpenGraphMetadata [songs=" + songs + ", musicians=" + musicians
        + ", releaseDate=" + releaseDate + "]";
  }
}
