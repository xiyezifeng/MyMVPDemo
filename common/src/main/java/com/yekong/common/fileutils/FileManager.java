package com.yekong.common.fileutils;

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


}