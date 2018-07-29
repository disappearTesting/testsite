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
        paramsInfo.put("friends", "");
        paramsInfo.put("news_hash", "a3fd2c8b5ba5854eab1c7893ea0630cd");
        paramsInfo.put("mask", "4");
        paramsInfo.put("shop_hash", "97e37af106b975a610d4286ef8495755");
        paramsInfo.put("rating_hash", "");
        paramsInfo.put("updates", "ewogICJmNzlhZTdiMmU1YzdmOGU3ZjkyY2ZjOTViMDFhMWFjYyIgOiB7CiAgICAidXVzIiA6IHsKICAgICAgInRzIiA6IDgzLAogICAgICAiaGNvIiA6IDQ5LAogICAgICAidG9uaCIgOiA0OSwKICAgICAgImhudSIgOiA0OQogICAgfSwKICAgICJ1c20iIDogewogICAgICAiczI4MjcwIiA6IHsKICAgICAgICAiaCIgOiAiICAuIC4uLi4gICAgIC4gIC4uLi4gIC4uIC4uLi4uLiAgLiAgLi4gLi4uLiAuLiAuLi4gLi4uIC4uLiAgLiAgLi4uIC4uLi4gICAgLi4gLi4uIiwKICAgICAgICAibSIgOiAwLAogICAgICAgICJuIiA6ICIiLAogICAgICAgICJhIiA6ICI4MjM5MTQ1Njc0NTY3ODIzOTE3OTEzNTY4MjQ5MTQ4MjU3MzYyNjU0Mzc5MTgzNzgxNjkyNDUxODcyNDM2NTk1Mzk2NzE0ODI2NDI1OTgxNzMiLAogICAgICAgICJmIiA6IDAKICAgICAgfQogICAgfSwKICAgICJfdW90IiA6IDE1MzI4ODg4MDIKICB9Cn0=");

        objClient.doRequest(url, paramsInfo, "POST");

        Assert.assertEquals(200, objClient.getResponseCode());
        Assert.assertEquals("OK", objClient.getResponseMessage());
    }
}
