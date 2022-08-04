package com.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ElementsPage;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;



public class TestBase {
    public static WebDriver driver;
    public static String portNumber;
    public static String url1 = "http://127.0.0.1:";
    public ElementsPage elementsPage;

    public ElementsPage getelementsPage() {
        if (elementsPage == null) {
            elementsPage = new ElementsPage();
            ElementsPage e= new ElementsPage();
        }
        return elementsPage;
    }

    public WebDriver getWebdriver() {
        return driver;
    }
    public void initialization() throws IOException, InterruptedException {

            String path = "C:\\Users\\NareshRagula\\Downloads\\deleteLog.bat";
            openscript(path);
             path = "C:\\Users\\NareshRagula\\Downloads\\FVS_Automation.bat";
            openscript(path);
            Thread.sleep(15000);
            path = "C:\\FVS\\Project_1\\FVSOnline.log";
            open(path);
        }
        public static void openscript (String targetFilePath) throws IOException,InterruptedException {
            Desktop desktop = Desktop.getDesktop();
            desktop.open(new File(targetFilePath));
        }
        public static void open (String targetFilePath) throws IOException, InterruptedException {

            try (BufferedReader br = new BufferedReader(new FileReader(targetFilePath))) {

                String strCurrentLine;

                while ((strCurrentLine = br.readLine()) != null) {
                    if (strCurrentLine.contains("port")) {
                        Thread.sleep(1000);
                        portNumber = strCurrentLine.split(":")[1].trim();
                    }
                }
                String url = url1 + portNumber;
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                Thread.sleep(3000);
                driver.get(url);
                System.out.println("Parent  browser Launched successfully "+url);
            }
        }
    }
