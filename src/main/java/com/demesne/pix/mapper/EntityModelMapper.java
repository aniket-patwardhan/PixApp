package com.demesne.pix.mapper;

import com.demesne.pix.dto.MemberInfoDTO;
import com.demesne.pix.jpa.MemberInfo;

public class EntityModelMapper {
	
	public static MemberInfoDTO memberEntityToModel(MemberInfo memberInfo) {
		MemberInfoDTO memberInfoDTO = new MemberInfoDTO();
		
		memberInfoDTO.setUserName(memberInfo.getUserName());
		memberInfoDTO.setFirstName(memberInfo.getFirstName());
		memberInfoDTO.setMiddleName(memberInfo.getMiddleName());
		memberInfoDTO.setLastName(memberInfo.getLastName());
		memberInfoDTO.setEmail(memberInfo.getEmail());
		memberInfoDTO.setPassword(memberInfo.getPassword());
		memberInfoDTO.setPhone(memberInfo.getPhone());
		memberInfoDTO.setSex(memberInfo.getSex());
		memberInfoDTO.setDob(memberInfo.getDob());
		memberInfoDTO.setRemoved(memberInfo.isRemoved());
		
		return memberInfoDTO;
	}
	
	
	
	public static MemberInfo memberModelToEntity (MemberInfoDTO memberInfoDTO) {
		MemberInfo memberInfo = new MemberInfo();
		
		return memberInfo;
	}

}
