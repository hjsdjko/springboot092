package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.JingdianjieshaoDao;
import com.cl.entity.JingdianjieshaoEntity;
import com.cl.service.JingdianjieshaoService;
import com.cl.entity.view.JingdianjieshaoView;

@Service("jingdianjieshaoService")
public class JingdianjieshaoServiceImpl extends ServiceImpl<JingdianjieshaoDao, JingdianjieshaoEntity> implements JingdianjieshaoService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JingdianjieshaoEntity> page = this.selectPage(
                new Query<JingdianjieshaoEntity>(params).getPage(),
                new EntityWrapper<JingdianjieshaoEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JingdianjieshaoEntity> wrapper) {
		  Page<JingdianjieshaoView> page =new Query<JingdianjieshaoView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JingdianjieshaoView> selectListView(Wrapper<JingdianjieshaoEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JingdianjieshaoView selectView(Wrapper<JingdianjieshaoEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
