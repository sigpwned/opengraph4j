package com.sigpwned.unpedantical.opengraph;

import java.util.Iterator;
import java.util.Optional;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Extractor {
  public static final String OG_TITLE_PROPERTY_NAME="og:title";
  
  public static final String OG_TYPE_PROPERTY_NAME="og:type";
  
  public static final String OG_URL_PROPERTY_NAME="og:url";
  
  public static final String OG_DESCRIPTION_PROPERTY_NAME="og:description";
  
  public static final String OG_DETERMINER_PROPERTY_NAME="og:determiner";
  
  public static final String OG_LOCALE_PROPERTY_NAME="og:locale";
  
  public static final String OG_LOCALE_ALTERNATE_PROPERTY_NAME="og:locale:alternate";
  
  public static final String OG_SITE_NAME_PROPERTY_NAME="og:site_name";
  
  public static final String OG_VIDEO_PROPERTY_NAME="og:video";
  
  public static final String OG_AUDIO_PROPERTY_NAME="og:audio";
  
  public static final String OG_IMAGE_PROPERTY_NAME="og:image";
  
  public Optional<OpenGraphMetadata> extract(Document doc) {
    Elements metas=doc.select("head > meta[property][content]");
    
    Iterator<Element> iterator=metas.iterator();
    while(iterator.hasNext()) {
      Element element=iterator.next();
      
      if(element.attr("property").equals("og:type")) {
      }
    }
  }
}
