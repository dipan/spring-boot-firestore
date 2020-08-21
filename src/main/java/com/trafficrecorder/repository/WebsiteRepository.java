package com.trafficrecorder.repository;

import com.trafficrecorder.datamodel.Website;
import org.springframework.cloud.gcp.data.firestore.FirestoreReactiveRepository;

public interface WebsiteRepository extends FirestoreReactiveRepository<Website> {
}
