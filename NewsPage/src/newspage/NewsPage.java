/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newspage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.NoSuchElementException;
/**
 *
 * @author HP
 */
public class NewsPage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        addisFortune2();
        updateSite2();
    }
    public static void addisFortune2() throws FileNotFoundException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Books\\Software Engineering 2\\software II\\Selinium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://addisfortune.net/articles/");
        
        File linkfile = new File("C:\\Users\\HP\\Desktop\\Books\\Software Engineering 2\\Assignments\\NewsWebsite\\DynamicPage2\\links.txt");
        PrintWriter links = new PrintWriter(linkfile);
        
        String link;
        List<WebElement> list = driver.findElements(By.tagName("a"));
        for(int i = 0; i < list.size(); i++){
            
            System.out.println(i);
            
            link = list.get(i).getAttribute("href");
            if(link != null && link.indexOf("https://addisfortune.net/articles/" , 0) != -1 && !link.contentEquals("https://addisfortune.net/articles/#")){
                links.println(link);
                System.out.println(link);
            }
            //driver.navigate().back();
            /*try{
                Thread.sleep(5000);
            }catch(Exception e){

            }*/
        }
        links.close();
        driver.close();
    }
    
    public static void updateSite2() throws FileNotFoundException, NoSuchElementException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\Books\\Software Engineering 2\\software II\\Selinium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    
        File file = new File("C:\\Users\\HP\\Desktop\\Books\\Software Engineering 2\\Assignments\\NewsWebsite\\DynamicPage2\\links.txt");
        File index = new File("C:\\Users\\HP\\Desktop\\Books\\Software Engineering 2\\Assignments\\NewsWebsite\\DynamicPage2\\index.html");
        //StringBuilder s2 = new StringBuilder();
        PrintWriter writeToIndex = new PrintWriter(index);
        
        String s1;
        String pageTitle;
        Scanner input = new Scanner(file);
        while (input.hasNext()) {
        s1 = input.nextLine();
        driver.navigate().to(s1);
        WebElement element = driver.findElement(By.id("addisfortune-main"));
        WebElement Title = element.findElement(By.tagName("h2"));
        List<WebElement> paragraphs = element.findElements(By.tagName("p"));
        pageTitle = Title.getText();
        File page = new File("C:\\Users\\HP\\Desktop\\Books\\Software Engineering 2\\Assignments\\NewsWebsite\\DynamicPage2\\"+ driver.getTitle()+".html");
        PrintWriter savePage = new PrintWriter(page);
        savePage.print("<title>" + pageTitle + "</title>");
        for (int i = 0; i< paragraphs.size(); i++){
            savePage.println("<p>" + paragraphs.get(i).getText() + "</p>");
        }
        savePage.close();
        
        writeToIndex.println("<a href = \"" +driver.getTitle() + ".html\" > " + driver.getTitle() + "</a><br>");
        }
        writeToIndex.close();
        driver.navigate().to("C:\\Users\\HP\\Desktop\\Books\\Software Engineering 2\\Assignments\\NewsWebsite\\DynamicPage2\\index.html");
    }
}
