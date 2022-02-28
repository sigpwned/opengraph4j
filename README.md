# OPENGRAPH4J [![tests](https://github.com/sigpwned/opengraph4j/actions/workflows/tests.yml/badge.svg)](https://github.com/sigpwned/opengraph4j/actions/workflows/tests.yml) [![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=sigpwned_opengraph4j&metric=security_rating)](https://sonarcloud.io/summary/new_code?id=sigpwned_opengraph4j) [![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=sigpwned_opengraph4j&metric=sqale_rating)](https://sonarcloud.io/summary/new_code?id=sigpwned_opengraph4j) [![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=sigpwned_opengraph4j&metric=reliability_rating)](https://sonarcloud.io/summary/new_code?id=sigpwned_opengraph4j) [![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.sigpwned/opengraph4j/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.sigpwned/opengraph4j)


opengraph4j is an implementation of [the OpenGraph standard](https://ogp.me/) for Java.

## Goals

* To provide a high-level library for accessing the most commonly-used OpenGraph attributes.

## Non-Goals

* To provide a low-level library to help people roll their own OpenGraph capabilities. There are plenty of good libraries to do that, e.g. [opengraph-java](https://github.com/johndeverall/opengraph-java).
* To provide a library with exhaustive support for all OpenGraph tags. In general, OpenGraph is too poorly documented and poorly adopted (outside of the main attributes) to make such a library worth writing.

## What is OpenGraph?

OpenGraph is a [standard](https://ogp.me/) for embedding structured microdata into web pages.

## How does opengraph4j implement the OpenGraph spec?

opengraph4j implements the best-documented and most widely-adopted attributes from the OpenGraph spec, namely the required elements and those without a "vertical." The current list of supported attributes is:

* `og:type`
* `og:title`
* `og:url`
* `og:description`
* `og:determiner`
* `og:locale`
* `og:locale:alternate`
* `og:site_name`
* `og:video`
* `og:video:secure_url`
* `og:video:type`
* `og:video:width`
* `og:video:height`
* `og:video:alt`
* `og:audio`
* `og:audio:secure_url`
* `og:audio:type`
* `og:image`
* `og:image:secure_url`
* `og:image:type`
* `og:image:width`
* `og:image:height`
* `og:image:alt`
* `article:published_time`
* `article:modified_time`
* `article:expiration_time`
* `article:author`
* `article:section`
* `article:tag`
* `book:author`
* `book:isbn`
* `book:release_date`
* `book:tag`
* `profile:first_name`
* `profile:last_name`
* `profile:username`
* `profile:gender`

The spec also includes provisions to allow applications to extend the spec with novel tags, but these parts of the spec are poorly documented and seem poorly adopted in practice, so opengraph4j does not implement these features.

## Examples

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
