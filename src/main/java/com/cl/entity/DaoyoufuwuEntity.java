package com.cl.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 导游服务
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
@TableName("daoyoufuwu")
public class DaoyoufuwuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public DaoyoufuwuEntity() {
		
	}
	
	public DaoyoufuwuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 导游姓名
	 */
					
	private String daoyouxingming;
	
	/**
	 * 导游照片
	 */
					
	private String daoyouzhaopian;
	
	/**
	 * 导游语种
	 */
					
	private String daoyouyuzhong;
	
	/**
	 * 服务区域
	 */
					
	private String fuwuquyu;
	
	/**
	 * 价格/天
	 */
					
	private Double fuwujiage;
	
	/**
	 * 联系方式
	 */
					
	private String lianxifangshi;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：导游姓名
	 */
	public void setDaoyouxingming(String daoyouxingming) {
		this.daoyouxingming = daoyouxingming;
	}
	/**
	 * 获取：导游姓名
	 */
	public String getDaoyouxingming() {
		return daoyouxingming;
	}
	/**
	 * 设置：导游照片
	 */
	public void setDaoyouzhaopian(String daoyouzhaopian) {
		this.daoyouzhaopian = daoyouzhaopian;
	}
	/**
	 * 获取：导游照片
	 */
	public String getDaoyouzhaopian() {
		return daoyouzhaopian;
	}
	/**
	 * 设置：导游语种
	 */
	public void setDaoyouyuzhong(String daoyouyuzhong) {
		this.daoyouyuzhong = daoyouyuzhong;
	}
	/**
	 * 获取：导游语种
	 */
	public String getDaoyouyuzhong() {
		return daoyouyuzhong;
	}
	/**
	 * 设置：服务区域
	 */
	public void setFuwuquyu(String fuwuquyu) {
		this.fuwuquyu = fuwuquyu;
	}
	/**
	 * 获取：服务区域
	 */
	public String getFuwuquyu() {
		return fuwuquyu;
	}
	/**
	 * 设置：价格/天
	 */
	public void setFuwujiage(Double fuwujiage) {
		this.fuwujiage = fuwujiage;
	}
	/**
	 * 获取：价格/天
	 */
	public Double getFuwujiage() {
		return fuwujiage;
	}
	/**
	 * 设置：联系方式
	 */
	public void setLianxifangshi(String lianxifangshi) {
		this.lianxifangshi = lianxifangshi;
	}
	/**
	 * 获取：联系方式
	 */
	public String getLianxifangshi() {
		return lianxifangshi;
	}

}
