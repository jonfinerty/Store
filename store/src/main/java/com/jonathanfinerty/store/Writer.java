package com.jonathanfinerty.store;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Writer {

    private final Location location;
    private final InputStream inputStream;

    Writer(Location location, InputStream inputStream) {
        this.location = location;
        this.inputStream = inputStream;
    }

    public Writer withProgressListener(ProgressListener listener) {
        return this;
    }

    public Writer withCanceller(Canceller canceller) {
        return this;
    }

    public Writer async() {
        return this;
    }

    public Writer withEvictionRules(@Store.EvictionPriority int evictionRules) {
        return this;
    }

    public Key write() {

        FileOutputStream fileOutputStream = null;

        try {
            fileOutputStream = new FileOutputStream(location.getFile());

            int byteCountRead;
            byte[] buffer = new byte[8096];

            while ((byteCountRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, byteCountRead);
            }
        } catch (IOException e) {
            // todo: silent | noisy failures
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }

                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                // todo: silent | noisy failures
            }
        }

        return location.getKey();
    }

}
