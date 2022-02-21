package com.sigpwned.unpedantical.opengraph;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import java.util.Optional;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sigpwned.unpedantical.opengraph.type.ArticleOpenGraphMetadata;
import com.sigpwned.unpedantical.opengraph.type.WebsiteOpenGraphMetadata;
import com.sigpwned.unpedantical.opengraph.type.video.OpenGraphVideoActor;
import com.sigpwned.unpedantical.opengraph.type.video.VideoMovieOpenGraphMetadata;

public class Extractor {
  private static final Logger LOGGER = LoggerFactory.getLogger(Extractor.class);

  private OpenGraphVideo.Builder videoBuilder = null;
  private OpenGraphAudio.Builder audioBuilder = null;
  private OpenGraphImage.Builder imageBuilder = null;
  private OpenGraphVideoActor.Builder videoActorBuilder = null;

  public Optional<OpenGraphMetadata> extract(Document doc) {
    Elements metas = doc.select("head > meta[property][content]");

    // Per the spec, we should default to website if no value is given
    String type = metas.stream().filter(e -> e.attr("property").equals(OG_TYPE_PROPERTY_NAME))
        .map(e -> e.attr("content")).findFirst().orElse(WebsiteOpenGraphMetadata.TYPE);

    OpenGraphMetadata result;
    switch (type) {
      case ArticleOpenGraphMetadata.TYPE:
        result = extractArticle(metas);
        break;
      case VideoMovieOpenGraphMetadata.TYPE:
        result = extractVideoMovie(metas);
        break;
      // case BookOpenGraphMetadata.TYPE:
      // b = BookOpenGraphMetadata.builder();
      // break;
      // case ProfileOpenGraphMetadata.TYPE:
      // b = ProfileOpenGraphMetadata.builder();
      // break;
      // case WebsiteOpenGraphMetadata.TYPE:
      default:
        // b = WebsiteOpenGraphMetadata.builder();
        result = null;
        break;
    }

    return Optional.ofNullable(result);
  }
  
  // ARTICLE //////////////////////////////////////////////////////////////////
  
  public static final String ARTICLE_PUBLISHED_TIME_PROPERTY_NAME = "article:published_time";

  public static final String ARTICLE_MODIFIED_TIME_PROPERTY_NAME = "article:modified_time";

  public static final String ARTICLE_EXPIRATION_TIME_PROPERTY_NAME = "article:expiration_time";

  public static final String ARTICLE_AUTHOR_PROPERTY_NAME = "article:author";

  public static final String ARTICLE_SECTION_PROPERTY_NAME = "article:section";

  public static final String ARTICLE_TAG_PROPERTY_NAME = "article:tag";

  private ArticleOpenGraphMetadata extractArticle(Elements metas) {
    ArticleOpenGraphMetadata.Builder b = ArticleOpenGraphMetadata.builder();

    Iterator<Element> iterator = metas.iterator();
    while (iterator.hasNext()) {
      Element element = iterator.next();

      String property = element.attr("property").toLowerCase();
      String content = element.attr("content");

      switch (property) {
        case ARTICLE_PUBLISHED_TIME_PROPERTY_NAME:
          OffsetDateTime publishedTime;
          try {
            publishedTime = Instant.parse(content).atOffset(ZoneOffset.UTC);
          } catch (DateTimeParseException e) {
            if (LOGGER.isDebugEnabled())
              LOGGER.debug("Ignoring tag {} due to invalid value {}", property, content);
            publishedTime = null;
          }
          if (publishedTime != null)
            b.setPublishedTime(publishedTime);
          break;
        case ARTICLE_MODIFIED_TIME_PROPERTY_NAME:
          OffsetDateTime modifiedTime;
          try {
            modifiedTime = Instant.parse(content).atOffset(ZoneOffset.UTC);
          } catch (DateTimeParseException e) {
            if (LOGGER.isDebugEnabled())
              LOGGER.debug("Ignoring tag {} due to invalid value {}", property, content);
            modifiedTime = null;
          }
          if (modifiedTime != null)
            b.setModifiedTime(modifiedTime);
          break;
        case ARTICLE_EXPIRATION_TIME_PROPERTY_NAME:
          OffsetDateTime expirationTime;
          try {
            expirationTime = Instant.parse(content).atOffset(ZoneOffset.UTC);
          } catch (DateTimeParseException e) {
            if (LOGGER.isDebugEnabled())
              LOGGER.debug("Ignoring tag {} due to invalid value {}", property, content);
            expirationTime = null;
          }
          if (expirationTime != null)
            b.setModifiedTime(expirationTime);
          break;
        case ARTICLE_AUTHOR_PROPERTY_NAME:
          URI author;
          try {
            author = URI.create(content);
          } catch (IllegalArgumentException e) {
            if (LOGGER.isDebugEnabled())
              LOGGER.debug("Ignoring tag {} due to invalid value {}", property, content);
            author = null;
          }
          if(author != null)
            b.getAuthors().add(author);
          break;
        case ARTICLE_SECTION_PROPERTY_NAME:
          b.setSection(content);
          break;
        case ARTICLE_TAG_PROPERTY_NAME:
          b.getTags().add(content);
          break;
        default:
          handle(b, property, content);
      }
    }

    if (videoBuilder != null)
      b.getVideos().add(videoBuilder.build());

    if (imageBuilder != null)
      b.getImages().add(imageBuilder.build());

    if (audioBuilder != null)
      b.getAudios().add(audioBuilder.build());

    return b.build();
  }

  public static final String VIDEO_ACTOR_PROPERTY_NAME = "video:actor";

  public static final String VIDEO_ACTOR_ROLE_PROPERTY_NAME = "video:actor:role";

  public static final String VIDEO_DIRECTOR_PROPERTY_NAME = "video:director";

  public static final String VIDEO_WRITER_PROPERTY_NAME = "video:writer";

  public static final String VIDEO_DURATION_PROPERTY_NAME = "video:duration";

  public static final String VIDEO_RELEASE_DATE_PROPERTY_NAME = "video:release_date";

  public static final String VIDEO_TAG_PROPERTY_NAME = "video:tag";

  private VideoMovieOpenGraphMetadata extractVideoMovie(Elements metas) {
    VideoMovieOpenGraphMetadata.Builder b = VideoMovieOpenGraphMetadata.builder();

    Iterator<Element> iterator = metas.iterator();
    while (iterator.hasNext()) {
      Element element = iterator.next();

      String property = element.attr("property").toLowerCase();
      String content = element.attr("content");

      switch (property) {
        case VIDEO_ACTOR_PROPERTY_NAME:
          if (videoActorBuilder != null)
            b.getActors().add(videoActorBuilder.build());
          URI actor;
          try {
            actor = URI.create(content);
          } catch (IllegalArgumentException e) {
            if (LOGGER.isDebugEnabled())
              LOGGER.debug("Ignoring tag {} due to invalid value {}", property, content);
            actor = null;
          }
          if (actor != null)
            videoActorBuilder = OpenGraphVideoActor.builder(actor);
          break;
        case VIDEO_ACTOR_ROLE_PROPERTY_NAME:
          if (videoActorBuilder != null) {
            videoActorBuilder.setRole(content);
          } else {
            if (LOGGER.isDebugEnabled())
              LOGGER.debug("Ignoring tag {} because no video actor is currently in flight",
                  property);
          }
        case VIDEO_DIRECTOR_PROPERTY_NAME:
          URI director;
          try {
            director = URI.create(content);
          } catch (IllegalArgumentException e) {
            if (LOGGER.isDebugEnabled())
              LOGGER.debug("Ignoring tag {} due to invalid value {}", property, content);
            director = null;
          }
          if (director != null)
            b.getDirectors().add(director);
          break;
        case VIDEO_WRITER_PROPERTY_NAME:
          URI writer;
          try {
            writer = URI.create(content);
          } catch (IllegalArgumentException e) {
            if (LOGGER.isDebugEnabled())
              LOGGER.debug("Ignoring tag {} due to invalid value {}", property, content);
            writer = null;
          }
          if (writer != null)
            b.getWriters().add(writer);
          break;
        case VIDEO_DURATION_PROPERTY_NAME:
          Integer duration;
          try {
            duration = new BigDecimal(content).setScale(0, RoundingMode.DOWN).intValueExact();
          } catch (IllegalArgumentException | ArithmeticException e) {
            if (LOGGER.isDebugEnabled())
              LOGGER.debug("Ignoring tag {} due to invalid value {}", property, content);
            duration = null;
          }
          if (duration != null)
            b.setDuration(duration);
          break;
        case VIDEO_RELEASE_DATE_PROPERTY_NAME:
          OffsetDateTime releaseDate;
          try {
            releaseDate = Instant.parse(content).atOffset(ZoneOffset.UTC);
          } catch (DateTimeParseException e) {
            if (LOGGER.isDebugEnabled())
              LOGGER.debug("Ignoring tag {} due to invalid value {}", property, content);
            releaseDate = null;
          }
          if (releaseDate != null)
            b.setReleaseDate(releaseDate);
          break;
        case VIDEO_TAG_PROPERTY_NAME:
          b.getTags().add(content);
          break;
        default:
          handle(b, property, content);
      }
    }

    if (videoBuilder != null)
      b.getVideos().add(videoBuilder.build());

    if (imageBuilder != null)
      b.getImages().add(imageBuilder.build());

    if (audioBuilder != null)
      b.getAudios().add(audioBuilder.build());

    if (videoActorBuilder != null)
      b.getActors().add(videoActorBuilder.build());

    return b.build();
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

  private void handle(OpenGraphMetadata.Builder b, String property, String content) {
    switch (property) {
      case OG_TYPE_PROPERTY_NAME:
        // Skip. We've already handled it above.
        break;
      case OG_TITLE_PROPERTY_NAME:
        b.setTitle(content);
        break;
      case OG_URL_PROPERTY_NAME:
        b.setUrl(content);
        break;
      case OG_DESCRIPTION_PROPERTY_NAME:
        b.setDescription(content);
        break;
      case OG_DETERMINER_PROPERTY_NAME:
        b.setDeterminer(content);
        break;
      case OG_LOCALE_PROPERTY_NAME:
        b.setLocale(content);
        break;
      case OG_LOCALE_ALTERNATE_PROPERTY_NAME:
        b.getAlternateLocales().add(content);
        break;
      case OG_SITE_NAME_PROPERTY_NAME:
        b.setSiteName(content);
        break;
      case OG_IMAGE_PROPERTY_NAME:
        if (imageBuilder != null)
          b.getImages().add(imageBuilder.build());
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
          b.getVideos().add(videoBuilder.build());
        videoBuilder = OpenGraphVideo.builder(content);
        break;
      case OG_AUDIO_PROPERTY_NAME:
        if (audioBuilder != null)
          b.getAudios().add(audioBuilder.build());
        audioBuilder = OpenGraphAudio.builder(content);
        break;
      default:
        // We don't handle this.
        break;
    }
  }
}
