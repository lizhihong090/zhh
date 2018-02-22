package com.ngdp.model;

import javax.persistence.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "`sys_user`")
public class SysUser {
    @Id
    @Column(name = "`id`")
    @ColumnType(jdbcType = JdbcType.BIGINT)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "`organization_id`")
    @ColumnType(jdbcType = JdbcType.BIGINT)
    private Long organizationId;

    @Column(name = "`username`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String username;

    @Column(name = "`password`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String password;

    @Column(name = "`salt`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String salt;

    @Column(name = "`role_ids`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String roleIds;

    @Column(name = "`locked`")
    @ColumnType(jdbcType = JdbcType.BIT)
    private Boolean locked;

    public static final String TABLE = "`sys_user`";

    public static final String f_id = "id";

    public static final String f_organizationId = "organizationId";

    public static final String f_username = "username";

    public static final String f_password = "password";

    public static final String f_salt = "salt";

    public static final String f_roleIds = "roleIds";

    public static final String f_locked = "locked";

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
     * @return organization_id
     */
    public Long getOrganizationId() {
        return organizationId;
    }

    /**
     * @param organizationId
     */
    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * @return salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * @param salt
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * @return role_ids
     */
    public String getRoleIds() {
        return roleIds;
    }

    /**
     * @param roleIds
     */
    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds == null ? null : roleIds.trim();
    }

    /**
     * @return locked
     */
    public Boolean getLocked() {
        return locked;
    }

    /**
     * @param locked
     */
    public void setLocked(Boolean locked) {
        this.locked = locked;
    }
}