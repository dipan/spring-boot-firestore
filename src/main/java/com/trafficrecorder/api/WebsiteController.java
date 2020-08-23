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
        return websiteService.save(website);
    }

    @GetMapping
    public Flux<Website> get() {
        return websiteService.get();
    }

    @GetMapping(value = "/{websiteId}")
    public Mono<Website> getById(@PathVariable String websiteId) {
        Mono<Website> mono = websiteService.getById(websiteId);
        mono.log().subscribe(website -> System.out.println("website = " + website));
        return mono;
    }

    @PutMapping(value = "/{websiteId}")
    public Mono<Website> putById(@PathVariable String websiteId) {
        return websiteService.getById(websiteId);
    }

    @DeleteMapping
    public void delete() {
        websiteService.delete();
    }

    @DeleteMapping(value = "/{websiteId}")
    public Mono<Void> deleteById(@PathVariable String websiteId) {
        return websiteService.deleteById(websiteId);
    }
}
