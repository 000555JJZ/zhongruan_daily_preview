package com.test.bilibili.hdfs;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class HDFSUtils {
    static {
        System.setProperty("HADOOP_USER_NAME", "icss");
        String osInfo = System.getProperty("os.name");
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
        if (osInfo.toLowerCase().indexOf("windows") != -1)
            System.setProperty("hadoop.home.dir","D:/learning/hadoop/winutils-master/hadoop-3.0.0");
    }

    public static void getHDFSFileInfoToRelationChart(String hdfsURL, List<String> key , List<Long> value) throws IOException {

        URL url = new URL(hdfsURL);
        URLConnection urlConnection = url.openConnection();
        InputStream is = urlConnection.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String buffer = null;

        while ((buffer = br.readLine())!= null){
            String[] fields = buffer.split("\t");
            key.add(fields[0]);
            value.add(Long.valueOf(fields[1]));
        }
        br.close();isr.close();is.close();

    }

}
