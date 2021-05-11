package com.konda.baskinnature.service.implementations;

import com.konda.baskinnature.model.Site;
import com.konda.baskinnature.repository.SiteRepository;
import com.konda.baskinnature.service.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
@Service
public class SiteServiceImpl implements SiteService {
    @Autowired
    private SiteRepository siteRepository;

    public Site createSite(@RequestBody Site site) {
        return siteRepository.insert(site);
    }

    public Site updateSiteDetails(@RequestBody Site site) {
        Site oldSiteDetails = siteRepository.findById("BASK_IN_NATURE").orElse(null);
        oldSiteDetails.setAboutus(site.getAboutus());
        oldSiteDetails.setReturnPolicy(site.getReturnPolicy());
        oldSiteDetails.setPrivacyPolicy(site.getPrivacyPolicy());
        oldSiteDetails.setTermsAndConditions(site.getTermsAndConditions());
        oldSiteDetails.setPassword(site.getPassword());
        oldSiteDetails.setUsername(site.getUsername());

        return siteRepository.save(oldSiteDetails);
    }

    public Site getSiteDetails() {
        return siteRepository.findById("BASK_IN_NATURE").orElse(null);
    }

}
