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

public class Unit_SudokuSolved_Info {

    private NetClient objClient;
    private URL url;

    @Before
    public void setUp() throws URISyntaxException, MalformedURLException {
        objClient = new NetClient();
        URI uri = new URI("https", "scanword-stage.smapps.net", "/rest/info/ios", null);
        url = uri.toURL();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void test_SudokuSolved_Info() throws IOException {
        Map<String, String> paramsInfo = new LinkedHashMap<>();
        paramsInfo.put("user_id", "3116963");
        paramsInfo.put("auth_key", "110d770ef9f1e6d81c2dce7c7b224f26");
        paramsInfo.put("updates", "ewoJCQkiZjc5YWV6ejJlNWM3ZjhlN2Y5MjQ0Yzk1YjAxYTFhY2MiIDogewoJCQkJInV1cyIgOiB7CgkJCQkJInRzIiA6IDgzLAoJCQkJCSJoY28iIDogNDksCgkJCQkJInRvbmgiIDogNDksCgkJCQkJImhudSIgOiA0OQoJCQkJfSwKCQkJCSJ1c20iIDogewoJCQkJCSJzMjgyNzAiIDogewoJCQkJCQkiaCIgOiAiICAuIC4uLi4gICAgIC4gIC4uLi4gIC4uIC4uLi4uLiAgLiAgLi4gLi4uLiAuLiAuLi4gLi4uIC4uLiAgLiAgLi4uIC4uLi4gICAgLi4gLi4uIiwKCQkJCQkJIm0iIDogMCwKCQkJCQkJIm4iIDogIiIsCgkJCQkJCSJhIiA6ICI4MjM5MTQ1Njc0NTY3ODIzOTE3OTEzNTY4MjQ5MTQ4MjU3MzYyNjU0Mzc5MTgzNzgxNjkyNDUxODcyNDM2NTk1Mzk2NzE0ODI2NDI1OTgxNzMiLAoJCQkJCQkiZiIgOiAwCgkJCQkJfQoJCQkJfSwKCQkJCSJfdW90IiA6IDE1MzI4ODg4MjIKCQkJfQoJCX0=");

        objClient.doRequest(url, paramsInfo, "POST");

        Assert.assertEquals(200, objClient.getResponseCode());
        Assert.assertEquals("OK", objClient.getResponseMessage());
    }
}
