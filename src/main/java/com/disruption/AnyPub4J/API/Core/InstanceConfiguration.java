package com.disruption.AnyPub4J.API.Core;

import com.disruption.AnyPub4J.API.util.JSONConverter;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public class InstanceConfiguration {
    JsonNode node;
    public InstanceConfiguration(JsonNode node){
        this.node = node.path("configuration");
    }

    public int getMaxFeaturedTags(){
        return node.path("accounts").get("max_featured_tags").asInt();
    }

    public int getMaxStatusChars(){
        return node.path("statuses").get("max_characters").asInt();
    }

    public int getMaxStatusMediaAttachments(){
        return node.path("statuses").get("max_media_attachments").asInt();
    }

    public int getCharsReservedPerURL(){
        return node.path("statuses").get("characters_reserved_per_url").asInt();
    }

    public String[] getSupportedTypes(){
        JSONConverter conv = new JSONConverter();
        return conv.jsonNodeToStringArray(node.path("media_attachments").get("supported_mime_types"));
    }

    public int getImageSizeLimit(){
        return node.path("media_attachments").get("image_size_limit").asInt();
    }

    public int getImageMatrixLimit(){
        return node.path("media_attachments").get("image_matrix_limit").asInt();
    }

    public int getVideoSizeLimit(){
        return node.path("media_attachments").get("video_size_limit").asInt();
    }

    public int getVideoFrameRateLimit(){
        return node.path("media_attachments").get("video_frame_rate_limit").asInt();
    }

    public int getVideoMatrixLimit(){
        return node.path("media_attachments").get("video_matrix_limit").asInt();
    }

    public int getMaxPollOptions(){
        return node.path("polls").get("max_options").asInt();
    }

    public int getMaxCharsPerPollOption(){
        return node.path("polls").get("max_characters_per_option").asInt();
    }

    public int getMinPollExpiration(){
        return node.path("polls").get("min_expiration").asInt();
    }

    public int getPollMaxExpiration(){
        return node.path("polls").get("max_expiration").asInt();
    }

    public int getMaxReactions(){
        return node.path("reactions").get("max_reactions").asInt();
    }



}
