package com.sigpwned.opengraph4j.util;

import java.util.Optional;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import com.sigpwned.opengraph4j.OpenGraphExtractor;
import com.sigpwned.opengraph4j.OpenGraphMetadata;

/**
 * OpenGraph helper methods
 */
public final class OpenGraph {
  private OpenGraph() {}
  
  /**
   * Extract OpenGraph metadata from an HTML document
   */
  public static Optional<OpenGraphMetadata> extract(String doc) {
    return extract(Jsoup.parse(doc));
  }
  
  /**
   * Extract OpenGraph metadata from a parsed HTML document
   */
  public static Optional<OpenGraphMetadata> extract(Document doc) {
    return new OpenGraphExtractor().extract(doc);
  }
}
