package com.trafficrecorder.service;

import com.trafficrecorder.datamodel.Website;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WebsiteService {
    public Mono<Website> save(Website website);

    public Flux<Website> get();

    public Mono<Website> getById(String id);

    public Flux<Website> getByWebsite(String website);

    public Mono<Website> updateById(String id, Website website);

    public void delete();

    public Mono<Void> deleteById(String id);
}
