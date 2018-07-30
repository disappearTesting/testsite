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
        paramsSync.put("updates", "ewogICJjeDUxZTgyNzEwYzdjYzk1Mnc1NWZkYzNiYzRkN2JjNCIgOiB7CiAgICAidXVzIiA6IHsKICAgICAgInRzIiA6IDc3LAogICAgICAiaGNvIiA6IDI4LAogICAgICAidG9uaCIgOiAyOCwKICAgICAgImhudSIgOiAyOCwKICAgICAgInRtIiA6IDMxCiAgICB9LAogICAgInVzbSIgOiB7CiAgICAgICJzMjgyODciIDogewogICAgICAgICJhIiA6ICI3MTY0ODIzNTk4OTI2MzUxNDc0MzU3OTE4NjIxODkzNzY0MjUyNDM4NTk2NzE1NjcxMjQ5ODMzNTQ5NjcyMTg2NzgyMTM1OTQ5MjE1NDg3MzYiLAogICAgICAgICJmIiA6IDAsCiAgICAgICAgIm4iIDogIiIsCiAgICAgICAgImgiIDogIi4uICAuIC4uICAuLi4uIC4uICAgLiAuLi4gLi4gICAuLiAuIC4uLi4uICAgLi4uICAgLi4uLiAgLi4uIC4gICAuLi4gLi4gLi4uLi4gLiAgLiIsCiAgICAgICAgIm0iIDogMAogICAgICB9CiAgICB9LAogICAgIl91b3QiIDogMTUzMjk0MzMwMAogIH0KfQ==");

        objClient.doRequest(url, paramsSync, "POST");

        Assert.assertEquals(200, objClient.getResponseCode());
        Assert.assertEquals("OK", objClient.getResponseMessage());
    }
}
