package com.trafficrecorder.repository;

import com.trafficrecorder.datamodel.Website;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;
import reactor.core.publisher.Flux;

public interface WebsiteRepository extends FirestoreReactiveRepository<Website> {
    public Flux<Website> findByWebsite(String website);
}
