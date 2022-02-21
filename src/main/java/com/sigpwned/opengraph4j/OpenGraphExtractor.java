package com.sigpwned.opengraph4j;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Predicate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Extracts {@link OpenGraphMetadata} from a parsed HTML document. This object is not thread-safe,
 * but can be reused.
 */
public class OpenGraphExtractor {
  private static final Logger LOGGER = LoggerFactory.getLogger(OpenGraphExtractor.class);

  private OpenGraphVideo.Builder videoBuilder;
  private OpenGraphAudio.Builder audioBuilder;
  private OpenGraphImage.Builder imageBuilder;
  private OpenGraphMetadata.Builder builder;

  public Optional<OpenGraphMetadata> extract(Document doc) {
    Elements metas = doc.select("head > meta[property][content]");

    String type =
        Optional.ofNullable(metas.select("[property=og:type]").first()).map(e -> e.attr("content"))
            .map(String::strip).filter(Predicate.not(String::isEmpty)).orElse(null);

    OpenGraphMetadata result;
    if (type != null) {
      builder = OpenGraphMetadata.builder(type);

      Iterator<Element> iterator = metas.iterator();
      while (iterator.hasNext()) {
        Element element = iterator.next();

        String property = element.attr("property").toLowerCase();
        String content = element.attr("content");

        metadata(property, content);
      }

      if (imageBuilder != null)
        builder.getImages().add(imageBuilder.build());

      if (videoBuilder != null)
        builder.getVideos().add(videoBuilder.build());

      if (audioBuilder != null)
        builder.getAudios().add(audioBuilder.build());

      result = builder.build();

      imageBuilder = null;
      videoBuilder = null;
      audioBuilder = null;
      builder = null;
    } else {
      result = null;
    }

    return Optional.ofNullable(result);
  }

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

  private void metadata(String property, String content) {
    switch (property) {
      case OG_TYPE_PROPERTY_NAME:
        // Skip. We've already handled it above.
        break;
      case OG_TITLE_PROPERTY_NAME:
        builder.setTitle(content);
        break;
      case OG_URL_PROPERTY_NAME:
        builder.setUrl(content);
        break;
      case OG_DESCRIPTION_PROPERTY_NAME:
        builder.setDescription(content);
        break;
      case OG_DETERMINER_PROPERTY_NAME:
        builder.setDeterminer(content);
        break;
      case OG_LOCALE_PROPERTY_NAME:
        builder.setLocale(content);
        break;
      case OG_LOCALE_ALTERNATE_PROPERTY_NAME:
        builder.getAlternateLocales().add(content);
        break;
      case OG_SITE_NAME_PROPERTY_NAME:
        builder.setSiteName(content);
        break;
      case OG_IMAGE_PROPERTY_NAME:
        if (imageBuilder != null)
          builder.getImages().add(imageBuilder.build());
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
          builder.getVideos().add(videoBuilder.build());
        videoBuilder = OpenGraphVideo.builder(content);
        break;
      case OG_AUDIO_PROPERTY_NAME:
        if (audioBuilder != null)
          builder.getAudios().add(audioBuilder.build());
        audioBuilder = OpenGraphAudio.builder(content);
        break;
      default:
        // We don't handle this.
        break;
    }
  }
}
