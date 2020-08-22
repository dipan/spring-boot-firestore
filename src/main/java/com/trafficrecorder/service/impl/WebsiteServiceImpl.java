package com.trafficrecorder.service.impl;

import com.trafficrecorder.datamodel.Website;
import com.trafficrecorder.repository.WebsiteRepository;
import com.trafficrecorder.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WebsiteServiceImpl implements WebsiteService {
    @Autowired
    WebsiteRepository websiteRepository;

    public Mono<Website> save(Website website) {
        return websiteRepository.save(website);
    }

    public Flux<Website> get() {
        return websiteRepository.findAll();
    }

    public Mono<Website> getById(String id) {
        return websiteRepository.findById(id);
    }

    public Flux<Website> getByWebsite(String website) {
        return websiteRepository.findByWebsite(website);
    }

    public Mono<Website> updateById(String id, Website website) {
        return save(website);
    }

    public void delete() {
        websiteRepository.deleteAll();
    }

    public Mono<Void> deleteById(String id) {
        return websiteRepository.deleteById(id);
    }
}
