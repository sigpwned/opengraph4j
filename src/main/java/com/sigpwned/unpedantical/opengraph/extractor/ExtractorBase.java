package com.sigpwned.unpedantical.opengraph.extractor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sigpwned.unpedantical.opengraph.Extractor;
import com.sigpwned.unpedantical.opengraph.OpenGraphAudio;
import com.sigpwned.unpedantical.opengraph.OpenGraphImage;
import com.sigpwned.unpedantical.opengraph.OpenGraphMetadata;
import com.sigpwned.unpedantical.opengraph.OpenGraphVideo;



public abstract class ExtractorBase {
  protected static final Logger LOGGER = LoggerFactory.getLogger(Extractor.class);

  public static final String OG_TITLE_PROPERTY_NAME = "og:title";
  public static final String OG_TYPE_PROPERTY_NAME = "og:type";
  public static final String OG_URL_PROPERTY_NAME = "og:url";
  public static final String OG_DESCRIPTION_PROPERTY_NAME = "og:description";
  public static final String OG_DETERMINER_PROPERTY_NAME = "og:determiner";
  public static final String OG_LOCALE_PROPERTY_NAME = "og:locale";
  public static final String OG_LOCALE_ALTERNATE_PROPERTY_NAME = "og:locale:alternate";
  public static final String OG_SITE_NAME_PROPERTY_NAME = "og:site_name";
  public static final String OG_VIDEO_PROPERTY_NAME = "og:video";
  public static final String OG_AUDIO_PROPERTY_NAME = "og:audio";
  public static final String OG_IMAGE_PROPERTY_NAME = "og:image";
  public static final String OG_IMAGE_WIDTH_PROPERTY_NAME = "og:image:width";
  public static final String OG_IMAGE_HEIGHT_PROPERTY_NAME = "og:image:height";

  protected OpenGraphVideo.Builder videoBuilder;
  protected OpenGraphAudio.Builder audioBuilder;
  protected OpenGraphImage.Builder imageBuilder;
  protected OpenGraphMetadata.Builder builder;

  public ExtractorBase(OpenGraphMetadata.Builder builder) {
    this.builder = builder;
  }
  
  public abstract OpenGraphMetadata extract(Document doc);

  protected Elements metadata(Document doc) {
    return doc.select("head > meta[property][content]");
  }

  protected void handle(String property, String content) {
    switch (property) {
      case OG_TYPE_PROPERTY_NAME:
        // Skip. We've already handled it above.
        break;
      case OG_TITLE_PROPERTY_NAME:
        getBuilder().setTitle(content);
        break;
      case OG_URL_PROPERTY_NAME:
        getBuilder().setUrl(content);
        break;
      case OG_DESCRIPTION_PROPERTY_NAME:
        getBuilder().setDescription(content);
        break;
      case OG_DETERMINER_PROPERTY_NAME:
        getBuilder().setDeterminer(content);
        break;
      case OG_LOCALE_PROPERTY_NAME:
        getBuilder().setLocale(content);
        break;
      case OG_LOCALE_ALTERNATE_PROPERTY_NAME:
        getBuilder().getAlternateLocales().add(content);
        break;
      case OG_SITE_NAME_PROPERTY_NAME:
        getBuilder().setSiteName(content);
        break;
      case OG_IMAGE_PROPERTY_NAME:
        if (imageBuilder != null)
          getBuilder().getImages().add(imageBuilder.build());
        imageBuilder = OpenGraphImage.builder(content);
        break;
      case OG_IMAGE_WIDTH_PROPERTY_NAME:
        if (imageBuilder != null) {
          Integer width;
          try {
            width = new BigDecimal(content).setScale(0, RoundingMode.DOWN).intValueExact();
          } catch (NumberFormatException | ArithmeticException e) {
            if (LOGGER.isDebugEnabled())
              LOGGER.debug("Ignoring image {} tag {} due to invalid value {}",
                  imageBuilder.getUrl(), property, content);
            width = null;
          }
          imageBuilder.setWidth(width);
        } else {
          if (LOGGER.isDebugEnabled())
            LOGGER.debug("Ignoring tag {} because no image is currently in flight", property);
        }
        break;
      case OG_IMAGE_HEIGHT_PROPERTY_NAME:
        if (imageBuilder != null) {
          Integer height;
          try {
            height = new BigDecimal(content).setScale(0, RoundingMode.DOWN).intValueExact();
          } catch (NumberFormatException | ArithmeticException e) {
            if (LOGGER.isDebugEnabled())
              LOGGER.debug("Ignoring image {} tag {} due to invalid value {}",
                  imageBuilder.getUrl(), property, content);
            height = null;
          }
          imageBuilder.setHeight(height);
        } else {
          if (LOGGER.isDebugEnabled())
            LOGGER.debug("Ignoring tag {} because no image is currently in flight", property);
        }
        break;
      case OG_VIDEO_PROPERTY_NAME:
        if (videoBuilder != null)
          getBuilder().getVideos().add(videoBuilder.build());
        videoBuilder = OpenGraphVideo.builder(content);
        break;
      case OG_AUDIO_PROPERTY_NAME:
        if (audioBuilder != null)
          getBuilder().getAudios().add(audioBuilder.build());
        audioBuilder = OpenGraphAudio.builder(content);
        break;
      default:
        // We don't handle this. That's just fine.
        if(LOGGER.isTraceEnabled())
          LOGGER.trace("Ignoring tag {} because it's not recognized", property);
        break;
    }
  }

  protected void finish() {
    if (imageBuilder != null)
      builder.getImages().add(imageBuilder.build());

    if (videoBuilder != null)
      builder.getVideos().add(videoBuilder.build());

    if (audioBuilder != null)
      builder.getAudios().add(audioBuilder.build());
  }

  protected OpenGraphMetadata.Builder getBuilder() {
    return builder;
  }
}
