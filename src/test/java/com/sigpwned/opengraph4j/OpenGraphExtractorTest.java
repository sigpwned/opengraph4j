package com.sigpwned.opengraph4j;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.Test;
import com.google.common.io.Resources;
import com.sigpwned.opengraph4j.model.OpenGraphAudio;
import com.sigpwned.opengraph4j.model.OpenGraphImage;
import com.sigpwned.opengraph4j.model.OpenGraphMetadata;
import com.sigpwned.opengraph4j.model.OpenGraphVideo;
import com.sigpwned.opengraph4j.util.Determiners;
import com.sigpwned.opengraph4j.util.OpenGraph;
import com.sigpwned.opengraph4j.util.Types;

public class OpenGraphExtractorTest {
  @Test
  public void exampleVergeComTest() throws IOException {
    OpenGraphMetadata extracted = OpenGraph.extract(
        Resources.toString(Resources.getResource("example-verge-com.html"), StandardCharsets.UTF_8))
        .get();

    assertThat(extracted, is(OpenGraphMetadata.of(Types.ARTICLE, // type
        "Read exactly how Microsoft’s $68.7 billion deal for Activision Blizzard came together", // title
        "https://www.theverge.com/22941636/microsoft-activision-blizzard-acquisition-sec-filing-came-together", // url
        "There were nearly two months of negotiations.", // description
        null, // determiner
        null, // locale
        List.of(), // alternateLocales
        "The Verge", // siteName
        List.of(OpenGraphImage.of(
            "https://cdn.vox-cdn.com/thumbor/_wbu8OtKBsWa1nmucL_pJ0Z7KFU=/0x180:2500x1489/fit-in/1200x630/cdn.vox-cdn.com/uploads/chorus_asset/file/16333233/vpavic_070616_1091_0165.jpg",
            null, // secureUrl
            null, // type
            1200, // width
            630, // height
            null)), // alt
        List.of(), // videos
        List.of(), // audios
        OffsetDateTime.of(LocalDate.of(2022, 2, 18), LocalTime.of(22, 54, 34),
            ZoneOffset.ofHours(-5)), // articlePublishedTime
        OffsetDateTime.of(LocalDate.of(2022, 2, 18), LocalTime.of(22, 54, 34),
            ZoneOffset.ofHours(-5)), // articlePublishedTime
        null, // articleExpirationTime
        null, // articleAuthors
        null, // articleSection
        null, // articleTags
        null, // bookAuthors
        null, // bookIsbn
        null, // bookReleaseDate
        null, // bookTags
        null, // profileFirstName
        null, // profileLastName
        null, // profileUsername
        null))); // profileGender
  }

  @Test
  public void exampleImdbComTest() throws IOException {
    OpenGraphMetadata extracted = OpenGraph.extract(
        Resources.toString(Resources.getResource("example-imdb-com.html"), StandardCharsets.UTF_8))
        .get();


    assertThat(extracted, is(OpenGraphMetadata.of("video.movie", // type
        "The Rock (1996) - IMDb", // title
        "https://www.imdb.com/title/tt0117500/", // url
        "The Rock: Directed by Michael Bay. With Sean Connery, Nicolas Cage, Ed Harris, John Spencer. A mild-mannered chemist and an ex-con must lead the counterstrike when a rogue group of military men, led by a renegade general, threaten a nerve gas attack from Alcatraz against San Francisco.", // description
        null, // determiner
        "en_US", // locale
        List.of("es_ES", "es_MX", "fr_FR", "fr_CA", "it_IT", "pt_BR", "hi_IN", "de_DE"), // alternateLocales
        "IMDb",
        List.of(OpenGraphImage.of(
            "https://m.media-amazon.com/images/M/MV5BZDJjOTE0N2EtMmRlZS00NzU0LWE0ZWQtM2Q3MWMxNjcwZjBhXkEyXkFqcGdeQXVyNDk3NzU2MTQ@._V1_FMjpg_UX1000_.jpg",
            null, // secureUrl
            null, // type
            1000, // width
            1480, // height
            null)), // alt
        List.of(), // videos
        List.of(), // audios
        null, // articlePublishedTime
        null, // articleModifiedTime
        null, // articleExpirationTime
        null, // articleAuthors
        null, // articleSection
        null, // articleTags
        null, // bookAuthors
        null, // bookIsbn
        null, // bookReleaseDate
        null, // bookTags
        null, // profileFirstName
        null, // profileLastName
        null, // profileUsername
        null))); // profileGender
  }

  @Test(expected = NoSuchElementException.class)
  public void exampleNeversslComTest() throws IOException {
    OpenGraph.extract(Resources.toString(Resources.getResource("example-neverssl-com.html"),
        StandardCharsets.UTF_8)).get();
  }

  @Test
  public void exampleEverythingGoodTest() throws IOException {
    OpenGraphMetadata extracted = OpenGraph.extract(Resources
        .toString(Resources.getResource("example-everything-good.html"), StandardCharsets.UTF_8)).get();


    assertThat(extracted, is(OpenGraphMetadata.of(Types.ARTICLE, // type
        "Everything Test", // title
        "https://en.wikipedia.org/wiki/Nyan_Cat", // url
        "This is an example with every kind of supported tag.", // description
        Determiners.AUTO, // determiner
        "en_US", // locale
        List.of("en_GB"), // alternateLocales
        "Everything", // siteName
        List.of(OpenGraphImage.of(
            "https://upload.wikimedia.org/wikipedia/en/e/ed/Nyan_cat_250px_frame.PNG",
            "https://upload.wikimedia.org/wikipedia/en/e/ed/Nyan_cat_250px_frame.PNG", // secureUrl
            "image/png", // type
            250, // width
            250, // height
            "A poptart cat")), // alt
        List.of(OpenGraphVideo.of("https://www.youtube.com/watch?v=QH2-TGUlwu4",
            "https://www.youtube.com/watch?v=QH2-TGUlwu4", "video/mpeg", 400, 300,
            "A cosmic kitty")), // videos
        List.of(OpenGraphAudio.of("https://soundcloud.com/elfing/nyan-cat-music",
            "https://soundcloud.com/elfing/nyan-cat-music", "audio/ogg")), // audios
        OffsetDateTime.of(LocalDate.of(2020, 1, 23), LocalTime.of(12, 34, 56), ZoneOffset.UTC), // articlePublishedTime
        OffsetDateTime.of(LocalDate.of(2020, 1, 23), LocalTime.of(12, 34, 57), ZoneOffset.UTC), // articlePublishedTime
        OffsetDateTime.of(LocalDate.of(2020, 1, 23), LocalTime.of(12, 34, 58), ZoneOffset.UTC), // articleExpirationTime
        List.of("https://www.example.com/article/author"), // articleAuthors
        "Memes", // articleSection
        List.of("NyanCat"), // articleTags
        List.of("https://www.example.com/book/author"), // bookAuthors
        "1234567890", // bookIsbn
        OffsetDateTime.of(LocalDate.of(2020, 1, 23), LocalTime.of(12, 34, 59), ZoneOffset.UTC), // bookReleaseDate
        List.of("PoptartCat"), // bookTags
        "Nyan", // profileFirstName
        "Cat", // profileLastName
        "nyan_cat", // profileUsername
        "male"))); // profileGender
  }

  @Test
  public void exampleEverythingBadTest() throws IOException {
    OpenGraphMetadata extracted = OpenGraph.extract(Resources
        .toString(Resources.getResource("example-everything-bad.html"), StandardCharsets.UTF_8)).get();


    assertThat(extracted, is(OpenGraphMetadata.of(Types.ARTICLE, // type
        "Everything Test", // title
        "https://en.wikipedia.org/wiki/Nyan_Cat", // url
        "This is an example with every kind of supported tag.", // description
        Determiners.AUTO, // determiner
        "en_US", // locale
        List.of("en_GB"), // alternateLocales
        "Everything", // siteName
        List.of(OpenGraphImage.of(
            "https://upload.wikimedia.org/wikipedia/en/e/ed/Nyan_cat_250px_frame.PNG",
            "https://upload.wikimedia.org/wikipedia/en/e/ed/Nyan_cat_250px_frame.PNG", // secureUrl
            "image/png", // type
            250, // width
            250, // height
            "A poptart cat")), // alt
        List.of(OpenGraphVideo.of("https://www.youtube.com/watch?v=QH2-TGUlwu4",
            "https://www.youtube.com/watch?v=QH2-TGUlwu4", "video/mpeg", 400, 300,
            "A cosmic kitty")), // videos
        List.of(OpenGraphAudio.of("https://soundcloud.com/elfing/nyan-cat-music",
            "https://soundcloud.com/elfing/nyan-cat-music", "audio/ogg")), // audios
        OffsetDateTime.of(LocalDate.of(2020, 1, 23), LocalTime.of(12, 34, 56), ZoneOffset.UTC), // articlePublishedTime
        OffsetDateTime.of(LocalDate.of(2020, 1, 23), LocalTime.of(12, 34, 57), ZoneOffset.UTC), // articlePublishedTime
        OffsetDateTime.of(LocalDate.of(2020, 1, 23), LocalTime.of(12, 34, 58), ZoneOffset.UTC), // articleExpirationTime
        List.of("https://www.example.com/article/author"), // articleAuthors
        "Memes", // articleSection
        List.of("NyanCat"), // articleTags
        List.of("https://www.example.com/book/author"), // bookAuthors
        "1234567890", // bookIsbn
        OffsetDateTime.of(LocalDate.of(2020, 1, 23), LocalTime.of(12, 34, 59), ZoneOffset.UTC), // bookReleaseDate
        List.of("PoptartCat"), // bookTags
        "Nyan", // profileFirstName
        "Cat", // profileLastName
        "nyan_cat", // profileUsername
        "male"))); // profileGender
  }
}
