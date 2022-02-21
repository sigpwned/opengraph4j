# OPENGRAPH4J [![tests](https://github.com/sigpwned/opengraph4j/actions/workflows/tests.yml/badge.svg)](https://github.com/sigpwned/opengraph4j/actions/workflows/tests.yml)

opengraph4j is an implementation of [the OpenGraph standard](https://ogp.me/) for Java.

# Examples

To extract OpenGraph metadata from an HTML page, use:

    // The html variable is a String containing a full HTML document.
    Optional<OpenGraphMetadata> maybeMetadata=OpenGraph.extract(html);
    if(maybeMetadata.isPresent()) {
      OpenGraphMetadata metadata=maybeMetadata.get();
      System.out.println("This page contains an OpenGraph entity of type "+metadata.getType());
    }
    else {
      System.out.println("This contains no OpenGraph metadata.");
    }

opengraph4j uses the excellent [Jsoup](https://jsoup.org/) library to parse HTML. If your
application uses Jsoup too, then you can use a parsed `Document` instead:

    // Jsoup Document instances are OK, too.
    Optional<OpenGraphMetadata> maybeMetadata=OpenGraph.extract(doc);
    if(maybeMetadata.isPresent()) {
      OpenGraphMetadata metadata=maybeMetadata.get();
      System.out.println("This page contains an OpenGraph entity of type "+metadata.getType());
    }
    else {
      System.out.println("This contains no OpenGraph metadata.");
    }
