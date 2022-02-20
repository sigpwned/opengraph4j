package com.sigpwned.unpedantical.opengraph.type.music;

import java.net.URI;
import java.util.List;
import java.util.Objects;
import com.sigpwned.unpedantical.opengraph.OpenGraphAudio;
import com.sigpwned.unpedantical.opengraph.OpenGraphImage;
import com.sigpwned.unpedantical.opengraph.OpenGraphMetadata;
import com.sigpwned.unpedantical.opengraph.OpenGraphVideo;

public class MusicRadioStationOpenGraphMetadata extends OpenGraphMetadata {
  private final URI creator;

  public MusicRadioStationOpenGraphMetadata(String type, String title, String url,
      String description, String determiner, String locale, List<String> alternateLocales,
      String siteName, List<OpenGraphImage> images, List<OpenGraphVideo> videos,
      List<OpenGraphAudio> audios, Integer duration, URI creator) {
    super(type, title, url, description, determiner, locale, alternateLocales, siteName, images,
        videos, audios);
    this.creator = creator;
  }

  public URI getCreator() {
    return creator;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + Objects.hash(creator);
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
    MusicRadioStationOpenGraphMetadata other = (MusicRadioStationOpenGraphMetadata) obj;
    return Objects.equals(creator, other.creator);
  }

  @Override
  public String toString() {
    return "MusicRadioStationOpenGraphMetadata [creator=" + creator + "]";
  }
}
