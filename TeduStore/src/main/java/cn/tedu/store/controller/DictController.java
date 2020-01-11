package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Area;
import cn.tedu.store.bean.City;
import cn.tedu.store.bean.Province;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IDictService;

@RequestMapping("/dict")
@Controller
public class DictController extends BaseController{
	@Resource
	private IDictService dictService;
	@RequestMapping("/getArea.do")
	@ResponseBody
	public ResponseResult<List<Area>> getArea(String cityCode)
	{
		ResponseResult<List<Area>> rr = 
				new ResponseResult<List<Area>>();
		rr.setData(dictService.getArea(cityCode));
		
		return rr;
		
	}
	@RequestMapping("/getCity.do")
	@ResponseBody
	public ResponseResult<List<City>> getCity(String provinceCode){
		ResponseResult<List<City>> rr =
				new ResponseResult<List<City>>();
		rr.setData(dictService.getCity(provinceCode));
		
		return rr;
		
	}
	
	@RequestMapping("/getProvince.do")
	@ResponseBody
	public ResponseResult<List<Province>> getProvince(){
		ResponseResult<List<Province>> rr = 
				new ResponseResult<List<Province>>();
		List<Province> list = 
				dictService.getProvince();
		rr.setData(list);
		rr.setState(1);
		rr.setMessage("获取数据成功");
		
		return rr;
	}
}






