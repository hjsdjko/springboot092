package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.YoulanluxianEntity;
import com.cl.entity.view.YoulanluxianView;

import com.cl.service.YoulanluxianService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 游览路线
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
@RestController
@RequestMapping("/youlanluxian")
public class YoulanluxianController {
    @Autowired
    private YoulanluxianService youlanluxianService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YoulanluxianEntity youlanluxian,
		HttpServletRequest request){
        EntityWrapper<YoulanluxianEntity> ew = new EntityWrapper<YoulanluxianEntity>();

		PageUtils page = youlanluxianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youlanluxian), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YoulanluxianEntity youlanluxian, 
		HttpServletRequest request){
        EntityWrapper<YoulanluxianEntity> ew = new EntityWrapper<YoulanluxianEntity>();

		PageUtils page = youlanluxianService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, youlanluxian), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YoulanluxianEntity youlanluxian){
       	EntityWrapper<YoulanluxianEntity> ew = new EntityWrapper<YoulanluxianEntity>();
      	ew.allEq(MPUtil.allEQMapPre( youlanluxian, "youlanluxian")); 
        return R.ok().put("data", youlanluxianService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YoulanluxianEntity youlanluxian){
        EntityWrapper< YoulanluxianEntity> ew = new EntityWrapper< YoulanluxianEntity>();
 		ew.allEq(MPUtil.allEQMapPre( youlanluxian, "youlanluxian")); 
		YoulanluxianView youlanluxianView =  youlanluxianService.selectView(ew);
		return R.ok("查询游览路线成功").put("data", youlanluxianView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YoulanluxianEntity youlanluxian = youlanluxianService.selectById(id);
		youlanluxian = youlanluxianService.selectView(new EntityWrapper<YoulanluxianEntity>().eq("id", id));
        return R.ok().put("data", youlanluxian);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YoulanluxianEntity youlanluxian = youlanluxianService.selectById(id);
		youlanluxian = youlanluxianService.selectView(new EntityWrapper<YoulanluxianEntity>().eq("id", id));
        return R.ok().put("data", youlanluxian);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YoulanluxianEntity youlanluxian, HttpServletRequest request){
    	youlanluxian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youlanluxian);
        youlanluxianService.insert(youlanluxian);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YoulanluxianEntity youlanluxian, HttpServletRequest request){
    	youlanluxian.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(youlanluxian);
        youlanluxianService.insert(youlanluxian);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YoulanluxianEntity youlanluxian, HttpServletRequest request){
        //ValidatorUtils.validateEntity(youlanluxian);
        youlanluxianService.updateById(youlanluxian);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        youlanluxianService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
