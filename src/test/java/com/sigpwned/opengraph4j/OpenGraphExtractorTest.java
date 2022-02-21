package com.sigpwned.opengraph4j;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.NoSuchElementException;
import org.junit.Test;
import com.google.common.io.Resources;
import com.sigpwned.opengraph4j.util.OpenGraph;

public class OpenGraphExtractorTest {
  @Test
  public void exampleVergeComTest() throws IOException {
    OpenGraphMetadata extracted = OpenGraph.extract(
        Resources.toString(Resources.getResource("example-verge-com.html"), StandardCharsets.UTF_8))
        .get();

    assertThat(extracted, is(OpenGraphMetadata.of("article", // type
        "Read exactly how Microsoft’s $68.7 billion deal for Activision Blizzard came together", // title
        "https://www.theverge.com/22941636/microsoft-activision-blizzard-acquisition-sec-filing-came-together", // url
        "There were nearly two months of negotiations.", // description
        null, // determiner
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
        List.of()))); // audios
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
        List.of()))); // audios
  }

  @Test(expected = NoSuchElementException.class)
  public void exampleNeversslComTest() throws IOException {
    OpenGraph.extract(Resources.toString(Resources.getResource("example-neverssl-com.html"),
        StandardCharsets.UTF_8)).get();
  }
}
