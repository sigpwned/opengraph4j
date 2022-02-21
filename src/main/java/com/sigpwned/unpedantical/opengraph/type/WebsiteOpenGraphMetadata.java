package com.sigpwned.unpedantical.opengraph.type;

import java.util.List;
import com.sigpwned.unpedantical.opengraph.OpenGraphAudio;
import com.sigpwned.unpedantical.opengraph.OpenGraphImage;
import com.sigpwned.unpedantical.opengraph.OpenGraphMetadata;
import com.sigpwned.unpedantical.opengraph.OpenGraphVideo;

public class WebsiteOpenGraphMetadata extends OpenGraphMetadata {
  public static final String TYPE = "website";

  private WebsiteOpenGraphMetadata(Builder builder) {
    super(builder.getType(), builder.getTitle(), builder.getUrl(), builder.getDescription(),
        builder.getDeterminer(), builder.getLocale(), builder.getAlternateLocales(),
        builder.getSiteName(), builder.getImages(), builder.getVideos(), builder.getAudios());
  }

  public WebsiteOpenGraphMetadata(String title, String url, String description, String determiner,
      String locale, List<String> alternateLocales, String siteName, List<OpenGraphImage> images,
      List<OpenGraphVideo> videos, List<OpenGraphAudio> audios) {
    super(TYPE, title, url, description, determiner, locale, alternateLocales, siteName, images,
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
  
  public Builder toBuilder() {
    return new Builder(this);
  }
  
  public static Builder builder() {
    return new Builder();
  }

  /**
   * Builder to build {@link WebsiteOpenGraphMetadata}.
   */
  public static final class Builder extends OpenGraphMetadata.Builder {
    public Builder() {
      super(TYPE);
    }
    
    private Builder(WebsiteOpenGraphMetadata instance) {
      super(instance);
    }

    /**
     * Builder method of the builder.
     * 
     * @return built class
     */
    public WebsiteOpenGraphMetadata build() {
      return new WebsiteOpenGraphMetadata(this);
    }
  }
}
