package com.ngdp.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.ibatis.type.JdbcType;

import tk.mybatis.mapper.annotation.ColumnType;

@Table(name = "`people`")
public class People {
	
	
    @Id
    @Column(name = "`id`")
    @ColumnType(jdbcType = JdbcType.INTEGER)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "{people.id.notnull}")
    private Integer id;

    @Column(name = "`name`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    private String name;

    @Column(name = "`name_all`")
    @ColumnType(jdbcType = JdbcType.VARCHAR)
    @Size(min=5,max=10,message="{people.nameAll.size.length.Illegal}")
    private String nameAll;

    public static final String TABLE = "`people`";

    public static final String f_id = "id";

    public static final String f_name = "name";

    public static final String f_nameAll = "nameAll";

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
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
     * @return name_all
     */
    public String getNameAll() {
        return nameAll;
    }

    /**
     * @param nameAll
     */
    public void setNameAll(String nameAll) {
        this.nameAll = nameAll == null ? null : nameAll.trim();
    }

	@Override
	public String toString() {
		return "People [id=" + id + ", name=" + name + ", nameAll=" + nameAll + "]";
	}
    
    
}