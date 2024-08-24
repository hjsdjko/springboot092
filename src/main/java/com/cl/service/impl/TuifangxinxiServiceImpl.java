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


import com.cl.dao.TuifangxinxiDao;
import com.cl.entity.TuifangxinxiEntity;
import com.cl.service.TuifangxinxiService;
import com.cl.entity.view.TuifangxinxiView;

@Service("tuifangxinxiService")
public class TuifangxinxiServiceImpl extends ServiceImpl<TuifangxinxiDao, TuifangxinxiEntity> implements TuifangxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TuifangxinxiEntity> page = this.selectPage(
                new Query<TuifangxinxiEntity>(params).getPage(),
                new EntityWrapper<TuifangxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TuifangxinxiEntity> wrapper) {
		  Page<TuifangxinxiView> page =new Query<TuifangxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<TuifangxinxiView> selectListView(Wrapper<TuifangxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TuifangxinxiView selectView(Wrapper<TuifangxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
