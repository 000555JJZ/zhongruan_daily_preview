package com.test.bilibili.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class HDFSUtils {
    static {
        System.setProperty("HADOOP_USER_NAME", "icss");
        String osInfo = System.getProperty("os.name");
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
        if (osInfo.toLowerCase().indexOf("windows") != -1)
            System.setProperty("hadoop.home.dir","D:/learning/hadoop/winutils-master/hadoop-3.0.0");
    }

    public static void getHDFSFileInfoToRadarChart(String hdfsURL, List<String> key , List<List<Long>> value) throws IOException {

        URL url = new URL(hdfsURL);
        URLConnection urlConnection = url.openConnection();
        InputStream is = urlConnection.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String buffer = null;
        while ((buffer = br.readLine())!= null){
            String[] fields = buffer.split("\t");
            key.add(fields[0]);
            String []values = fields[1].split(":::");
            List<Long> element = new ArrayList<>();
            for (String oneValue : values){
                element.add(Long.valueOf(oneValue));
            }
            value.add(element);
        }
        br.close();isr.close();is.close();
    }

}
