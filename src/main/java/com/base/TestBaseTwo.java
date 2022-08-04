package com.base;

import org.testng.annotations.Test;

import java.awt.*;
import java.io.*;

public class TestBaseTwo {
    public static String portNumber;
    public static String url1 = "http://127.0.0.1:";
    public void subInitialization() throws IOException, InterruptedException, FileNotFoundException {

//        String path = "C:\\Users\\NareshRagula\\Downloads\\deleteSubLog.bat";
//        openscript(path);
//        Thread.sleep(20000);
       String path = "C:\\FVS\\Test@2\\FVSOnline.log";
        open(path);

    }
    public  void openscript(String targetFilePath) throws IOException, InterruptedException,FileNotFoundException {
        Desktop desktop = Desktop.getDesktop();
        desktop.open(new File(targetFilePath));
    }
    public static void open(String targetFilePath) throws IOException, InterruptedException,FileNotFoundException {

        try (BufferedReader br = new BufferedReader(new FileReader(targetFilePath))) {

            String strCurrentLine;

            while ((strCurrentLine = br.readLine()) != null) {
                if (strCurrentLine.contains("port")) {
                    Thread.sleep(1000);
                    portNumber = strCurrentLine.split(":")[1].trim();
                }
            }
        }
    }
}