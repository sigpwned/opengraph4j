package com.sigpwned.unpedantical.opengraph.type.music;

import java.net.URI;
import java.util.Objects;
import java.util.OptionalInt;

public class OpenGraphMusicAlbum {
  public static OpenGraphMusicAlbum of(URI song, Integer disc, Integer track) {
    return new OpenGraphMusicAlbum(song, disc, track);
  }

  /**
   * The album this song is from.
   */
  private final URI album;
  
  /**
   * Which disc of the album this song is on.
   */
  private final Integer disc;
  
  /**
   * Which track this song is.
   */
  private final Integer track;

  public OpenGraphMusicAlbum(URI song, Integer disc, Integer track) {
    if (song == null)
      throw new NullPointerException();
    this.album = song;
    this.disc = disc;
    this.track = track;
  }

  public URI getSong() {
    return album;
  }

  public OptionalInt getDisc() {
    return disc != null ? OptionalInt.of(disc) : OptionalInt.empty();
  }

  public OptionalInt getTrack() {
    return track != null ? OptionalInt.of(track) : OptionalInt.empty();
  }

  @Override
  public int hashCode() {
    return Objects.hash(disc, album, track);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OpenGraphMusicAlbum other = (OpenGraphMusicAlbum) obj;
    return Objects.equals(disc, other.disc) && Objects.equals(album, other.album)
        && Objects.equals(track, other.track);
  }

  @Override
  public String toString() {
    return "OpenGraphMusicSong [song=" + album + ", disc=" + disc + ", track=" + track + "]";
  }
}
