package com.hofey.dwy.demo.base.io.file;

import java.io.File;

/**
 * @program: dwy
 * @description:
 * @author: yhf
 * @create: 2020-09-10 22:04
 **/
public class FileTest {
    public static void main(String[] args) {
        File file = new File("e:"+File.separator);
        listFiles(file);
    }

    public static void listFiles(File file){
        if(file.isDirectory()){
            File[] result = file.listFiles();
            if(result!=null){
                for (int i = 0; i < result.length ; i++) {
                    listFiles(result[i]);
                }
            }

        }
        System.out.println(file);
    }
}
