package com.test.bilibili.hdfs;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.apache.hadoop.io.IOUtils;

import java.io.*;
import java.net.URI;
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

    //获取FileSystem
    public static FileSystem getHDFSFileSystem(String hdfsRootURIStr) throws Exception{
        URI uri= new URI(hdfsRootURIStr);
        Configuration conf = new Configuration();
        FileSystem fs = FileSystem.get(uri, conf);
        return fs;
    }

    //查看文件信息
    public static void getHDFSFileInfo(FileSystem fs, String hdfsFilePathStr, OutputStream out, Boolean isCloseOutStream) throws IOException {
        Path filePath= new Path(hdfsFilePathStr);
        FSDataInputStream in = fs.open(filePath);
        IOUtils.copyBytes(in,out,4096,isCloseOutStream);
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

    //下载文件
    public static void downloadHDFSFile(FileSystem fs,String srcStr,String dstStr) throws IOException {
        Path src = new Path(srcStr);
        Path dst = new Path(dstStr);
        fs.copyToLocalFile(src,dst);
    }

    //上传文件
    public static void uploadHDFSFile(FileSystem fs,String srcStr,String dstStr) throws IOException {
        Path src = new Path(srcStr);
        Path dst = new Path(dstStr);
        fs.copyFromLocalFile(src,dst);
    }

    //文件复制
    public static void copyHDFSFile(FileSystem fs, String startPathStr,String endPathStr) throws IOException {
        Path start = new Path(startPathStr);
        Path end = new Path(endPathStr);
        FSDataOutputStream out = fs.create(end);
        FSDataInputStream in = fs.open(start);
        IOUtils.copyBytes(in,out,4096,true);
    }

    //文件移动
    public static void moveHDFSFile(FileSystem fs,String startPathStr,String endPathStr) throws IOException {
        Path start = new Path(startPathStr);
        Path end = new Path(endPathStr);
        fs.rename(start,end);

    }

    //文件ls
    public static void ListHDFSDirectoryInfo(FileSystem fs,String DirFile) throws IOException {
        Path path = new Path(DirFile);
        FileStatus[] status = fs.listStatus(path);
        for(FileStatus f: status)
        {
            System.out.println(f.getPath().toString());
        }
    }
    public static void ListHDFSDirectory(FileSystem fs,String DirFile, Boolean recursive) throws IOException {
        Path path = new Path(DirFile);
        RemoteIterator<LocatedFileStatus> ls = fs.listFiles(path, recursive);
        while (ls.hasNext()){
            System.out.println(ls.toString());
        }
    }

}
