package itstep_aqa.day_17;


import com.fasterxml.jackson.databind.ObjectMapper;
import day_17.model.CreateBoardResponse;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.UUID;




public class CustomTrelloTest {
    private final String API_KEY = "5f48e7f3a95e47829652a5faeccb0c6e";
    private final String API_TOKEN = "98ac009d3cb51670c6fd84fbfda5fed6ac342ddfe33b54a7043e0335787e355c";
    private final String ORGANIZATION_ID = "6262eef88834e05ca232a516";
    private String boardName = "";
    private String boardID;


    @BeforeTest
        public void init() {
            boardName = UUID.randomUUID().toString();
        }


    @Test
    public void createBoard() throws URISyntaxException, IOException, InterruptedException {
        String url = String.format("https://api.trello.com/1/boards/?name=%s&key=%s&token=%s", boardName, API_KEY, API_TOKEN);

        String requestBody = String.format("{\"idOrganization\":\"%s\"}", ORGANIZATION_ID);
        HttpRequest request = HttpRequest.newBuilder().uri(new URI(url))
                .POST(HttpRequest.BodyPublishers.ofString(requestBody, StandardCharsets.UTF_8)).build();



        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Assert.assertEquals(response.statusCode(), 200, "Invalid status code");
        ObjectMapper objectMapper = new ObjectMapper();
        CreateBoardResponse createBoardResponse = null;


        try {
            createBoardResponse = objectMapper.readValue(response.body(), CreateBoardResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        boardID = createBoardResponse.getId();
        CreateBoardResponse expected = new CreateBoardResponse();
        expected.setId(boardID);
        expected.setName(boardName);
        expected.setDesc("");
        expected.setIdOrganization(ORGANIZATION_ID);
        expected.setClosed(false);
        expected.setPinned(false);
        Assert.assertEquals(createBoardResponse, expected);
    }



    @Test(dependsOnMethods = "createBoard")
    public void getBoard() throws URISyntaxException, IOException, InterruptedException {
        String url = String.format("https://api.trello.com/1/boards/%s?key=%s&token=%s", boardID, API_KEY, API_TOKEN);
        HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).GET().build();



        HttpClient client = HttpClient.newHttpClient();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();
        CreateBoardResponse createBoardResponse = null;


        try {
            createBoardResponse = objectMapper.readValue(response.body(), CreateBoardResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //New Board
        CreateBoardResponse expected = new CreateBoardResponse();
        expected.setId(boardID);
        expected.setName(boardName);
        expected.setDesc("");
        expected.setIdOrganization(ORGANIZATION_ID);
        expected.setClosed(false);
        expected.setPinned(false);
        Assert.assertEquals(createBoardResponse, expected);
    }
}