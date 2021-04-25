package com.konda.baskinnature.controller;

import com.konda.baskinnature.model.Site;
import com.konda.baskinnature.service.implementations.SiteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/site")
@CrossOrigin("*")
public class SiteController {

    @Autowired
    private SiteServiceImpl service;

    @PostMapping
    public Site createSite(@RequestBody Site site) {
        return service.createSite(site);
    }

    @PutMapping
    public Site updateSiteDetails(@RequestBody Site site) {
        return service.updateSiteDetails(site);
    }

    @GetMapping
    public Site getSiteDetails() {
        return service.getSiteDetails();
    }
}
