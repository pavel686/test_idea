package com.cblue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cblue.pojo.Page;
import com.cblue.pojo.User;
import com.cblue.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;

	//test git
	
	@RequestMapping("show")
	public String show(){
		System.out.println("show");
		return "show";
	}

	@RequestMapping("page")
	@ResponseBody
	public PageInfo page2(@RequestParam(value="page",defaultValue="1") int currentPage,
			@RequestParam(value="rows",defaultValue="2")int pageSize,String key){
		//1
		PageHelper.startPage(currentPage, pageSize);
		
		
		List<User> list = null;
		//2
		if(key==null){
			list = userService.getAll();
			
		}else{
			list = userService.getByLike(key);
		}
		
		//3
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		
		/*Page page = new Page();
		page.setTotal(pageInfo.getTotal());
		page.setRows(pageInfo.getList());*/
	
		return pageInfo;
	}
	
	
	@RequestMapping("goAdd")
	public String goAdd(){
		System.out.println("--goadd--");
		return "add";
	}
	
	@RequestMapping("add")
	@ResponseBody
	public String add(@RequestBody User user){
		System.out.println("--add--");
		System.out.println("user="+user);
		userService.save(user);
		return "true";
	}
	
	@RequestMapping("goUpdate")
	@ResponseBody
	public User goUpdate(int id){
		System.out.println("--update--"+id);
		User user = userService.getUserById(id);
		System.out.println("goUpdate -user="+user);
		return user;
	}
	
	@RequestMapping("update")
	@ResponseBody
	public String update(@RequestBody User user){
		System.out.println("--update--"+user);
		return "true";
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public String delete(int[] ids){
		System.out.println("--delete--");
		for(int id:ids){
			System.out.println(id);
		}
		return "delete";
	}
	
	
	

}
