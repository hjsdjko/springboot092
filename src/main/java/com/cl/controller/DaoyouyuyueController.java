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

import com.cl.entity.DaoyouyuyueEntity;
import com.cl.entity.view.DaoyouyuyueView;

import com.cl.service.DaoyouyuyueService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 导游预约
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
@RestController
@RequestMapping("/daoyouyuyue")
public class DaoyouyuyueController {
    @Autowired
    private DaoyouyuyueService daoyouyuyueService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DaoyouyuyueEntity daoyouyuyue,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			daoyouyuyue.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<DaoyouyuyueEntity> ew = new EntityWrapper<DaoyouyuyueEntity>();

		PageUtils page = daoyouyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daoyouyuyue), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DaoyouyuyueEntity daoyouyuyue, 
		HttpServletRequest request){
        EntityWrapper<DaoyouyuyueEntity> ew = new EntityWrapper<DaoyouyuyueEntity>();

		PageUtils page = daoyouyuyueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, daoyouyuyue), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DaoyouyuyueEntity daoyouyuyue){
       	EntityWrapper<DaoyouyuyueEntity> ew = new EntityWrapper<DaoyouyuyueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( daoyouyuyue, "daoyouyuyue")); 
        return R.ok().put("data", daoyouyuyueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DaoyouyuyueEntity daoyouyuyue){
        EntityWrapper< DaoyouyuyueEntity> ew = new EntityWrapper< DaoyouyuyueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( daoyouyuyue, "daoyouyuyue")); 
		DaoyouyuyueView daoyouyuyueView =  daoyouyuyueService.selectView(ew);
		return R.ok("查询导游预约成功").put("data", daoyouyuyueView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DaoyouyuyueEntity daoyouyuyue = daoyouyuyueService.selectById(id);
		daoyouyuyue = daoyouyuyueService.selectView(new EntityWrapper<DaoyouyuyueEntity>().eq("id", id));
        return R.ok().put("data", daoyouyuyue);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DaoyouyuyueEntity daoyouyuyue = daoyouyuyueService.selectById(id);
		daoyouyuyue = daoyouyuyueService.selectView(new EntityWrapper<DaoyouyuyueEntity>().eq("id", id));
        return R.ok().put("data", daoyouyuyue);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DaoyouyuyueEntity daoyouyuyue, HttpServletRequest request){
    	daoyouyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(daoyouyuyue);
        daoyouyuyueService.insert(daoyouyuyue);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DaoyouyuyueEntity daoyouyuyue, HttpServletRequest request){
    	daoyouyuyue.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(daoyouyuyue);
        daoyouyuyueService.insert(daoyouyuyue);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DaoyouyuyueEntity daoyouyuyue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(daoyouyuyue);
        daoyouyuyueService.updateById(daoyouyuyue);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        daoyouyuyueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
