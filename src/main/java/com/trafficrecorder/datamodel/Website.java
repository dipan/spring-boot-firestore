package com.trafficrecorder.datamodel;

import com.google.cloud.firestore.annotation.DocumentId;
import com.trafficrecorder.utility.Utility;
import lombok.ToString;
import org.springframework.cloud.gcp.data.firestore.Document;

import java.util.UUID;

@ToString
@Document
public class Website {
    @DocumentId
    private String id;
    private String website;
    private Long visitorCountLimit;
    private Long contactCountLimit;
    private Long ct;
    private Long lu;

    public Website() {
        this.setCt();
        this.updateLu();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public Long getVisitorCountLimit() {
        return visitorCountLimit;
    }

    public void setVisitorCountLimit(Long visitorCountLimit) {
        this.visitorCountLimit = visitorCountLimit;
    }

    public Long getContactCountLimit() {
        return contactCountLimit;
    }

    public void setContactCountLimit(Long contactCountLimit) {
        this.contactCountLimit = contactCountLimit;
    }

    public Long getCt() {
        return ct;
    }

    public void setCt() {
        this.ct = Utility.getUTCTimestamp();
    }

    public Long getLu() {
        return lu;
    }

    public void updateLu() {
        this.lu = Utility.getUTCTimestamp();
    }
}
