package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.INFO);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Connect to the chrome-window running on debugging port
        options.setExperimentalOption("debuggerAddress", "127.0.0.1:9222");

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        //driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get(" https://calendar.google.com/ ");
        Thread.sleep(2000);
        String actualUrl = driver.getCurrentUrl();
        if(actualUrl.contains("calendar")) {
            System.out.println("Url contains CALENDAR");
        } else {
            System.out.println("Url doesnot contain CALENDAR");
        }
        System.out.println("end Test case: testCase01");
    }

    public  void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testCase02");
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(" https://calendar.google.com/ ");
        Thread.sleep(1000);
        //switch to month view
        WebElement dropdown = driver.findElement(By.xpath("//*[@id='gb']/div[2]/div[2]/div[3]/div/div/div[5]/div/div[1]/div[1]/div/button"));
        Thread.sleep(2000);
        dropdown.click();
        //select month in dropdown
        WebElement month = driver.findElement(By.xpath("//*[@id='ucc-1']/ul/li[3]"));
        Thread.sleep(3000);
        month.click();
        String monthText = month.getText();
        if(monthText.contains("Month")) {
            System.out.println("Switched to month view");
        } else {
            System.out.println("Not Switched to Month view");
        }
        //click on create btn 
        WebElement create = driver.findElement(By.xpath("//div[@class='mr0WL']"));
        Thread.sleep(2000);
        create.click();
        //click on task btn
        WebElement task = driver.findElement(By.xpath("//div[text()='Task']"));
        Thread.sleep(2000);
        task.click();
        Thread.sleep(2000);
        //send keys for title text box
        WebElement title = driver.findElement(By.xpath("//input[@placeholder='Add title']"));
        Thread.sleep(4000);
        title.sendKeys("Crio INTV Task Automation");
        //send keys for description text box
        WebElement description = driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));
        Thread.sleep(2000);
        description.sendKeys("Crio INTV Calendar Task Automation");
        //click on save btn
        WebElement saveBtn = driver.findElement(By.xpath("//button[@class='VfPpkd-LgbsSe VfPpkd-LgbsSe-OWXEXe-k8QpJ VfPpkd-LgbsSe-OWXEXe-dgl2Hf nCP5yc AjY5Oe DuMIQc LQeN7 pEVtpe']"));
        Thread.sleep(2000);
        saveBtn.click();
        Thread.sleep(15000);
        System.out.println("end Test case: testCase02");
        
    }

    public  void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testCase03");
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(" https://calendar.google.com/ ");
        Thread.sleep(5000);
        //click on existing task
        WebElement taskItem = driver.findElement(By.xpath("//span[@class='meh4fc KU3dEf CPXyj aIknfe']"));
        Thread.sleep(3000);
        taskItem.click();
        //click on edit btn
        WebElement editBtn = driver.findElement(By.xpath("//button[@aria-label='Edit task']"));
        Thread.sleep(3000);
        editBtn.click();
        //update the task description
        WebElement taskDesc = driver.findElement(By.xpath("//textarea[@placeholder='Add description']"));
        taskDesc.clear();
        Thread.sleep(3000);
        taskDesc.sendKeys("Crio INTV Task Automation is a test suite designed for automating various tasks on the Google Calendar web application");
        Thread.sleep(3000);
        WebElement saveBtn = driver.findElement(By.xpath("//span[text()='Save']"));
        Thread.sleep(3000);
        saveBtn.click();
        taskItem.click();
        Thread.sleep(3000);
        WebElement ut = driver.findElement(By.xpath("//div[@class='toUqff D29CYb']"));
        String updatedText = ut.getText();
        System.out.println("The updated text is" +updatedText);
        if(updatedText.contains("Google Calendar web application")) {
            System.out.println("Description is updated");
        } else {
            System.out.println("Description is not updated");
        }
        //click on close btn
        WebElement close = driver.findElement(By.xpath("//button[@id='xDetDlgCloseBu']"));
        close.click();
        Thread.sleep(15000);
        System.out.println("end Test case: testCase03");


        
    }

    public  void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testCase04");
        //driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        driver.get(" https://calendar.google.com/ ");
        Thread.sleep(5000);
        //click on existing task
        WebElement taskItem = driver.findElement(By.xpath("//span[@class='meh4fc KU3dEf CPXyj aIknfe']"));
        Thread.sleep(3000);
        taskItem.click();
        //verify the title of the task
        WebElement title = driver.findElement(By.xpath("//span[@id='rAECCd']"));
        Thread.sleep(3000);
        String textOfTitle = title.getText();
        String text = "Crio INTV Task Automation";
        Thread.sleep(3000);
        System.out.println(textOfTitle);
        if(textOfTitle.equals(text)) {
            System.out.println("Title Matched");
        } else {
            System.out.println("Title not Matched");
        }
        //delete task
        WebElement del = driver.findElement(By.xpath("//button[@aria-label='Delete task']"));
        Thread.sleep(3000);
        del.click();
        //verify task was deleted
        WebElement taskDel = driver.findElement(By.xpath("//div[text()='Task deleted']"));
        Thread.sleep(3000);
        String textOfTaskDel = taskDel.getText();
        Thread.sleep(3000);
        if(textOfTaskDel.contains("Task deleted")) {
            System.out.println("Task was Deleted");
        } else {
            System.out.println("Task was not deleted");
        }
        Thread.sleep(15000);
        System.out.println("end Test case: testCase04");


        
    }

    


}
