# OPENGRAPH4J [![tests](https://github.com/sigpwned/opengraph4j/actions/workflows/tests.yml/badge.svg)](https://github.com/sigpwned/opengraph4j/actions/workflows/tests.yml) [![CodeQL](https://github.com/sigpwned/opengraph4j/actions/workflows/codeql-analysis.yml/badge.svg)](https://github.com/sigpwned/opengraph4j/actions/workflows/codeql-analysis.yml) [![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=sigpwned_opengraph4j&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=sigpwned_opengraph4j)

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

    // You can extract from an existing Jsoup Document instance, too.
    Optional<OpenGraphMetadata> maybeMetadata=OpenGraph.extract(doc);
    if(maybeMetadata.isPresent()) {
      OpenGraphMetadata metadata=maybeMetadata.get();
      System.out.println("This page contains an OpenGraph entity of type "+metadata.getType());
    }
    else {
      System.out.println("This contains no OpenGraph metadata.");
    }
