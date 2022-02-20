package com.sigpwned.unpedantical.opengraph.type;

import java.util.List;
import com.sigpwned.unpedantical.opengraph.OpenGraphAudio;
import com.sigpwned.unpedantical.opengraph.OpenGraphImage;
import com.sigpwned.unpedantical.opengraph.OpenGraphMetadata;
import com.sigpwned.unpedantical.opengraph.OpenGraphVideo;

public class WebsiteOpenGraphMetadata extends OpenGraphMetadata {
  public WebsiteOpenGraphMetadata(String type, String title, String url, String description,
      String determiner, String locale, List<String> alternateLocales, String siteName,
      List<OpenGraphImage> images, List<OpenGraphVideo> videos, List<OpenGraphAudio> audios) {
    super(type, title, url, description, determiner, locale, alternateLocales, siteName, images,
        videos, audios);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "WebsiteOpenGraphMetadata [getType()=" + getType() + ", getTitle()=" + getTitle()
        + ", getUrl()=" + getUrl() + ", getDescription()=" + getDescription() + ", getDeterminer()="
        + getDeterminer() + ", getLocale()=" + getLocale() + ", getAlternateLocales()="
        + getAlternateLocales() + ", getSiteName()=" + getSiteName() + ", getImages()="
        + getImages() + ", getVideos()=" + getVideos() + ", getAudios()=" + getAudios() + "]";
  }
}
