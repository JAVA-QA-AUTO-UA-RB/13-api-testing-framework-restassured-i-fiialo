import io.restassured.response.Response;
import org.example.helpers.PostApiHelper;
import org.example.models.Post;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PlaceholderAPIPostsTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void testGetPost() {
        Response response = PostApiHelper.getPostById(1);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), 1);
        Assert.assertNotNull(response.jsonPath().getString("title"), "Title should not be null");
    }

    @Test(groups = "regression")
    public void testCreatePost() {
        Post post = new Post(1, 0, "Title", "Body"); // id = 0 або не передавати

        Response response = PostApiHelper.createPost(post);

        Assert.assertEquals(response.statusCode(), 201);
        Assert.assertEquals(response.jsonPath().getInt("userId"), 1);
        Assert.assertEquals(response.jsonPath().getString("title"), "Title");
        Assert.assertEquals(response.jsonPath().getString("body"), "Body");
    }

    @Test(groups = "regression")
    public void testUpdatePost() {
        Post updatedPost = new Post(1, 1, "New Title", "New Body");

        Response response = PostApiHelper.updatePost(1, updatedPost);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("title"), "New Title");
        Assert.assertEquals(response.jsonPath().getString("body"), "New Body");
    }

    @Test(groups = "regression")
    public void testDeletePost() {
        Response response = PostApiHelper.deletePost(1);
        Assert.assertEquals(response.statusCode(), 200);

        Response deletedCheck = PostApiHelper.getPostById(1);
    }
}