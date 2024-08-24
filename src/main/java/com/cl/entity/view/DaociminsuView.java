package com.cl.entity.view;

import com.cl.entity.DaociminsuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 到此民宿
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
@TableName("daociminsu")
public class DaociminsuView  extends DaociminsuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DaociminsuView(){
	}
 
 	public DaociminsuView(DaociminsuEntity daociminsuEntity){
 	try {
			BeanUtils.copyProperties(this, daociminsuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
