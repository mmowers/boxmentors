package com.box.boxjavalibv2.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.Map;

import com.box.boxjavalibv2.utils.ISO8601DateParser;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Data for collaboration.
 */
public class BoxCollaboration extends BoxTypedObject {

    public static final String FIELD_CREATED_BY = "created_by";
    public static final String FIELD_EXPIRES_AT = "expires_at";
    public static final String FIELD_ACCESSIBLE_BY = "accessible_by";
    public static final String FIELD_STATUS = "status";
    public static final String FIELD_ACKNOWLEGED_AT = "acknowledged_at";
    public static final String FIELD_FOLDER = "item";
    public static final String FIELD_ROLE = "role";

    /** Collaboration invitation is accepted. */
    public static final String STATUS_ACCEPTED = "accepted";
    /** Collaboration invitation is pending. */
    public static final String STATUS_PENDING = "pending";
    /** Collaboration invitation is rejected. */
    public static final String STATUS_REJECTED = "rejected";

    /**
     * Constructor.
     */
    public BoxCollaboration() {
        setType(BoxResourceType.COLLABORATION.toString());
    }

    /**
     * Copy constructor, this does deep copy for all the fields.
     * 
     * @param obj
     */
    public BoxCollaboration(BoxCollaboration obj) {
        super(obj);
    }

    /**
     * Instantiate the object from a map. Each entry in the map reflects to a field.
     * 
     * @param map
     */
    public BoxCollaboration(Map<String, Object> map) {
        super(map);
    }

    /**
     * Get the user creating this collaboration.
     * 
     * @return the created_by
     */
    @JsonProperty(FIELD_CREATED_BY)
    public BoxUser getCreatedBy() {
        return (BoxUser) getValue(FIELD_CREATED_BY);
    }

    /**
     * Setter. This is only used by {@see <a href="http://jackson.codehaus.org">Jackson JSON processer</a>}.
     * 
     * @param createdBy
     *            the created_by to set
     */
    @JsonProperty(FIELD_CREATED_BY)
    private void setCreatedBy(BoxUser createdBy) {
        put(FIELD_CREATED_BY, createdBy);
    }

    /**
     * Setter. This is only used by {@see <a href="http://jackson.codehaus.org">Jackson JSON processer</a>}.
     * 
     * @param accessibleBy
     *            the accessible_by to set
     */
    @JsonProperty(FIELD_ACCESSIBLE_BY)
    private void setAccessibleBy(BoxUserBase accessibleBy) {
        put(FIELD_ACCESSIBLE_BY, accessibleBy);
    }

    /**
     * Get the user this collaboration applies to.
     * 
     * @return the accessible_by
     */
    @JsonProperty(FIELD_ACCESSIBLE_BY)
    public BoxUserBase getAccessibleBy() {
        return (BoxUserBase) getValue(FIELD_ACCESSIBLE_BY);
    }

    /**
     * Get the time this collaboration expires. This returns a String and can be parsed into {@link java.util.Date} by
     * {@link com.box.boxjavalibv2.utils.ISO8601DateParser}
     * 
     * @return the expires_at
     */
    @JsonProperty(FIELD_EXPIRES_AT)
    public String getExpiresAt() {
        return (String) getValue(FIELD_EXPIRES_AT);
    }

    /**
     * Get the time this collaboration expires.
     * 
     * @return Date representation of the expires_at value. Null if there was no expires_at or if it could not be parsed as an ISO8601 date.
     * @throws ParseException
     */
    public Date dateExpiresAt() throws ParseException {
        return ISO8601DateParser.parseSilently(getExpiresAt());
    }

    /**
     * Setter. This is only used by {@see <a href="http://jackson.codehaus.org">Jackson JSON processer</a>}.
     * 
     * @param expiresAt
     *            the expires_at to set
     */
    @JsonProperty(FIELD_EXPIRES_AT)
    private void setExpiresAt(String expiresAt) {
        put(FIELD_EXPIRES_AT, expiresAt);
    }

    /**
     * Get the status of this collaboration. Can be {@link STATUS_ACCEPTED}, {@link STATUS_PENDING} or {@link STATUS_REJECTED}
     * 
     * @return the status
     */
    @JsonProperty(FIELD_STATUS)
    public String getStatus() {
        return (String) getValue(FIELD_STATUS);
    }

    /**
     * Setter. This is only used by {@see <a href="http://jackson.codehaus.org">Jackson JSON processer</a>}.
     * 
     * @param status
     *            the status to set
     */
    @JsonProperty(FIELD_STATUS)
    private void setStatus(String status) {
        put(FIELD_STATUS, status);
    }

    /**
     * Get the role/permission. This is a role/permission String defined in {@link CollaborationRole}
     * 
     * @return the role/permission
     */
    @JsonProperty(FIELD_ROLE)
    public String getRole() {
        return (String) getValue(FIELD_ROLE);
    }

    /**
     * Setter. This is only used by {@see <a href="http://jackson.codehaus.org">Jackson JSON processer</a>}.
     * 
     * @param role
     *            the role to set
     */
    @JsonProperty(FIELD_ROLE)
    private void setRole(String role) {
        put(FIELD_ROLE, role);
    }

    /**
     * Get the time when the status of this collaboration was changed. This returns a String and can be parsed into {@link java.util.Date} by
     * {@link com.box.boxjavalibv2.utils.ISO8601DateParser}
     * 
     * @return the acknowledged_at
     */
    @JsonProperty(FIELD_ACKNOWLEGED_AT)
    public String getAcknowledgedAt() {
        return (String) getValue(FIELD_ACKNOWLEGED_AT);
    }

    /**
     * Setter. This is only used by {@see <a href="http://jackson.codehaus.org">Jackson JSON processer</a>}.
     * 
     * @param acknowledgedAt
     *            the acknowledged_at to set
     */
    @JsonProperty(FIELD_ACKNOWLEGED_AT)
    private void setAcknowledgedAt(String acknowledgedAt) {
        put(FIELD_ACKNOWLEGED_AT, acknowledgedAt);
    }

    /**
     * Get the folder this collaboration is related to.
     * 
     * @return item the folder this collaboration is related to
     */
    @JsonProperty(FIELD_FOLDER)
    public BoxFolder getFolder() {
        return (BoxFolder) getValue(FIELD_FOLDER);
    }

    /**
     * Setter. This is only used by {@see <a href="http://jackson.codehaus.org">Jackson JSON processer</a>}.
     * 
     * @param item
     *            the item to set
     */
    @JsonProperty(FIELD_FOLDER)
    private void setFolder(BoxFolder item) {
        put(FIELD_FOLDER, item);
    }

    public BoxCollaboration(IBoxParcelWrapper in) {
        super(in);
    }
}
