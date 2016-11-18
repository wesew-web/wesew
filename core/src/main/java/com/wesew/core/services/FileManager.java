package com.wesew.core.services;

import java.io.InputStream;

/**
 * @author vladyslav.yemelianov
 */
public interface FileManager {

    InputStream readImage(String path);
    void writeImage(byte[] data, String path);
}
