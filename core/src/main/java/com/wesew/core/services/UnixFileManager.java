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

    private final String baseDirPath;

    public UnixFileManager(String baseDirPath) {
        this.baseDirPath = baseDirPath + File.separator;
        Path baseDir = Paths.get(this.baseDirPath);
        if (Files.notExists(baseDir)) {
            try {
                Files.createDirectories(baseDir);
            } catch (IOException e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }

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
        try {
            Path imagePath = checkFile(path);
            Files.write(imagePath, data);
        } catch (IOException e) {
            throw new CannotAccessDataException(e.getMessage());
        }
    }

    private Path checkFile(String path) throws IOException {
        Path img = getImage(path);
        if (Files.notExists(img)) return Files.createFile(img);
        return img;
    }

    private Path checkPath(String path) {
        Path img = getImage(path);
        if (Files.notExists(img)) throw new ImageNotFoundException(path);
        return img;
    }

    private Path getImage(String path) {
        return Paths.get(baseDirPath + path);
    }
}
