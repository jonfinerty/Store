package com.jonathanfinerty.store;

import junit.framework.Assert;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class StreamHelpers {

    public static byte[] toByteArray(InputStream inputStream) {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            byte[] buffer = new byte[4096];
            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

            return output.toByteArray();
        } catch (IOException e) {
            Assert.fail(e.toString());
            e.printStackTrace();
            return null;
        } finally {
            try {
                output.close();
            } catch (IOException e) {
                Assert.fail(e.toString());
                e.printStackTrace();
            }
        }
    }

}
