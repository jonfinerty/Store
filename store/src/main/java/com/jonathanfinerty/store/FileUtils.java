package com.jonathanfinerty.store;

import java.io.File;

class FileUtils {

    static File getOrMakeDir(File root, String dirName) {
        File dir = new File(root, dirName);
        if (!dir.exists()) {
            boolean created = dir.mkdir();
            if (!created && dir.isDirectory()) {
                // throw unchecked exception?
            }
        }

        return dir;
    }

}
