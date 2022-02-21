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
import com.sigpwned.unpedantical.opengraph.type.BookOpenGraphMetadata;

public class BookExtractor extends ExtractorBase {
  public static final String BOOK_AUTHOR_PROPERTY_NAME = "book:author";

  public static final String BOOK_ISBN_PROPERTY_NAME = "book:isbn";

  public static final String BOOK_RELEASE_DATE_PROPERTY_NAME = "book:release_date";

  public static final String BOOK_TAG_PROPERTY_NAME = "book:tag";
  
  public BookExtractor() {
    super(new BookOpenGraphMetadata.Builder());
  }

  public BookOpenGraphMetadata extract(Document doc) {
    Elements metas=metadata(doc);
    
    Iterator<Element> iterator = metas.iterator();
    while (iterator.hasNext()) {
      Element element = iterator.next();

      String property = element.attr("property").toLowerCase();
      String content = element.attr("content");

      switch (property) {
        case BOOK_AUTHOR_PROPERTY_NAME:
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
        case BOOK_ISBN_PROPERTY_NAME:
          getBuilder().setIsbn(content);
          break;
        case BOOK_RELEASE_DATE_PROPERTY_NAME:
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
        case BOOK_TAG_PROPERTY_NAME:
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
  
  protected BookOpenGraphMetadata.Builder getBuilder() {
    return (BookOpenGraphMetadata.Builder) super.getBuilder();
  }
}
