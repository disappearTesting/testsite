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
        paramsSudokuListData.put("updates", "ewogICI5MWVlMTEzNTNiZTgyM2ExNDE4MDk2Yzc3MzExZGIyZSIgOiB7CiAgICAidXVzIiA6IHsKICAgICAgInRtIiA6IDc3CiAgICB9LAogICAgIl91b3QiIDogMTUzMjk1MDE2NgogIH0sCiAgIjQwMmVhZmRiMTMyOWJiYjc1NDgyYzAwODBlNGU0ODdiIiA6IHsKICAgICJ1dXMiIDogewogICAgICAidHMiIDogNzIsCiAgICAgICJoY28iIDogNzUsCiAgICAgICJ0b25oIiA6IDc1LAogICAgICAiaG51IiA6IDc1LAogICAgICAidG0iIDogMjMKICAgIH0sCiAgICAidXNtIiA6IHsKICAgICAgInMyODI3OCIgOiB7CiAgICAgICAgImgiIDogIi4uLi4gICAgICAgIC4gIC4gICAuLiAuIC4uIC4uICAgLi4gICAgICAuICAuLi4gLi4gICAgICAuLi4uIC4gLiAgLiAuLiAgLi4gICAgLiAuLiIsCiAgICAgICAgIm0iIDogMCwKICAgICAgICAibiIgOiAiIiwKICAgICAgICAiYSIgOiAiOTYxODI0NzM1MjM0NzU2MTg5NzU4OTEzMjQ2Mzg1NDY3OTEyMTc5NTMyNDY4NDI2MTg5NTczODQyNjkxMzU3NTk3MzQ4NjIxNjEzMjc1ODk0IiwKICAgICAgICAiZiIgOiAwCiAgICAgIH0sCiAgICAgICJzMjgyODAiIDogewogICAgICAgICJhIiA6ICI1MjgxMzQ2OTc5NjM3MjU4NDE3MTQ2ODk1MjMxNTk0NjIzNzg0MzI4NTc5MTY2ODc5MTMyNTQ4NzE1OTY0MzIyNDUzNzgxNjkzOTYyNDE3ODUiLAogICAgICAgICJmIiA6IDAsCiAgICAgICAgIm4iIDogIiIsCiAgICAgICAgImgiIDogIi4gLiAuLiAgLiAgLiAgICAuLi4uIC4uLiAuICAgIC4gLiAuIC4gLiAgIC4gIC4uIC4gIC4uLiAuLiAuICAuLiAuIC4gIC4uICAgLi4uIC4gLiIsCiAgICAgICAgIm0iIDogMAogICAgICB9CiAgICB9LAogICAgIl91b3QiIDogMTUzMjk1MDI2MQogIH0KfQ==");

        objClient.doRequest(url, paramsSudokuListData, "POST");

        Assert.assertEquals(200, objClient.getResponseCode());
        Assert.assertEquals("OK", objClient.getResponseMessage());
    }
}
