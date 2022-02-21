package com.sigpwned.unpedantical.opengraph.extractor;

import java.util.Iterator;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import com.sigpwned.unpedantical.opengraph.type.ProfileOpenGraphMetadata;
import com.sigpwned.unpedantical.opengraph.type.WebsiteOpenGraphMetadata;

public class WebsiteExtractor extends ExtractorBase {
  public WebsiteExtractor() {
    super(new WebsiteOpenGraphMetadata.Builder());
  }

  public ProfileOpenGraphMetadata extract(Document doc) {
    Elements metas=metadata(doc);
    
    Iterator<Element> iterator = metas.iterator();
    while (iterator.hasNext()) {
      Element element = iterator.next();

      String property = element.attr("property").toLowerCase();
      String content = element.attr("content");

      switch (property) {
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
