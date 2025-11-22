import io.restassured.response.Response;
import org.example.helpers.CommentApiHelper;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PlaceholderAPICommentsTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void testGetCommentById() {
        Response response = CommentApiHelper.getCommentById(1);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), 1);
        Assert.assertTrue(response.jsonPath().getString("email").contains("@"));
    }

    @Test(groups = "regression")
    public void testGetCommentsByPostId() {
        Response response = CommentApiHelper.getCommentsByPostId(1);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("$").size() > 0);
        Assert.assertEquals(response.jsonPath().getList("postId").get(0), 1);
    }
}