package com.sigpwned.unpedantical.opengraph;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;
import com.google.common.io.Resources;
import com.sigpwned.unpedantical.opengraph.type.ArticleOpenGraphMetadata;
import com.sigpwned.unpedantical.opengraph.type.video.VideoMovieOpenGraphMetadata;

public class ExtractorTest {
  @Test
  public void exampleVergeComTest() throws IOException {
    Document doc = Jsoup.parse(Resources.toString(Resources.getResource("example-verge-com.html"),
        StandardCharsets.UTF_8));

    ArticleOpenGraphMetadata extracted =
        (ArticleOpenGraphMetadata) new Extractor().extract(doc).get();

    assertThat(extracted, is(ArticleOpenGraphMetadata.of(
        "Read exactly how Microsoft’s $68.7 billion deal for Activision Blizzard came together",
        "https://www.theverge.com/22941636/microsoft-activision-blizzard-acquisition-sec-filing-came-together",
        "There were nearly two months of negotiations.", null, // determiner
        null, // locale
        List.of(), // alternateLocales
        "The Verge",
        List.of(OpenGraphImage.of(
            "https://cdn.vox-cdn.com/thumbor/_wbu8OtKBsWa1nmucL_pJ0Z7KFU=/0x180:2500x1489/fit-in/1200x630/cdn.vox-cdn.com/uploads/chorus_asset/file/16333233/vpavic_070616_1091_0165.jpg",
            null, // secureUrl
            null, // type
            1200, // width
            630, // height
            null)), // alt
        List.of(), // videos
        List.of(), // audios
        OffsetDateTime.of(LocalDate.of(2022, Month.FEBRUARY, 19), LocalTime.of(3, 54, 34),
            ZoneOffset.UTC), // publishedTime
        OffsetDateTime.of(LocalDate.of(2022, Month.FEBRUARY, 19), LocalTime.of(3, 54, 34),
            ZoneOffset.UTC), // modifiedTime
        null, // expirationTime
        List.of(), // authors
        null, // section
        List.of()))); // tags
  }

  @Test
  public void exampleImdbComTest() throws IOException {
    Document doc = Jsoup.parse(
        Resources.toString(Resources.getResource("example-imdb-com.html"), StandardCharsets.UTF_8));

    VideoMovieOpenGraphMetadata extracted =
        (VideoMovieOpenGraphMetadata) new Extractor().extract(doc).get();

    /*
     * public static VideoMovieOpenGraphMetadata of(String title, String url, String description,
     * String determiner, String locale, List<String> alternateLocales, String siteName,
     * List<OpenGraphImage> images, List<OpenGraphVideo> videos, List<OpenGraphAudio> audios,
     * List<OpenGraphVideoActor> actors, List<URI> directors, List<URI> writers, Integer duration,
     * OffsetDateTime releaseDate, List<String> tags) {
     */
    assertThat(extracted, is(VideoMovieOpenGraphMetadata.of("The Rock (1996) - IMDb",
        "https://www.imdb.com/title/tt0117500/",
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
        List.of(), // actors
        List.of(), // directors
        List.of(), // writers,
        null, // duration
        null, // releaseDate
        List.of()))); // tags
  }
}
