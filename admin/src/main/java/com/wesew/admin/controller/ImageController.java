package com.wesew.admin.controller;

import com.wesew.admin.services.ImageManager;
import com.wesew.admin.view.ActualResult;
import com.wesew.admin.view.ActualResultBuilder;
import com.wesew.admin.view.command.ImageCreateCommand;

/**
 * @author vladyslav.yemelianov
 */
public class ImageController {

    private ImageManager imageManager;

    public ActualResult createImage(ImageCreateCommand imageCreateCommand) {
        Object createdImage = imageManager.create(imageCreateCommand);
        return ActualResultBuilder.ok(createdImage);
    }

    public ActualResult delete(String id) {
        Object deleted = imageManager.delete(id);
        return ActualResultBuilder.ok(deleted);
    }

}
