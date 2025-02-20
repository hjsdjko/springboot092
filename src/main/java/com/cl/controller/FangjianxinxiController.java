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

import com.cl.entity.FangjianxinxiEntity;
import com.cl.entity.view.FangjianxinxiView;

import com.cl.service.FangjianxinxiService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 房间信息
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
@RestController
@RequestMapping("/fangjianxinxi")
public class FangjianxinxiController {
    @Autowired
    private FangjianxinxiService fangjianxinxiService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FangjianxinxiEntity fangjianxinxi,
		HttpServletRequest request){
        EntityWrapper<FangjianxinxiEntity> ew = new EntityWrapper<FangjianxinxiEntity>();

		PageUtils page = fangjianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangjianxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FangjianxinxiEntity fangjianxinxi, 
		HttpServletRequest request){
        EntityWrapper<FangjianxinxiEntity> ew = new EntityWrapper<FangjianxinxiEntity>();

		PageUtils page = fangjianxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fangjianxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FangjianxinxiEntity fangjianxinxi){
       	EntityWrapper<FangjianxinxiEntity> ew = new EntityWrapper<FangjianxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fangjianxinxi, "fangjianxinxi")); 
        return R.ok().put("data", fangjianxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FangjianxinxiEntity fangjianxinxi){
        EntityWrapper< FangjianxinxiEntity> ew = new EntityWrapper< FangjianxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fangjianxinxi, "fangjianxinxi")); 
		FangjianxinxiView fangjianxinxiView =  fangjianxinxiService.selectView(ew);
		return R.ok("查询房间信息成功").put("data", fangjianxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FangjianxinxiEntity fangjianxinxi = fangjianxinxiService.selectById(id);
		fangjianxinxi = fangjianxinxiService.selectView(new EntityWrapper<FangjianxinxiEntity>().eq("id", id));
        return R.ok().put("data", fangjianxinxi);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FangjianxinxiEntity fangjianxinxi = fangjianxinxiService.selectById(id);
		fangjianxinxi = fangjianxinxiService.selectView(new EntityWrapper<FangjianxinxiEntity>().eq("id", id));
        return R.ok().put("data", fangjianxinxi);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FangjianxinxiEntity fangjianxinxi, HttpServletRequest request){
    	fangjianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangjianxinxi);
        fangjianxinxiService.insert(fangjianxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FangjianxinxiEntity fangjianxinxi, HttpServletRequest request){
    	fangjianxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(fangjianxinxi);
        fangjianxinxiService.insert(fangjianxinxi);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FangjianxinxiEntity fangjianxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fangjianxinxi);
        fangjianxinxiService.updateById(fangjianxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fangjianxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
