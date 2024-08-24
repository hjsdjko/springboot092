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

import com.cl.entity.DaoyoufuwuEntity;
import com.cl.entity.view.DaoyoufuwuView;

import com.cl.service.DaoyoufuwuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 导游服务
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
@RestController
@RequestMapping("/daoyoufuwu")
public class DaoyoufuwuController {
    @Autowired
    private DaoyoufuwuService daoyoufuwuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DaoyoufuwuEntity daoyoufuwu,
		HttpServletRequest request){
        EntityWrapper<DaoyoufuwuEntity> ew = new EntityWrapper<DaoyoufuwuEntity>();

		PageUtils page = daoyoufuwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daoyoufuwu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DaoyoufuwuEntity daoyoufuwu, 
		HttpServletRequest request){
        EntityWrapper<DaoyoufuwuEntity> ew = new EntityWrapper<DaoyoufuwuEntity>();

		PageUtils page = daoyoufuwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daoyoufuwu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DaoyoufuwuEntity daoyoufuwu){
       	EntityWrapper<DaoyoufuwuEntity> ew = new EntityWrapper<DaoyoufuwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( daoyoufuwu, "daoyoufuwu")); 
        return R.ok().put("data", daoyoufuwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DaoyoufuwuEntity daoyoufuwu){
        EntityWrapper< DaoyoufuwuEntity> ew = new EntityWrapper< DaoyoufuwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( daoyoufuwu, "daoyoufuwu")); 
		DaoyoufuwuView daoyoufuwuView =  daoyoufuwuService.selectView(ew);
		return R.ok("查询导游服务成功").put("data", daoyoufuwuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DaoyoufuwuEntity daoyoufuwu = daoyoufuwuService.selectById(id);
		daoyoufuwu = daoyoufuwuService.selectView(new EntityWrapper<DaoyoufuwuEntity>().eq("id", id));
        return R.ok().put("data", daoyoufuwu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DaoyoufuwuEntity daoyoufuwu = daoyoufuwuService.selectById(id);
		daoyoufuwu = daoyoufuwuService.selectView(new EntityWrapper<DaoyoufuwuEntity>().eq("id", id));
        return R.ok().put("data", daoyoufuwu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DaoyoufuwuEntity daoyoufuwu, HttpServletRequest request){
    	daoyoufuwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(daoyoufuwu);
        daoyoufuwuService.insert(daoyoufuwu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DaoyoufuwuEntity daoyoufuwu, HttpServletRequest request){
    	daoyoufuwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(daoyoufuwu);
        daoyoufuwuService.insert(daoyoufuwu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DaoyoufuwuEntity daoyoufuwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(daoyoufuwu);
        daoyoufuwuService.updateById(daoyoufuwu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        daoyoufuwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
