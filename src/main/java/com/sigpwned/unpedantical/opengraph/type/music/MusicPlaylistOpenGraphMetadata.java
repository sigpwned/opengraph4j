package com.sigpwned.unpedantical.opengraph.type.music;

import static java.util.Collections.emptyList;
import static java.util.Collections.unmodifiableList;
import java.net.URI;
import java.util.List;
import java.util.Objects;
import com.sigpwned.unpedantical.opengraph.OpenGraphAudio;
import com.sigpwned.unpedantical.opengraph.OpenGraphImage;
import com.sigpwned.unpedantical.opengraph.OpenGraphMetadata;
import com.sigpwned.unpedantical.opengraph.OpenGraphVideo;

public class MusicPlaylistOpenGraphMetadata extends OpenGraphMetadata {
  private final List<OpenGraphMusicSong> songs;
  private final URI creator;

  public MusicPlaylistOpenGraphMetadata(String type, String title, String url, String description,
      String determiner, String locale, List<String> alternateLocales, String siteName,
      List<OpenGraphImage> images, List<OpenGraphVideo> videos, List<OpenGraphAudio> audios,
      Integer duration, List<OpenGraphMusicSong> songs, URI creator) {
    super(type, title, url, description, determiner, locale, alternateLocales, siteName, images,
        videos, audios);
    this.songs = songs != null && !songs.isEmpty() ? unmodifiableList(songs) : emptyList();
    this.creator = creator;
  }

  public List<OpenGraphMusicSong> getSongs() {
    return songs;
  }

  public URI getCreator() {
    return creator;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Objects.hash(creator, songs);
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
    MusicPlaylistOpenGraphMetadata other = (MusicPlaylistOpenGraphMetadata) obj;
    return Objects.equals(creator, other.creator) && Objects.equals(songs, other.songs);
  }

  @Override
  public String toString() {
    return "MusicPlaylistOpenGraphMetadata [songs=" + songs + ", creator=" + creator + "]";
  }
}
