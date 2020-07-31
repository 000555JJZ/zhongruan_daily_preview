package com.test.bilibili.hdfs;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HDFSUtil {
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

    public static void getHDFSFileInfoToRelationChart(
            String hdfsURL, List<String> key , List<Long> value,List<Integer> category, List<String> source, List<String> target) throws IOException {

        URL url = new URL(hdfsURL);
        URLConnection urlConnection = url.openConnection();
        InputStream is = urlConnection.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String buffer = null;

        while ((buffer = br.readLine())!= null){
            String[] fields = buffer.split("\t");
            String[] keys = fields[0].split("&");
            for (String oneKey : keys){
                if (key.contains(oneKey)){
                    value.set(key.indexOf(oneKey),value.get(key.indexOf(oneKey)) + Integer.parseInt(fields[1])/2);
                }
                else {
                    key.add(oneKey);
                    value.add(Long.valueOf(fields[1])/2);
                    category.add(new Random().nextInt(5)+1);
                }
            }
            source.add(keys[0]);
            target.add(keys[1]);
        }
        br.close();isr.close();is.close();
    }
    public static void getHDFSFileInfoToChart(String hdfsURL, List<String> key , List<Long> value) throws IOException {

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
