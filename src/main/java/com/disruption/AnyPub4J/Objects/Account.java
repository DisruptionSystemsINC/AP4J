package com.disruption.AnyPub4J.Objects;

import com.disruption.AnyPub4J.AP4J;
import com.disruption.AnyPub4J.API.Core.AccountConfiguration.AccountFields;
import com.disruptionsystems.logging.LogLevel;

import java.util.Objects;

public class Account {
    private final String id;
    private final String username;
    private final String acct;
    private final String fqn;
    private final String displayName;
    private final Boolean locked;
    private final String createdAt;
    private final Integer followersCount;
    private final Integer followingCount;
    private final Integer statusesCount;
    private final String note;
    private final String url;
    private final String uri;
    private final String avatar;
    private final String avatarStatic;
    private final String header;
    private final String headerStatic;
    private final String[] emojis;
    private final String moved;
    private final AccountFields fields;
    private final Boolean isBot;
    private final Boolean isDiscoverable;
    private final AP4J ap4J;
    public Account(
            AP4J ap4J,
            String id,
            String username,
            String acct,
            String fqn,
            String displayName,
            Boolean locked,
            String createdAt,
            Integer followersCount,
            Integer followingCount,
            Integer statusesCount,
            String note,
            String url,
            String uri,
            String avatar,
            String avatarStatic,
            String header,
            String headerStatic,
            String[] emojis,
            String moved,
            AccountFields fields,
            Boolean isBot,
            Boolean isDiscoverable
    ){
        this.ap4J = ap4J;
        this.id = id;
        this.username = username;
        this.acct = acct;
        this.fqn = fqn;
        this.displayName = displayName;
        this.locked = locked;
        this.createdAt = createdAt;
        this.followersCount = followersCount;
        this.followingCount = followingCount;
        this.statusesCount = statusesCount;
        this.note = note;
        this.url = url;
        this.uri = uri;
        this.avatar = avatar;
        this.avatarStatic = avatarStatic;
        this.header = header;
        this.headerStatic = headerStatic;
        this.emojis = emojis;
        this.moved = moved;
        this.fields = fields;
        this.isBot = isBot;
        this.isDiscoverable = isDiscoverable;
    }
    public String getId() {
        return id;
    }
    public String getUsername() {
        return username;
    }
    public String getAcct() {
        return acct;
    }
    public String getFqn() {
        return fqn;
    }
    public String getDisplayName() {
        return displayName;
    }
    public boolean isLocked() {
        return locked;
    }
    public String getCreatedAt() {
        return createdAt;
    }
    public int getFollowersCount() {
        return followersCount;
    }
    public int getFollowingCount() {
        return followingCount;
    }
    public int getStatusesCount() {
        return statusesCount;
    }
    public String getNote() {
        return note;
    }
    public String getUrl() {
        if (!url.equals("UNSUPPORTED")){
            return url;
        } else {
            ap4J.getLogger().printToLog(LogLevel.ERROR, "The instance does not support this function: com.disruption.Objects.Account.getUrl()");
            return null;
        }
    }
    public String getUri() {
        if (!Objects.equals(uri, "UNSUPPORTED")) {
            return uri;
        } else {
            ap4J.getLogger().printToLog(LogLevel.ERROR, "The instance does not support this function: com.disruption.Objects.Account.getUri()");
            return null;
        }
    }
    public String getAvatar() {
        return avatar;
    }
    public String getAvatarStatic() {
        return avatarStatic;
    }
    public String getHeader() {
        return header;
    }
    public String getHeaderStatic() {
        return headerStatic;
    }
    public String[] getEmojis() {
        return emojis;
    }
    public String getMoved() {
        return moved;
    }
    public AccountFields getFields() {
        return fields;
    }
    public boolean isBot() {
        return isBot;
    }
    public boolean isDiscoverable() {
        return isDiscoverable;
    }
}
