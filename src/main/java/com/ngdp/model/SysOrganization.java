package com.ngdp.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "`sys_organization`")
public class SysOrganization {
    @Id
    @Column(name = "`id`")
    @ColumnType(jdbcType = JdbcType.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`name`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String name;

    @Column(name = "`parent_id`")
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long parentId;

    @Column(name = "`parent_ids`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String parentIds;

    @Column(name = "`available`")
    @ColumnType(jdbcType = JdbcType.BIT)
    private Boolean available;

    public static final String TABLE = "`sys_organization`";

    public static final String f_id = "id";

    public static final String f_name = "name";

    public static final String f_parentId = "parentId";

    public static final String f_parentIds = "parentIds";

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