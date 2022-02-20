package com.sigpwned.unpedantical.opengraph.type.music;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;
import com.sigpwned.unpedantical.opengraph.OpenGraphAudio;
import com.sigpwned.unpedantical.opengraph.OpenGraphImage;
import com.sigpwned.unpedantical.opengraph.OpenGraphMetadata;
import com.sigpwned.unpedantical.opengraph.OpenGraphVideo;

public class MusicSongOpenGraphMetadata extends OpenGraphMetadata {
  private final Integer duration;
  private final List<OpenGraphMusicAlbum> albums;
  private final List<URI> musicians;
  
  public MusicSongOpenGraphMetadata(String type, String title, String url, String description,
      String determiner, String locale, List<String> alternateLocales, String siteName,
      List<OpenGraphImage> images, List<OpenGraphVideo> videos, List<OpenGraphAudio> audios,
      Integer duration, List<OpenGraphMusicAlbum> albums, List<URI> musicians) {
    super(type, title, url, description, determiner, locale, alternateLocales, siteName, images,
        videos, audios);
    this.duration = duration;
    this.albums = albums != null && !albums.isEmpty() ? unmodifiableList(albums) : emptyList();
    this.musicians = musicians !=null && !musicians.isEmpty() ? unmodifiableList(musicians) : emptyList();
  }

  public OptionalInt getDuration() {
    return duration != null ? OptionalInt.of(duration) : OptionalInt.empty();
  }

  public List<OpenGraphMusicAlbum> getAlbums() {
    return albums;
  }

  public List<URI> getMusicians() {
    return musicians;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Objects.hash(albums, duration, musicians);
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
    MusicSongOpenGraphMetadata other = (MusicSongOpenGraphMetadata) obj;
    return Objects.equals(albums, other.albums) && Objects.equals(duration, other.duration)
        && Objects.equals(musicians, other.musicians);
  }

  @Override
  public String toString() {
    return "MusicSongOpenGraphMetadata [duration=" + duration + ", albums=" + albums
        + ", musicians=" + musicians + "]";
  }
}
