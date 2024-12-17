package com.example.SpringRedis_pet10.Controller.REST;

import com.example.SpringRedis_pet10.Model.Category.Category;
import com.example.SpringRedis_pet10.Model.Flower.Flower;
import com.example.SpringRedis_pet10.Security.VisitorDetails;
import com.example.SpringRedis_pet10.Service.CategoryService;
import com.example.SpringRedis_pet10.Service.FlowerService;
import com.example.SpringRedis_pet10.Service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/flower/api")
public class FlowerRESTController
{
    @Autowired
    private FlowerService operations;

    @Autowired
    private VisitorService operationsVisitors;

    @Autowired
    private CategoryService operationsCategory;

    @Autowired
    private RestTemplate restTemplate; // Внедряем RestTemplate

    @GetMapping("/all")
    public List<Flower> getAllFlowers(){
        return operations.getAllFlowers();
    }
    @GetMapping("/concrete/{id}")
    public Flower getConcreteFlower(@PathVariable("id") int id){
        return operations.getConcreteFlower(id);
    }
    @PostMapping("/save")
    public Integer saveFlower(@RequestBody Flower flower) {
        operations.saveFlower(flower);
        int flowerId = flower.getId(); // Получаем id сохраненного цветк
        return flowerId;
    }
    @PutMapping("/add_to_favorite/{flower_id}")
    public ResponseEntity<HttpStatus> addToFavoriteFlower(@PathVariable("flower_id")int flower_id){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        VisitorDetails details= (VisitorDetails) authentication.getPrincipal();
        Flower flower=operations.getConcreteFlower(flower_id);

        flower.getVisitors().add(details.getVisitor());
        details.getVisitor().getFlowers().add(flower);

        operations.saveFlower(flower);
        operationsVisitors.saveVisitor(details.getVisitor());

        return ResponseEntity.ok(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteFlower(@PathVariable("id")int id){
        operations.deleteFlower(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
