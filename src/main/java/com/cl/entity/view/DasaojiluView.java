package com.cl.entity.view;

import com.cl.entity.DasaojiluEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 打扫记录
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
@TableName("dasaojilu")
public class DasaojiluView  extends DasaojiluEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DasaojiluView(){
	}
 
 	public DasaojiluView(DasaojiluEntity dasaojiluEntity){
 	try {
			BeanUtils.copyProperties(this, dasaojiluEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
