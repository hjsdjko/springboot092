package com.cl.entity.view;

import com.cl.entity.JingdianjieshaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.cl.utils.EncryptUtil;
 

/**
 * 景点介绍
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
@TableName("jingdianjieshao")
public class JingdianjieshaoView  extends JingdianjieshaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JingdianjieshaoView(){
	}
 
 	public JingdianjieshaoView(JingdianjieshaoEntity jingdianjieshaoEntity){
 	try {
			BeanUtils.copyProperties(this, jingdianjieshaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
