package com.disruption.AnyPub4J.Objects;

import com.disruption.AnyPub4J.AP4J;
import com.disruption.AnyPub4J.API.Core.InstanceConfiguration;
import com.disruption.AnyPub4J.API.Core.InstanceStats;
import com.disruption.AnyPub4J.API.Core.InstanceURLs;
import com.disruptionsystems.logging.LogLevel;

import java.util.Objects;

public class Instance {
    private final String uri;
    private final String title;
    private final String shortDescripton;
    private final String description;
    private final String email;
    private final String version;
    private final InstanceURLs urls;
    private final InstanceStats stats;
    private final String thumbnail;
    private final String[] languages;
    private final boolean registrations;
    private final boolean approvalRequired;
    private final boolean invitesEnabled;
    private final InstanceConfiguration instanceConfig;
    private final Account contactAccount;
    private final String[] rules;
    private final AP4J ap4J;
    public Instance(
            AP4J ap4J,
            String uri,
            String title,
            String shortDescripton,
            String description,
            String email,
            String version,
            InstanceURLs urls,
            InstanceStats stats,
            String thumbnail,
            String[] languages,
            boolean registrations,
            boolean approvalRequired,
            boolean invitesEnabled,
            InstanceConfiguration instanceConfig,
            Account contactAccount,
            String[] rules
    ){
        this.uri = uri;
        this.title = title;
        this.shortDescripton = shortDescripton;
        this.description = description;
        this.email = email;
        this.version = version;
        this.urls = urls;
        this.stats = stats;
        this.thumbnail = thumbnail;
        this.languages = languages;
        this.registrations = registrations;
        this.approvalRequired = approvalRequired;
        this.invitesEnabled = invitesEnabled;
        this.instanceConfig = instanceConfig;
        this.contactAccount = contactAccount;
        this.rules = rules;
        this.ap4J = ap4J;
    }

    public String getUri() {
        if (!Objects.equals(uri, "UNSUPPORTED")) {
            return uri;
        } else {
            ap4J.getLogger().printToLog(LogLevel.ERROR, "The instance does not support this function");
            return null;
        }
    }
    public String getTitle() {
        return title;
    }
    public String getShortDescripton() {
        return shortDescripton;
    }
    public String getDescription() {
        return description;
    }
    public String getEmail() {
        return email;
    }
    public String getVersion() {
        return version;
    }
    public InstanceURLs getUrls() {
        return urls;
    }
    public InstanceStats getStats() {
        return stats;
    }
    public String getThumbnail() {
        return thumbnail;
    }
    public String[] getLanguages() {
        return languages;
    }
    public boolean isRegistrations() {
        return registrations;
    }
    public boolean isApprovalRequired() {
        return approvalRequired;
    }
    public boolean isInvitesEnabled() {
        return invitesEnabled;
    }
    public InstanceConfiguration getInstanceConfig() {
        return instanceConfig;
    }
    public Account getContactAccount() {
        return contactAccount;
    }
    public String[] getRules() {
        return rules;
    }
}
