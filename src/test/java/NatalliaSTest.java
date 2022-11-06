import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class NatalliaSTest {

    /**
     * TC_1_1  - Тест кейс:
     *     1. Открыть страницу https://openweathermap.org/
     *     2. Набрать в строке поиска город Paris
     *     3. Нажать пункт меню Search
     *     4. Из выпадающего списка выбрать Paris, FR
     *     5. Подтвердить, что заголовок изменился на "Paris, FR"
     */

    @Test
    public void testH2TagText_WhenSearchingCityCountry() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\miru_\\Projects\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String cityName = "Paris";
        String expectedResult = "Paris, FR";

        driver.get(url);  //драйвер открывает браузер
        Thread.sleep(5000);  //драйвер зависает на 5 секунд (5000 = 5sec)

        WebElement searchCityField = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//input[@placeholder = 'Search city']")
        );
        searchCityField.click();
        searchCityField.sendKeys(cityName);

        WebElement searchButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//button[@type = 'submit']")
        );
        searchButton.click();

        Thread.sleep(2000);

        WebElement parisFRChoiceInDropdownMenu = driver.findElement(
                By.xpath("//ul[@class = 'search-dropdown-menu']/li/span[text() = 'Paris, FR ']")
        );
        parisFRChoiceInDropdownMenu.click();

        WebElement h2CityCountryHeader = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']//h2")
        );

        Thread.sleep(2000);
        String actualResult = h2CityCountryHeader.getText();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }


    /**
     * HW 11 for Beginners (Тестирование)
     *
     * Все теcты необходимо писать
     * в проекте Weather (Maven/TestNG 7.4.0/Selenium3.141.59),
     * в зеленой папке java,
     * в тестовом классе YourNickOnGitHubTest.
     *
     * Для всех тест кейсов -
     *   System.setProperty("webdriver.chrome.driver", "YouPathToFile/chromedriver");
     *   WebDriver driver = new ChromeDriver();
     *
     *   String url = "https://openweathermap.org/";
     */


    /**
     * TC_11_01
     * 1.  Открыть базовую ссылку
     * 2.  Нажать на пункт меню Guide
     * 3.  Подтвердить, что вы перешли на страницу со ссылкой
     *     https://openweathermap.org/guide
     *     и что title этой страницы OpenWeatherMap API guide - OpenWeatherMap
     */

    @Test
     public void testGuideMenuButton() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\miru_\\Projects\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "https://openweathermap.org/guide";

        driver.get(url);
        Thread.sleep(5000);

        WebElement guideMenuButton = driver.findElement(
                By.xpath("//div[@id  = 'desktop-menu']//a[@href = '/guide']")
        );

        guideMenuButton.click();
        Thread.sleep(2000);

        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }

    @Test
    public void testGuidePageTitle() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\miru_\\Projects\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "OpenWeatherMap API guide - OpenWeatherMap";

        driver.get(url);
        Thread.sleep(5000);

        WebElement guideMenuButton = driver.findElement(
                By.xpath("//div[@id  = 'desktop-menu']//a[@href = '/guide']")
        );

        guideMenuButton.click();
        Thread.sleep(2000);

        String actualResult = driver.getTitle();

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }


    /**
     * TC_11_02
     * 1.  Открыть базовую ссылку
     * 2.  Нажать на единицы измерения Imperial: °F, mph
     * 3.  Подтвердить, что температура для города показана в Фарингейтах
     */

    // Method for String
    @Test
    public void testTemperatureShownInFahrenheits_WhenChooseImperial() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\miru_\\Projects\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult = "F";
        //boolean expectedResult = true;

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement imperialMenuButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']"
                        + "//div[@class = 'switch-container']"
                        + "//div[text() = 'Imperial: °F, mph']")
        );
        imperialMenuButton.click();
        Thread.sleep(2000);

        WebElement tempIndicatorFahrenheit = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']"
                        + "//div[@class = 'current-temp']"
                        + "//span[@class = 'heading']")
        );

        Thread.sleep(1000);
        String tempIndicatorF = tempIndicatorFahrenheit.getText();

        if (tempIndicatorF.contains("F")) {
            tempIndicatorF = "F";
        }

        String actualResult = tempIndicatorF;

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }


    // Method for boolean
    @Test
    public void testTempShownInFahrenheits_WhenChooseImperial() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\miru_\\Projects\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        boolean expectedResult = true;

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement imperialMenuButton = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']"
                        + "//div[@class = 'switch-container']"
                        + "//div[text() = 'Imperial: °F, mph']")
        );
        imperialMenuButton.click();
        Thread.sleep(2000);

        WebElement tempIndicatorFahrenheit = driver.findElement(
                By.xpath("//div[@id = 'weather-widget']"
                        + "//div[@class = 'current-temp']"
                        + "//span[@class = 'heading']")
        );

        Thread.sleep(1000);
        boolean actualResult = tempIndicatorFahrenheit.getText().contains("F");

        Assert.assertEquals(actualResult, expectedResult);

        driver.quit();
    }


    /**
     * TC_11_03
     * 1.  Открыть базовую ссылку
     * 2. Подтвердить, что внизу страницы есть панель с текстом:
     *    “We use cookies which are essential for the site to work.
     *    We also use non-essential cookies to help us improve our services.
     *    Any data collected is anonymised.
     *    You can allow all cookies or manage them individually.”
     * 3. Подтвердить, что на панели внизу страницы есть 2 кнопки “Allow all” и “Manage cookies”
     */

    @Test
    public void testCookiesPanelTextAndTwoButtons() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\miru_\\Projects\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult1 = "We use cookies which are essential for the site to work. "
                + "We also use non-essential cookies to help us improve our services. "
                + "Any data collected is anonymised. "
                + "You can allow all cookies or manage them individually.";
        String expectedResult2 = "Allow all";
        String expectedResult3 = "Manage cookies";

        driver.get(url);
        Thread.sleep(5000);

        WebElement cookiesPanelText = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//p[contains(text(), 'We use cookies')]")
        );
        String actualResult1 = cookiesPanelText.getText();

        WebElement cookiesButtonAllowAll = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//button[text() = 'Allow all']")
        );
        String actualResult2 = cookiesButtonAllowAll.getText();

        WebElement cookiesButtonManageCookies = driver.findElement(
                By.xpath("//div[@id = 'stick-footer-panel']//a[text() = ' Manage cookies ']")
        );
        String actualResult3 = cookiesButtonManageCookies.getText();

        Assert.assertEquals(actualResult1, expectedResult1);
        Assert.assertEquals(actualResult2, expectedResult2);
        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();
    }


    /**
     * TC_11_04
     * 1.  Открыть базовую ссылку
     * 2.  Подтвердить, что в меню Support есть 3 подменю с названиями
     *     “FAQ”, “How to start” и “Ask a question”
     */

    @Test
    public void testMenuButtonSupportHasThreeSubmenuButtons() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\miru_\\Projects\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String url = "https://openweathermap.org/";
        String expectedResult1 = "Support";
        String expectedResult2 = "FQA";
        String expectedResult3 = "How to start";
        String expectedResult4 = "Ask a Question";

        driver.get(url);
        driver.manage().window().maximize();
        Thread.sleep(5000);

        WebElement menuButtonSupport = driver.findElement(
                By.xpath("//div[@id = 'support-dropdown']")
        );
        menuButtonSupport.click();
        Thread.sleep(2000);

        String actualResult1 = menuButtonSupport.getText();

        WebElement submenuButtonFQA = driver.findElement(
                By.xpath("")
        );
        String actualResult2 = submenuButtonFQA.getText();
//
//        WebElement submenuButtonHowToStart = driver.findElement(
//                By.xpath("")
//        );
//        String actualResult3 = submenuButtonHowToStart.getText();

        Assert.assertEquals(actualResult1, expectedResult1);
//        Assert.assertEquals(actualResult2, expectedResult2);
//        Assert.assertEquals(actualResult3, expectedResult3);

        driver.quit();
    }


    /**
     * TC_11_05
     * 1. Открыть базовую ссылку
     * 2. Нажать пункт меню Support → Ask a question
     * 3. Заполнить поля Email, Subject, Message
     * 4. Не подтвердив CAPTCHA, нажать кнопку Submit
     * 5. Подтвердить, что пользователю будет показана ошибка
     *    “reCAPTCHA verification failed, please try again.”
     */


    /**
     * TC_11_06
     * 1.  Открыть базовую ссылку
     * 2.  Нажать пункт меню Support → Ask a question
     * 3.  Оставить значение по умолчанию в checkbox Are you an OpenWeather user?
     * 4. Оставить пустым поле Email
     * 5. Заполнить поля  Subject, Message
     * 6. Подтвердить CAPTCHA
     * 7. Нажать кнопку Submit
     * 8. Подтвердить, что в поле Email
     *    пользователю будет показана ошибка “can't be blank”
     */

//    WebDriverWait wait = new WebDriverWait(driver, 25);
//        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(
//                By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
//
//        wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[@class='recaptcha-checkbox-border']"))).click();
//        Thread.sleep(5000);



    /**
     * TC_11_07
     * 1.  Открыть базовую ссылку
     * 2.  Нажать на единицы измерения Imperial: °F, mph
     * 3.  Нажать на единицы измерения Metric: °C, m/s
     * 4.  Подтвердить, что в результате этих действий,
     *     единицы измерения температуры изменились с F на С
     */


    /**
     * TC_11_08
     * 1.  Открыть базовую ссылку
     * 2.  Нажать на лого компании
     * 3.  Дождаться, когда произойдет перезагрузка сайта,
     *     и подтвердить, что текущая ссылка не изменилась
     */


    /**
     * TC_11_09
     * 1.  Открыть базовую ссылку
     * 2.  В строке поиска в навигационной панели набрать “Rome”
     * 3.  Нажать клавишу Enter
     * 4.  Подтвердить, что вы перешли на страницу
     *     в ссылке которой содержатся слова “find” и “Rome”
     * 5.  Подтвердить, что в строке поиска на новой странице
     *     вписано слово “Rome”
     */


    /**
     * TC_11_10
     * 1.  Открыть базовую ссылку
     * 2.  Нажать на пункт меню API
     * 3.  Подтвердить, что на открывшейся странице
     *     пользователь видит 30 оранжевых кнопок
     */








//     to open webpage full size:
//    driver.manage().window().maximize();



//    to scroll the page:
//    JavascriptExecutor jse = (JavascriptExecutor)driver;
//    jse.executeScript("window.scrollBy(0,500)", "");









//     Test template:
//
//     @Test
//     public void test_name() {
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\miru_\\Projects\\ChromeDriver\\chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//
//
//
//        driver.quit();
//    }


}
