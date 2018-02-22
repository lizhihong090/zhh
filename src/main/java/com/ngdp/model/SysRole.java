package com.ngdp.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "`sys_role`")
public class SysRole {
    @Id
    @Column(name = "`id`")
    @ColumnType(jdbcType = JdbcType.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`role`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String role;

    @Column(name = "`description`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String description;

    @Column(name = "`resource_ids`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String resourceIds;

    @Column(name = "`available`")
    @ColumnType(jdbcType = JdbcType.BIT)
    private Boolean available;

    public static final String TABLE = "`sys_role`";

    public static final String f_id = "id";

    public static final String f_role = "role";

    public static final String f_description = "description";

    public static final String f_resourceIds = "resourceIds";

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
     * @return role
     */
    public String getRole() {
        return role;
    }

    /**
     * @param role
     */
    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * @return resource_ids
     */
    public String getResourceIds() {
        return resourceIds;
    }

    /**
     * @param resourceIds
     */
    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds == null ? null : resourceIds.trim();
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