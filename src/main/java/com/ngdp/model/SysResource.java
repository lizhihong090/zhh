package com.ngdp.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "`sys_resource`")
public class SysResource {
    @Id
    @Column(name = "`id`")
    @ColumnType(jdbcType = JdbcType.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`name`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String name;

    @Column(name = "`type`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String type;

    @Column(name = "`url`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String url;

    @Column(name = "`parent_id`")
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long parentId;

    @Column(name = "`parent_ids`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String parentIds;

    @Column(name = "`permission`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String permission;

    @Column(name = "`available`")
    @ColumnType(jdbcType = JdbcType.BIT)
    private Boolean available;

    public static final String TABLE = "`sys_resource`";

    public static final String f_id = "id";

    public static final String f_name = "name";

    public static final String f_type = "type";

    public static final String f_url = "url";

    public static final String f_parentId = "parentId";

    public static final String f_parentIds = "parentIds";

    public static final String f_permission = "permission";

    public static final String f_available = "available";

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * @return parent_id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     * @param parentId
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     * @return parent_ids
     */
    public String getParentIds() {
        return parentIds;
    }

    /**
     * @param parentIds
     */
    public void setParentIds(String parentIds) {
        this.parentIds = parentIds == null ? null : parentIds.trim();
    }

    /**
     * @return permission
     */
    public String getPermission() {
        return permission;
    }

    /**
     * @param permission
     */
    public void setPermission(String permission) {
        this.permission = permission == null ? null : permission.trim();
    }

    /**
     * @return available
     */
    public Boolean getAvailable() {
        return available;
    }

    /**
     * @param available
     */
    public void setAvailable(Boolean available) {
        this.available = available;
    }
}