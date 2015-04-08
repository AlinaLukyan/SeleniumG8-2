package com.app.utils;


import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.StringTokenizer;

public class CookieManager {

    private WebDriver driver;

    public CookieManager (WebDriver driver) {
        this.driver = driver;
    }

    public void storeCurrentCookies() {
        File file = new File("src/main/resources/cookies/browser.data");

        BufferedWriter bWriter = null;

        for(Cookie cookie : driver.manage().getCookies()) {
            try {
                file.delete();
                file.createNewFile();
                FileWriter fWriter = new FileWriter(file);
                bWriter = new BufferedWriter(fWriter);

                bWriter.write(cookie.getName() + ";"
                        + cookie.getValue() + ";"
                        + cookie.getDomain() + ";"
                        + cookie.getPath() + ";"
                        + cookie.getExpiry() + ";"
                        + cookie.isSecure());
                bWriter.newLine();

                bWriter.flush();
                bWriter.close();
                fWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Set<Cookie> allCookies = driver.manage().getCookies();
            for (Cookie loadedCookie : allCookies) {
                System.out.println(String.format("%s -> %s", loadedCookie.getName(), loadedCookie.getValue()));
            }

        }
    }

    public void loadStoredCookies() {
        File file = new File("src/main/resources/cookies/browser.data");

        FileReader fReader = null;
        BufferedReader bReader = null;
        try {
            fReader = new FileReader(file);
            bReader = new BufferedReader(fReader);

            String line = null;
            while ((line = bReader.readLine()) != null) {
                StringTokenizer str = new StringTokenizer(line, ";");
                while (str.hasMoreTokens()) {
                    String name = str.nextToken();
                    String value = str.nextToken();
                    String domain = str.nextToken();
                    String path = str.nextToken();

                    Date expiryDate = null;
                    String expiry;

//Sat Apr 01 14:28:40 EEST 2017
                    DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);

                    if (!(expiry = str.nextToken()).equals(null)) {
                        expiryDate = format.parse(expiry);
                    }

                    Boolean isSecure = new Boolean(str.nextToken()).booleanValue();

                    Cookie ck = new Cookie(name, value, domain, path, expiryDate, isSecure);
                    driver.manage().addCookie(ck);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
