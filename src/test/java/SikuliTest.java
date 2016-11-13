
import org.junit.Test;
import com.codeborne.selenide.Configuration;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import java.net.URL;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.screenshot;

/**
 * Created by user on 12.11.2016.
 */
public class SikuliTest {

    private static String chromeDriverProperty = "webdriver.chrome.driver";
    private static String pathToDriver = "C:\\Work\\chromedriver.exe";

    private static String siteToTest = "https://vk.com/";
    private static String browserType = "chrome";

    private void configSelenide() {
        System.setProperty(chromeDriverProperty, pathToDriver);
        Configuration.browser = browserType;
    }

    @Test
    public void loginTest() {


        configSelenide();
        open(siteToTest);
        Screen s = new Screen();

        String login = "your email";
        String password = "***";

        URL pswdImage = SikuliTest.class.getResource("screenshots/pswd.png");
        URL loginImage = SikuliTest.class.getResource("screenshots/login.png");
        URL msgsImage = SikuliTest.class.getResource("screenshots/msgs.png");


        try {
            s.type(login);
            s.type(pswdImage.getPath(), password);
            s.click(loginImage.getPath(), 2000);
            s.click(msgsImage.getPath(), 2000);

        } catch (FindFailed findFailed) {
            findFailed.printStackTrace();
        }
    }
}
