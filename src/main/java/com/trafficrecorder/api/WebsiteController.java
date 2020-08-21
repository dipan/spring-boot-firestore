package com.trafficrecorder.api;

import com.trafficrecorder.datamodel.Website;
import com.trafficrecorder.service.WebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("website")
@RequestMapping(RestExecutor.BASE_URL + "/website")
public class WebsiteController {
    @Autowired
    WebsiteService websiteService;

    @PostMapping
    public Mono<Website> post(@RequestBody Website website) {
        website.setCt();
        website.updateLu();
        return websiteService.save(website);
    }

    @GetMapping
    public Flux<Website> get() {
        return websiteService.get();
    }

    @GetMapping(value = "/{websiteId}")
    public Mono<Website> getById(@PathVariable String websiteId) {
        return websiteService.getById(websiteId);
    }

    @PutMapping(value = "/{websiteId}")
    public Mono<Website> putById(@PathVariable String websiteId) {
        return websiteService.getById(websiteId);
    }

}
