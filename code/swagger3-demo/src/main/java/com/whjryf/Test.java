package com.whjryf;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author 涂鼎 tuding27@gmail.com  QQ:200161
 * @version 0.1
 * @since 2021/12/15
 */
public class Test {

    public static void main(String[] args) throws IOException {

        String source = args[0];
        String target = args[1];

        URL url = new URL(source);
        String userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.45 Safari/537.36";
        URLConnection conn = url.openConnection();
        conn.setRequestProperty("user-agent",userAgent);
        InputStream inStream = conn.getInputStream();
        File f = new File(target);
        FileUtils.copyInputStreamToFile(inStream,f);
    }

}
