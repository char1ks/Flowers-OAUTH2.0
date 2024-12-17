package com.example.SpringRedis_pet10.Service;

import com.example.SpringRedis_pet10.Model.Flower.Flower;
import com.example.SpringRedis_pet10.Redis.RedisPublisher;
import com.example.SpringRedis_pet10.Repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FlowerService {

    @Autowired
    private RedisPublisher publisher;

    @Autowired
    private FlowerRepository operations;

    public List<Flower> getAllFlowers(){
        return operations.findAll();
    }
    @Cacheable(value = "flower", key = "#id")
    public Flower getConcreteFlower(int id){
        return operations.findById(id).orElse(null);
    }
    @CachePut(value = "flower", key = "#result.id")
    public Flower saveFlower(Flower flower){
        publisher.publish("Цветочек только что сорвали!-"+flower.getName());
        return operations.save(flower);
    }
    @CacheEvict(value = "fruit", key = "#id")
    public void deleteFlower(int id){
        publisher.publish("Цветочек только что удалили(!-");
        operations.deleteById(id);
    }
}
