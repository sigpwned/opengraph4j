package com.sigpwned.unpedantical.opengraph.extractor;

import java.util.Iterator;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.sigpwned.unpedantical.opengraph.type.ProfileOpenGraphMetadata;

public class ProfileExtractor extends ExtractorBase {
  public static final String PROFILE_FIRST_NAME_PROPERTY_NAME = "profile:first_name";

  public static final String PROFILE_LAST_NAME_PROPERTY_NAME = "profile:last_name";

  public static final String PROFILE_USERNAME_PROPERTY_NAME = "profile:username";

  public static final String PROFILE_GENDER_PROPERTY_NAME = "profile:gender";
  
  public ProfileExtractor() {
    super(new ProfileOpenGraphMetadata.Builder());
  }

  public ProfileOpenGraphMetadata extract(Document doc) {
    Elements metas=metadata(doc);
    
    Iterator<Element> iterator = metas.iterator();
    while (iterator.hasNext()) {
      Element element = iterator.next();

      String property = element.attr("property").toLowerCase();
      String content = element.attr("content");

      switch (property) {
        case PROFILE_FIRST_NAME_PROPERTY_NAME:
          getBuilder().setFirstName(content);
          break;
        case PROFILE_LAST_NAME_PROPERTY_NAME:
          getBuilder().setLastName(content);
          break;
        case PROFILE_USERNAME_PROPERTY_NAME:
          getBuilder().setUsername(content);
          break;
        case PROFILE_GENDER_PROPERTY_NAME:
          getBuilder().setGender(content);
          break;
        default:
          handle(property, content);
          break;
      }
    }

    finish();

    return getBuilder().build();
  }
  
  protected ProfileOpenGraphMetadata.Builder getBuilder() {
    return (ProfileOpenGraphMetadata.Builder) super.getBuilder();
  }
}
