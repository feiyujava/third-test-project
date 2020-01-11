package cn.tedu.store.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.tedu.store.bean.Address;
import cn.tedu.store.bean.ResponseResult;
import cn.tedu.store.service.IAddressService;

@RequestMapping("/address")
@Controller
public class AddressController extends BaseController{
	@Resource
	private IAddressService addressService;
	
	@RequestMapping("/showAddress.do")
	public String showAddress(){
		return "addressAdmin";
	}
	@RequestMapping("/deleteAddress.do")
	@ResponseBody
	public ResponseResult<Void> deleteAddress(Integer id){
		ResponseResult<Void> rr =
				new ResponseResult<Void>();
		addressService.deleteAddress(id);
		rr.setState(1);
		rr.setMessage("删除成功");
		return rr;
	}
	
	@RequestMapping("/updateAddress.do")
	@ResponseBody
	public ResponseResult<Void> updateAddress(
			Integer id,
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") Integer recvZip,
			@RequestParam("addressName") String recvTag){
		ResponseResult<Void> rr =
				new ResponseResult<Void>();
		Address address = new Address();
		address.setId(id);
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddress(recvAddress);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		addressService.updateAddress(address);
		
		rr.setState(1);
		rr.setMessage("修改成功");
		
		return rr;
	}
	
	@RequestMapping("/goUpdate.do")
	@ResponseBody
	public ResponseResult<Address> goUpdate(Integer id){
		ResponseResult<Address> rr = 
				new ResponseResult<Address>();
		Address address = addressService.getAddressById(id);
		
		
		rr.setData(address);
		
		return rr;
	}
	
	@RequestMapping("/setDefault.do")
	@ResponseBody
	public ResponseResult<Void> setDefault(HttpSession session ,Integer id){
		ResponseResult<Void> rr =
				new ResponseResult<Void>();
		
		try{
			addressService.setDefault(this.getId(session), id);
			rr.setState(1);
			rr.setMessage("修改成功");
		}catch(RuntimeException e){
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
		return rr;
	}
	
	@RequestMapping("/getAddressByUid.do")
	@ResponseBody
	public ResponseResult<List<Address>> getAddressByUid(HttpSession session){
		ResponseResult<List<Address>> rr = 
				new ResponseResult<List<Address>>();
		try{
			List<Address> list = 
					addressService.getAddressByUid(this.getId(session));
			rr.setData(list);
			rr.setState(1);
			rr.setMessage("获取数据成功");
		}catch(RuntimeException e){
			rr.setState(0);
			rr.setMessage(e.getMessage());
		}
		
		return rr;
				
	}
	
	@RequestMapping("/addAddress.do")
	@ResponseBody
	public ResponseResult<Void> addAddress(HttpSession session,
			@RequestParam("receiverName") String recvName,
			@RequestParam("receiverState") String recvProvince,
			@RequestParam("receiverCity") String recvCity,
			@RequestParam("receiverDistrict") String recvArea,
			@RequestParam("receiverAddress") String recvAddress,
			@RequestParam("receiverMobile") String recvPhone,
			@RequestParam("receiverPhone") String recvTel,
			@RequestParam("receiverZip") Integer recvZip,
			@RequestParam("addressName") String recvTag){
		
		ResponseResult<Void> rr = 
				new ResponseResult<Void>();
		Address address = new Address();
		address.setUid(this.getId(session));
		address.setRecvName(recvName);
		address.setRecvProvince(recvProvince);
		address.setRecvCity(recvCity);
		address.setRecvArea(recvArea);
		address.setRecvAddress(recvAddress);
		address.setRecvPhone(recvPhone);
		address.setRecvTel(recvTel);
		address.setRecvZip(recvZip);
		address.setRecvTag(recvTag);
		
		addressService.addAddress(address);
		
		rr.setState(1);
		rr.setMessage("添加数据成功");
		
		return rr;
		
	}
	
	
}







