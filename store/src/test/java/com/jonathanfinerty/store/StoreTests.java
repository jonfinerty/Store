package com.jonathanfinerty.store;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class StoreTests {

    private Store store;

    @Before
    public void setUp() throws Exception {
        store = new Store.Builder(RuntimeEnvironment.application)
                .location(Store.INTERNAL)
                .build();
    }

    @Test
    public void contentCanBeWrittenAndReadFromDisk() {

        byte[] expectedBytes = new byte[]{0xA, 0xB, 0xC, 0xD};

        InputStream inputStream = new ByteArrayInputStream(expectedBytes);
        Location testLocation = store.location("testLocation");
        testLocation.write(inputStream);

        Assert.assertTrue(testLocation.getFile().exists());

        InputStream readStream = testLocation.read();

        byte[] retrievedBytes = StreamHelpers.toByteArray(readStream);

        Assert.assertArrayEquals(expectedBytes, retrievedBytes);
    }
}
