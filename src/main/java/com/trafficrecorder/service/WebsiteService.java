package com.trafficrecorder.service;

import com.trafficrecorder.datamodel.Website;
import com.trafficrecorder.repository.WebsiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import reactor.core.publisher.Flux;

@Service
public class WebsiteService {
    @Autowired
    WebsiteRepository websiteRepository;

    public Mono<Website> save(Website website){
        return websiteRepository.save(website);
    }

    public Flux<Website> get(){
        return websiteRepository.findAll();
    }

    public Mono<Website> getById(String id){
        return websiteRepository.findById(id);
    }
    public Mono<Website> updateById(String id, Website website){
        return save(website);
    }
}
