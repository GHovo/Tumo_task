package login;

import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{

    @Test
    public void testLogin(){
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("All good");
    }
}
