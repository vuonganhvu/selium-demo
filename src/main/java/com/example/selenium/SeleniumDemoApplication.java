package com.example.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

//@SpringBootApplication
public class SeleniumDemoApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SeleniumDemoApplication.class, args);

        String cookies = "sb=13vEYGDhPwnerk_RALahHi30; datr=13vEYItWGBRDSCrw9dnlzW5o; wd=1419x1082; dpr=1.25; locale=vi_VN; c_user=100002239896191; xs=8:iwq38aTMvEganA:2:1623489593:-1:6381; fr=1MCxL55hQdO6QSq9X.AWV_VPhWWSQp9Psiy6H3c5rSfx0.BgxHvX.ga.AAA.0.0.BgxHw5.AWUJMXmjUEc; spin=r.1003960093_b.trunk_t.1623489595_s.1_v.2_";
        String[] cookiesArrays = cookies.split(";");
        WebDriver driver;
        ChromeOptions coptions = new ChromeOptions();
//        coptions.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\PC\\IdeaProjects\\selium-demo\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(coptions);
        driver.get("https://facebook.com/");
        System.out.println(driver.manage().getCookies());
        for (String cookiesArray : cookiesArrays) {
            String[] keyValue = cookiesArray.split("=");
            System.out.println(keyValue[0]);
            System.out.println(keyValue[1]);
            driver.manage().deleteCookieNamed(keyValue[0].trim());
            driver.manage().addCookie(new Cookie(keyValue[0].trim(), keyValue[1].trim()));
            System.out.println(driver.manage().getCookies());
        }
        driver.get("https://facebook.com/");
//        driver.quit();

    }

}
