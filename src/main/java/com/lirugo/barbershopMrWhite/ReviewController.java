package com.lirugo.barbershopMrWhite;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {
    @Autowired
    private ReviewRepo reviewRepo;

    @GetMapping
    public List<Review> getAll(){
        return reviewRepo.findAll();
    }

    @PostMapping
    public Review save(@RequestBody Review review){
        return reviewRepo.save(review);
    }
}
