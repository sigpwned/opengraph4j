/*-
 * =================================LICENSE_START==================================
 * opengraph4j
 * ====================================SECTION=====================================
 * Copyright (C) 2022 Andy Boothe
 * ====================================SECTION=====================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ==================================LICENSE_END===================================
 */
package com.sigpwned.opengraph4j.util;

import java.util.Optional;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import com.sigpwned.opengraph4j.OpenGraphExtractor;
import com.sigpwned.opengraph4j.model.OpenGraphMetadata;

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
