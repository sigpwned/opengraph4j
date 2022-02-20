package com.sigpwned.unpedantical.opengraph.type.music;

import java.net.URI;
import java.util.Objects;
import java.util.OptionalInt;

public class OpenGraphMusicSong {
  public static OpenGraphMusicSong of(URI song, Integer disc, Integer track) {
    return new OpenGraphMusicSong(song, disc, track);
  }

  /**
   * The song on this album.
   */
  private final URI song;
  
  /**
   * The album this song is from.
   * 
   * The same as music:album:disc but in reverse.
   */
  private final Integer disc;
  
  /**
   * Which track this song is.
   * 
   * The same as music:album:track but in reverse.
   */
  private final Integer track;

  public OpenGraphMusicSong(URI song, Integer disc, Integer track) {
    if (song == null)
      throw new NullPointerException();
    this.song = song;
    this.disc = disc;
    this.track = track;
  }

  public URI getSong() {
    return song;
  }

  public OptionalInt getDisc() {
    return disc != null ? OptionalInt.of(disc) : OptionalInt.empty();
  }

  public OptionalInt getTrack() {
    return track != null ? OptionalInt.of(track) : OptionalInt.empty();
  }

  @Override
  public int hashCode() {
    return Objects.hash(disc, song, track);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    OpenGraphMusicSong other = (OpenGraphMusicSong) obj;
    return Objects.equals(disc, other.disc) && Objects.equals(song, other.song)
        && Objects.equals(track, other.track);
  }

  @Override
  public String toString() {
    return "OpenGraphMusicSong [song=" + song + ", disc=" + disc + ", track=" + track + "]";
  }
}
