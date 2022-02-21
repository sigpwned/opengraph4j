package com.sigpwned.unpedantical.opengraph.extractor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.sigpwned.unpedantical.opengraph.type.video.OpenGraphVideoActor;
import com.sigpwned.unpedantical.opengraph.type.video.VideoMovieOpenGraphMetadata;

public class VideoMovieExtractor extends ExtractorBase {
  private static final Logger LOGGER = LoggerFactory.getLogger(VideoMovieExtractor.class);

  public static final String VIDEO_ACTOR_PROPERTY_NAME = "video:actor";

  public static final String VIDEO_ACTOR_ROLE_PROPERTY_NAME = "video:actor:role";

  public static final String VIDEO_DIRECTOR_PROPERTY_NAME = "video:director";

  public static final String VIDEO_WRITER_PROPERTY_NAME = "video:writer";

  public static final String VIDEO_DURATION_PROPERTY_NAME = "video:duration";

  public static final String VIDEO_RELEASE_DATE_PROPERTY_NAME = "video:release_date";

  public static final String VIDEO_TAG_PROPERTY_NAME = "video:tag";

  private OpenGraphVideoActor.Builder videoActorBuilder;

  public VideoMovieExtractor() {
    super(new VideoMovieOpenGraphMetadata.Builder());
  }

  public VideoMovieOpenGraphMetadata extract(Document doc) {
    Elements metas = metadata(doc);

    Iterator<Element> iterator = metas.iterator();
    while (iterator.hasNext()) {
      Element element = iterator.next();

      String property = element.attr("property").toLowerCase();
      String content = element.attr("content");

      switch (property) {
        case VIDEO_ACTOR_PROPERTY_NAME:
          if (videoActorBuilder != null)
            getBuilder().getActors().add(videoActorBuilder.build());
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
            getBuilder().getDirectors().add(director);
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
            getBuilder().getWriters().add(writer);
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
            getBuilder().setDuration(duration);
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
            getBuilder().setReleaseDate(releaseDate);
          break;
        case VIDEO_TAG_PROPERTY_NAME:
          getBuilder().getTags().add(content);
          break;
        default:
          handle(property, content);
          break;
      }
    }

    finish();

    return getBuilder().build();
  }

  @Override
  protected VideoMovieOpenGraphMetadata.Builder getBuilder() {
    return (VideoMovieOpenGraphMetadata.Builder) super.getBuilder();
  }
}
