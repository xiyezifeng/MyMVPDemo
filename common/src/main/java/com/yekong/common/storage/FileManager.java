package com.yekong.common.storage;

import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileManager {

    private static volatile FileManager singleton;

    private FileManager() {

    }

    public static FileManager getInstance() {
        if (singleton == null) {
            synchronized (FileManager.class) {
                if (singleton == null) {
                    singleton = new FileManager();
                }
            }
        }
        return singleton;
    }

    public boolean checkFileExist(String path){
        return checkFileExist(new File(path));
    }
    public boolean checkFileExist(File file){
        try {
            return file.exists();
        } catch (Exception e) {
            Log.e("FileManager", "无文件，或无读取权限");
        }
        return false;
    }

    public boolean createFile(String path){
        if (!checkFileExist(path)) {
            try {
                return new File(path).createNewFile();
            } catch (Exception e) {
                Log.e("FileManager", "文件创建失败");
            }
        }else{
            Log.e("FileManager", "文件已存在");
        }
        return false;
    }

    public String readFileContent(String path){
        return readFileContent(new File(path));
    }


    public String readFileContent(File file){
        if (checkFileExist(file)) {
            if (file.canRead()) {
                try {
                    FileReader reader = new FileReader(file);
                    char[] cbuf = new char[(int) file.length()];
                    reader.read(cbuf,0, (int) file.length());
                    return new String(cbuf);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            Log.d("FileManager", "文件读取错误");
            return null;
        }
        return null;
    }


}