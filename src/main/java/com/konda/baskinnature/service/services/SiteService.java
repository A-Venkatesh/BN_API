package com.konda.baskinnature.service.services;

import com.konda.baskinnature.model.Site;

public interface SiteService {

    Site createSite(Site site);

    Site updateSiteDetails(Site site);

    Site getSiteDetails();

}
