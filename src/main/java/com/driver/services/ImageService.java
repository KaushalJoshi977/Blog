package com.driver.services;

import com.driver.models.Image;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Image image = new Image();
        image.setBlog(blogRepository2.findById(blogId).get());
        image.setDescription(description);
        image.setDimensions(dimensions);
        imageRepository2.save(image);
        return image;

    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) {

        Image image = imageRepository2.findById(id).get();
        String imageDim = image.getDimensions();
        int imageWidth = Integer.parseInt(imageDim.substring(0,1));
        int imageHeight = Integer.parseInt(imageDim.substring(2,3));
        int scrnWidth = Integer.parseInt(screenDimensions.substring(0,1));
        int scrnHeight = Integer.parseInt(screenDimensions.substring(2,3));
        int horizontal = scrnWidth/imageWidth;
        int vertical = scrnHeight/imageHeight;
        int count = horizontal*vertical;
        return count;
    }
}