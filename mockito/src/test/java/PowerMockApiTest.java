import dto.OrderRequest;
import dto.OrderResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import service.OrderService;
import util.NotificationUtil;

/*
 * @Mock creates a mock.
 *
 * @InjectMocks creates an instance of the class and
 * injects the mocks that are created with the @Mock (or @Spy) annotations into this instance.
 *
 * https://stackoverflow.com/questions/16467685/difference-between-mock-and-injectmocks
 * */

//@RunWith(MockitoJUnitRunner.class)
@RunWith(PowerMockRunner.class)
@PrepareForTest(fullyQualifiedNames = "util.*")
public class PowerMockApiTest {

    OrderRequest request = new OrderRequest(111, "Mobile", 1, 10000, "test@gmail.com", true);

    // Create instance and inject as well
    @InjectMocks
    private OrderService orderService;

    // Way to initialize a mock object using MockIto
    @Before
    public void init() {
        MockitoAnnotations.initMocks(NotificationUtil.class);
    }


    @Test
    public void testStaticMethod() {

        String emailid = "test@gmail.com";

        // Create Mock Util class
        PowerMockito.mockStatic(NotificationUtil.class);

        // Add behavior what you want , doesn't enter in code snippet
        Mockito.when(NotificationUtil.sendEmail(emailid)).thenReturn("success");

        // Check
        OrderResponse response= orderService.checkoutOrder(request);
        Assert.assertEquals("success",response.getMessage());
        System.out.println("Done");
    }

    @Test
    public void testPrivateMethod() throws Exception {

        // When
        OrderService spy = PowerMockito.spy(orderService);

        // Add behavior what you want , doesn't enter in code snippet
        PowerMockito.doReturn(1000).when(spy,"addDiscount",ArgumentMatchers.any());

        // Then
        OrderResponse response = spy.checkoutOrder(request);
        int price = response.getResponse().getPrice();// 9000
        System.out.println("price : " + price);
        Assert.assertEquals(9000, price);
    }
}
