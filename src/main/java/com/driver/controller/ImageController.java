package com.driver.controller;

import com.driver.services.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/images")
public class ImageController {
    @Autowired
    ImageService imageService;

    @PostMapping("/{blogId}/add-image")
    public ResponseEntity<String> addImage(@PathVariable int blogId, @RequestParam String description, @RequestParam String dimensions) {

        // Add image into the give blog dimensions should be in aXb(2X2) format.
        imageService.addImage(blogId,description,dimensions);
        return new ResponseEntity<>("Added image successfully", HttpStatus.OK);
    }

    @GetMapping("/countImagesInScreen/{id}/{screenDimensions}")
    public ResponseEntity<Integer> countImagesInScreen(@PathVariable int id, @PathVariable String screenDimensions){
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
            int count = imageService.countImagesInScreen(id,screenDimensions);
        return new ResponseEntity<>(count, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteImage(@PathVariable int id) {
        // delete image using deleteById
        imageService.deleteImage(id);
        return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
}



