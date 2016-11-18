package com.wesew.core.services;

import com.wesew.core.exc.CannotAccessDataException;
import com.wesew.core.exc.ImageNotFoundException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author vladyslav.yemelianov
 */
public class UnixFileManager implements FileManager {

    private final static String BASE_DIR = "";

    @Override
    public InputStream readImage(String path) {
        Path imagePath = checkPath(path);
        try {
            return new BufferedInputStream(new FileInputStream(imagePath.toFile()));
        } catch (FileNotFoundException e) {
            throw new CannotAccessDataException(e.getMessage());
        }
    }

    @Override
    public void writeImage(byte[] data, String path) {
        Path imagePath = checkPath(path);
    }

    private Path checkPath(String path) {
        Path img = getImage(path);
        if (Files.notExists(img)) throw new ImageNotFoundException(path);
        return img;
    }

    private Path getImage(String path) {
        return Paths.get(BASE_DIR + path);
    }
}
