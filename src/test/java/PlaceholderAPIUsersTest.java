import io.restassured.response.Response;
import org.example.helpers.UserApiHelper;
import org.testng.Assert;
import org.testng.annotations.Test;


public class PlaceholderAPIUsersTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void testGetUserById() {
        Response response = UserApiHelper.getUserById(1);

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getInt("id"), 1);
        Assert.assertEquals(response.jsonPath().getString("username"), "Bret");
    }

    @Test(groups = "regression")
    public void testGetUserByUsername() {
        Response response = UserApiHelper.getUserByUsername("Bret");

        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getString("[0].username"), "Bret");
    }
}