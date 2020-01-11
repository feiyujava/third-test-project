package cn.tedu.store.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.store.bean.Address;
import cn.tedu.store.mapper.AddressMapper;
import cn.tedu.store.mapper.DictMapper;
@Service
public class AddressService implements IAddressService{
	@Resource
	private AddressMapper addressMapper;
	@Resource
	private DictMapper dictMapper;
		
	public void addAddress(Address address) {
		//1.调用dictMapper持久层的3个selectXXName(),获取来的值用+连接起来,作为以下方法的参数,传进去
		String strP = dictMapper.selectProvinceNameByCode(
				address.getRecvProvince());
		String strC = dictMapper.selectCityNameByCode(
				address.getRecvCity());
		String strA = dictMapper.selectAreaNameByCode(
				address.getRecvArea());
		address.setRecvDistrict(strP+strC+strA);

		//2.调用addressMapper.selectAddressByUid(),返回list,调用size()方法,如果==0,addess.setIsDefault(1);否则addess.setIsDefault(0);
		List<Address> list =
				addressMapper.selectAddressByUid(
						address.getUid());
		if(list.size()==0){
			address.setIsDefault(1);
		}else{
			address.setIsDefault(0);
		}
		
		//3.插入数据
		addressMapper.insertAddress(address);
		
	}

	public List<Address> getAddressByUid(Integer uid) {
		
		return addressMapper.selectAddressByUid(uid);
	}

	public void setDefault(Integer uid, Integer id) {
		Integer n1 = addressMapper.setCancel(uid);
		if(n1==0){
			throw new RuntimeException("数据不存在");
		}
		Integer n2 = addressMapper.setDefault(id);
		if(n2==0){
			throw new RuntimeException("数据不存在");
		}
		
	}

	public Address getAddressById(Integer id) {
		
		return addressMapper.selectAddressById(id);
	}

	public void updateAddress(Address address) {

		address.setRecvDistrict(
				dictMapper.selectProvinceNameByCode(address.getRecvProvince())+
				dictMapper.selectCityNameByCode(address.getRecvCity())+
				dictMapper.selectAreaNameByCode(address.getRecvArea()));
			
		addressMapper.udpateAddressById(address);
		
	}

	public void deleteAddress(Integer id) {
		addressMapper.deleteAddressById(id);
		
	}

}





