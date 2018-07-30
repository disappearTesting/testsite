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
        paramsInfo.put("updates", "ewogICJjODYxZTgyNzEwYzdjNDk1Mnd3ZmZkYzNiYzRkN2JjNCIgOiB7CiAgICAidXVzIiA6IHsKICAgICAgInRzIiA6IDc3LAogICAgICAiaGNvIiA6IDI4LAogICAgICAidG9uaCIgOiAyOCwKICAgICAgImhudSIgOiAyOCwKICAgICAgInRtIiA6IDMxCiAgICB9LAogICAgInVzbSIgOiB7CiAgICAgICJzMjgyODciIDogewogICAgICAgICJhIiA6ICI3MTY0ODIzNTk4OTI2MzUxNDc0MzU3OTE4NjIxODkzNzY0MjUyNDM4NTk2NzE1NjcxMjQ5ODMzNTQ5NjcyMTg2NzgyMTM1OTQ5MjE1NDg3MzYiLAogICAgICAgICJmIiA6IDAsCiAgICAgICAgIm4iIDogIiIsCiAgICAgICAgImgiIDogIi4uICAuIC4uICAuLi4uIC4uICAgLiAuLi4gLi4gICAuLiAuIC4uLi4uICAgLi4uICAgLi4uLiAgLi4uIC4gICAuLi4gLi4gLi4uLi4gLiAgLiIsCiAgICAgICAgIm0iIDogMAogICAgICB9CiAgICB9LAogICAgIl91b3QiIDogMTUzMjk0Mjk5OQogIH0sCiAgImM4NjFlODI3MTBjN2M0OTUyd3dmZmRjM2JjNGQ3YmM0IiA6IHsKICAgICJ1dXMiIDogewogICAgICAidHMiIDogNzcsCiAgICAgICJoY28iIDogMjgsCiAgICAgICJ0b25oIiA6IDI4LAogICAgICAiaG51IiA6IDI4LAogICAgICAidG0iIDogMzEKICAgIH0sCiAgICAidXNtIiA6IHsKICAgICAgInMyODI4NyIgOiB7CiAgICAgICAgImEiIDogIjcxNjQ4MjM1OTg5MjYzNTE0NzQzNTc5MTg2MjE4OTM3NjQyNTI0Mzg1OTY3MTU2NzEyNDk4MzM1NDk2NzIxODY3ODIxMzU5NDkyMTU0ODczNiIsCiAgICAgICAgImYiIDogMCwKICAgICAgICAibiIgOiAiIiwKICAgICAgICAiaCIgOiAiLi4gIC4gLi4gIC4uLi4gLi4gICAuIC4uLiAuLiAgIC4uIC4gLi4uLi4gICAuLi4gICAuLi4uICAuLi4gLiAgIC4uLiAuLiAuLi4uLiAuICAuIiwKICAgICAgICAibSIgOiAwCiAgICAgIH0KICAgIH0sCiAgICAiX3VvdCIgOiAxNTMyOTQyOTk5CiAgfQp9");

        objClient.doRequest(url, paramsInfo, "POST");

        Assert.assertEquals(200, objClient.getResponseCode());
        Assert.assertEquals("OK", objClient.getResponseMessage());
    }
}
