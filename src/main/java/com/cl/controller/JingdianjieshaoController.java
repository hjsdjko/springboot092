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

import com.cl.entity.JingdianjieshaoEntity;
import com.cl.entity.view.JingdianjieshaoView;

import com.cl.service.JingdianjieshaoService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 景点介绍
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-30 15:16:06
 */
@RestController
@RequestMapping("/jingdianjieshao")
public class JingdianjieshaoController {
    @Autowired
    private JingdianjieshaoService jingdianjieshaoService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingdianjieshaoEntity jingdianjieshao,
                @RequestParam(required = false) Double juliminsustart,
                @RequestParam(required = false) Double juliminsuend,
		HttpServletRequest request){
        EntityWrapper<JingdianjieshaoEntity> ew = new EntityWrapper<JingdianjieshaoEntity>();
                if(juliminsustart!=null) ew.ge("juliminsu", juliminsustart);
                if(juliminsuend!=null) ew.le("juliminsu", juliminsuend);

		PageUtils page = jingdianjieshaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdianjieshao), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingdianjieshaoEntity jingdianjieshao, 
                @RequestParam(required = false) Double juliminsustart,
                @RequestParam(required = false) Double juliminsuend,
		HttpServletRequest request){
        EntityWrapper<JingdianjieshaoEntity> ew = new EntityWrapper<JingdianjieshaoEntity>();
                if(juliminsustart!=null) ew.ge("juliminsu", juliminsustart);
                if(juliminsuend!=null) ew.le("juliminsu", juliminsuend);

		PageUtils page = jingdianjieshaoService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdianjieshao), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingdianjieshaoEntity jingdianjieshao){
       	EntityWrapper<JingdianjieshaoEntity> ew = new EntityWrapper<JingdianjieshaoEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingdianjieshao, "jingdianjieshao")); 
        return R.ok().put("data", jingdianjieshaoService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingdianjieshaoEntity jingdianjieshao){
        EntityWrapper< JingdianjieshaoEntity> ew = new EntityWrapper< JingdianjieshaoEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingdianjieshao, "jingdianjieshao")); 
		JingdianjieshaoView jingdianjieshaoView =  jingdianjieshaoService.selectView(ew);
		return R.ok("查询景点介绍成功").put("data", jingdianjieshaoView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingdianjieshaoEntity jingdianjieshao = jingdianjieshaoService.selectById(id);
		jingdianjieshao = jingdianjieshaoService.selectView(new EntityWrapper<JingdianjieshaoEntity>().eq("id", id));
        return R.ok().put("data", jingdianjieshao);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingdianjieshaoEntity jingdianjieshao = jingdianjieshaoService.selectById(id);
		jingdianjieshao = jingdianjieshaoService.selectView(new EntityWrapper<JingdianjieshaoEntity>().eq("id", id));
        return R.ok().put("data", jingdianjieshao);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingdianjieshaoEntity jingdianjieshao, HttpServletRequest request){
    	jingdianjieshao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingdianjieshao);
        jingdianjieshaoService.insert(jingdianjieshao);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingdianjieshaoEntity jingdianjieshao, HttpServletRequest request){
    	jingdianjieshao.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jingdianjieshao);
        jingdianjieshaoService.insert(jingdianjieshao);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JingdianjieshaoEntity jingdianjieshao, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingdianjieshao);
        jingdianjieshaoService.updateById(jingdianjieshao);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingdianjieshaoService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
