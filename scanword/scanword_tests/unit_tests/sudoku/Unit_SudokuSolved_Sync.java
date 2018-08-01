package scanword_tests.unit_tests.sudoku;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import scanword_client.NetClient;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedHashMap;
import java.util.Map;

public class Unit_SudokuSolved_Sync {

    private NetClient objClient;
    private URL url;

    @Before
    public void setUp() throws URISyntaxException, MalformedURLException {
        objClient = new NetClient();
        URI uri = new URI("https", "scanword-stage.smapps.net", "/rest/sync/ios", null);
        url = uri.toURL();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void test_SudokuSolved_Sync() throws IOException {
        Map<String, String> paramsSync = new LinkedHashMap<>();
        paramsSync.put("user_id", "3116963");
        paramsSync.put("auth_key", "110d770ef9f1e6d81c2dce7c7b224f26");
        paramsSync.put("updates", "ewogICJjNmNjOWQ2MmdnNTU0ZTdiZGExM2Q3YWJjOGM1NXh4YyIgOiB7CiAgICAidXVzIiA6IHsKICAgICAgImxmIiA6IHsKICAgICAgICAiYmFja2dyb3VuZCIgOiAxCiAgICAgIH0sCiAgICAgICJsYyIgOiAxLAogICAgICAidG0iIDogMwogICAgfSwKICAgICJfdW90IiA6IDE1MzI5MDE2NjAKICB9LAogICI2YmViYzQ2MGU4YzE0dXU2MDUwYXc0MTM2YWYwZTlmYyIgOiB7CiAgICAidXVzIiA6IHsKICAgICAgInRtIiA6IDIKICAgIH0sCiAgICAiX3VvdCIgOiAxNTMyOTAxNjcwCiAgfSwKICAiMjgyYzJmMzQ4NjE1ZGZnMjNiMGIyODVlOTY2NmQxNjQiIDogewogICAgInV1cyIgOiB7CiAgICAgICJ0bSIgOiAxMAogICAgfSwKICAgICJfdW90IiA6IDE1MzI5MDE2ODAKICB9LAogICIyODJjMmYzcnI2MzVkNDkyMmIwYjI4NWU5NjY2ZDE2NCIgOiB7CiAgICAidXVzIiA6IHsKICAgICAgInRtIiA6IDEzMgogICAgfSwKICAgICJfdW90IiA6IDE1MzI5MDE3MTAKICB9LAogICI2NWRzczUyYzdmZXJ0OGM1YjIwMjE0bm4yNWE5MzJiYiIgOiB7CiAgICAiX3VvdCIgOiAxNTMyOTAxNzAwLAogICAgInVzbSIgOiB7CiAgICAgICJzMjgyODMiIDogewogICAgICAgICJmIiA6IDAsCiAgICAgICAgIm0iIDogMCwKICAgICAgICAibiIgOiAiIiwKICAgICAgICAiYSIgOiAiMTc0ODk2MjM1ODk2MjM1MTQ3MjM1NDcxOTY4OTY3MTI4MzU0MzE4NTQ3NjI5NDUyOTYzNzgxNzI5NjU0ODEzNTgzNzEyNDk2NjQxMzg5NTcyIiwKICAgICAgICAiaCIgOiAiICAuICAuIC4uLiAuLiAgLi4gLi4uICAuLiAgLi4uLiAuICAgICAgLi4uLi4uLiAuICAuIC4uICAuLi4uLiAuIC4uIC4uICAgLi4uICAgLi4uIgogICAgICB9CiAgICB9LAogICAgInV1cyIgOiB7CiAgICAgICJ0cyIgOiA4OCwKICAgICAgImhjbyIgOiA0NiwKICAgICAgInRvbmgiIDogNDYsCiAgICAgICJobnUiIDogNDYsCiAgICAgICJ0bSIgOiAxNgogICAgfQogIH0sCiAgIjY1ZHNzeXljN2ZlcnQ4Y3c1azAyMTRubjI1YTkzMmJiIiA6IHsKICAgICJfdW90IiA6IDE1MzI5MDE3MTAsCiAgICAidXNtIiA6IHsKICAgICAgInMyODI4MyIgOiB7CiAgICAgICAgImYiIDogMCwKICAgICAgICAibSIgOiAwLAogICAgICAgICJuIiA6ICIiLAogICAgICAgICJhIiA6ICIxNzQ4OTYyMzU4OTYyMzUxNDcyMzU0NzE5Njg5NjcxMjgzNTQzMTg1NDc2Mjk0NTI5NjM3ODE3Mjk2NTQ4MTM1ODM3MTI0OTY2NDEzODk1NzIiLAogICAgICAgICJoIiA6ICIgIC4gIC4gLi4uIC4uICAuLiAuLi4gIC4uICAuLi4uIC4gICAgICAuLi4uLi4uIC4gIC4gLi4gIC4uLi4uIC4gLi4gLi4gICAuLi4gICAuLi4iCiAgICAgIH0KICAgIH0sCiAgICAidXVzIiA6IHsKICAgICAgInRzIiA6IDg4LAogICAgICAiaGNvIiA6IDQ2LAogICAgICAidG9uaCIgOiA0NiwKICAgICAgImhudSIgOiA0NiwKICAgICAgInRtIiA6IDE2CiAgICB9CiAgfQp9");

        objClient.doRequest(url, paramsSync, "POST");

        Assert.assertEquals(200, objClient.getResponseCode());
        Assert.assertEquals("OK", objClient.getResponseMessage());
    }
}
