package com.sigpwned.unpedantical.opengraph.extractor;

import java.net.URI;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;
import java.util.Iterator;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.sigpwned.unpedantical.opengraph.type.ArticleOpenGraphMetadata;

public class ArticleExtractor extends ExtractorBase {
  public static final String ARTICLE_PUBLISHED_TIME_PROPERTY_NAME = "article:published_time";

  public static final String ARTICLE_MODIFIED_TIME_PROPERTY_NAME = "article:modified_time";

  public static final String ARTICLE_EXPIRATION_TIME_PROPERTY_NAME = "article:expiration_time";

  public static final String ARTICLE_AUTHOR_PROPERTY_NAME = "article:author";

  public static final String ARTICLE_SECTION_PROPERTY_NAME = "article:section";

  public static final String ARTICLE_TAG_PROPERTY_NAME = "article:tag";
  
  
  
  public ArticleExtractor() {
    super(new ArticleOpenGraphMetadata.Builder());
  }

  public ArticleOpenGraphMetadata extract(Document doc) {
    Elements metas=metadata(doc);
    
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
            getBuilder().setPublishedTime(publishedTime);
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
            getBuilder().setModifiedTime(modifiedTime);
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
            getBuilder().setModifiedTime(expirationTime);
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
            getBuilder().getAuthors().add(author);
          break;
        case ARTICLE_SECTION_PROPERTY_NAME:
          getBuilder().setSection(content);
          break;
        case ARTICLE_TAG_PROPERTY_NAME:
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
  
  protected ArticleOpenGraphMetadata.Builder getBuilder() {
    return (ArticleOpenGraphMetadata.Builder) super.getBuilder();
  }
}
