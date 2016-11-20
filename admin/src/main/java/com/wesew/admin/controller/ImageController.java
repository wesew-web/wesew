package com.wesew.admin.controller;

import com.wesew.admin.services.ImageManager;
import com.wesew.admin.view.ActualResult;
import com.wesew.admin.view.ActualResultBuilder;
import com.wesew.admin.view.command.ImageCreateCommand;
import com.wesew.core.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author vladyslav.yemelianov
 */
@Controller
@RequestMapping(value = "/image")
public class ImageController {

    @Autowired
    private ImageManager imageManager;

    @RequestMapping(value = "/add", method = RequestMethod.GET, consumes = "application/json")
    public @ResponseBody ActualResult createImage(@RequestBody ImageCreateCommand imageCreateCommand) {
        Image createdImage = imageManager.create(imageCreateCommand);
        return ActualResultBuilder.ok(createdImage);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, consumes = "application/json")
    public ActualResult delete(@PathVariable String id) {
        Image deleted = imageManager.delete(id);
        return ActualResultBuilder.ok(deleted);
    }

}
