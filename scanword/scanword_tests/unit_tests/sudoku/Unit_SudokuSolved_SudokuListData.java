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

public class Unit_SudokuSolved_SudokuListData {

    private NetClient objClient;
    private URL url;

    @Before
    public void setUp() throws URISyntaxException, MalformedURLException {
        objClient = new NetClient();
        URI uri = new URI("https", "scanword-stage.smapps.net", "/rest/sudoku_list_data/ios", null);
        url = uri.toURL();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void test_SudokuSolved_SudokuListData() throws IOException, URISyntaxException {
        Map<String, String> paramsSudokuListData = new LinkedHashMap<>();
        paramsSudokuListData.put("user_id", "3116963");
        paramsSudokuListData.put("auth_key", "110d770ef9f1e6d81c2dce7c7b224f26");
        paramsSudokuListData.put("updates", "ewoJCQkiN2MzNjYwYzg4MThkMDhhODRiNWFkNjAxNHZ2MW0yN2EiIDogewoJCQkJInV1cyIgOiB7CgkJCQkJInRzIiA6IDU1LAoJCQkJCSJoY28iIDogMzYsCgkJCQkJInRvbmgiIDogMzYsCgkJCQkJImhudSIgOiAzNiwKCQkJCQkidG0iIDogMgoJCQkJfSwKCQkJCSJ1c20iIDogewoJCQkJCSJzMjgyNjQiIDogewoJCQkJCQkiYSIgOiAiNzg2OTUxNDIzNDk1NjIzNzgxMzEyODc0NTY5ODI3MTM1Njk0OTUxNzQ2MjM4NjM0Mjg5MTU3NTY4MzE3OTQyMTQzNTkyODc2Mjc5NDY4MzE1IiwKCQkJCQkJImYiIDogMCwKCQkJCQkJIm4iIDogIiIsCgkJCQkJCSJoIiA6ICIgIC4gIC4uICAuICAuICAuIC4gICAuLi4uLi4gLi4uLiAgIC4uICAgLiAuICAgIC4gLi4gLi4uICAuLiAuLiAgIC4gIC4uICAgICAuIC4uICIsCgkJCQkJCSJtIiA6IDAKCQkJCQl9CgkJCQl9LAoJCQkJIl91b3QiIDogMTUzMjg5NzkzMgoJCQl9LAoJCQkiN2MzNjYwYzhkMzhkMDhhODRiNWFkNjAxNGViMW0yN2EiIDogewoJCQkJInV1cyIgOiB7CgkJCQkJInRzIiA6IDU1LAoJCQkJCSJoY28iIDogMzYsCgkJCQkJInRvbmgiIDogMzYsCgkJCQkJImhudSIgOiAzNiwKCQkJCQkidG0iIDogMgoJCQkJfSwKCQkJCSJ1c20iIDogewoJCQkJCSJzMjgyNjQiIDogewoJCQkJCQkiYSIgOiAiNzg2OTUxNDIzNDk1NjIzNzgxMzEyODc0NTY5ODI3MTM1Njk0OTUxNzQ2MjM4NjM0Mjg5MTU3NTY4MzE3OTQyMTQzNTkyODc2Mjc5NDY4MzE1IiwKCQkJCQkJImYiIDogMCwKCQkJCQkJIm4iIDogIiIsCgkJCQkJCSJoIiA6ICIgIC4gIC4uICAuICAuICAuIC4gICAuLi4uLi4gLi4uLiAgIC4uICAgLiAuICAgIC4gLi4gLi4uICAuLiAuLiAgIC4gIC4uICAgICAuIC4uICIsCgkJCQkJCSJtIiA6IDAKCQkJCQl9CgkJCQl9LAoJCQkJIl91b3QiIDogMTUzMjg5NzkzMgoJCQl9CgkJfQ==");

        objClient.doRequest(url, paramsSudokuListData, "POST");

        Assert.assertEquals(200, objClient.getResponseCode());
        Assert.assertEquals("OK", objClient.getResponseMessage());
    }
}
