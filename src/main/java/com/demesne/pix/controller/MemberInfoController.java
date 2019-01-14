package com.demesne.pix.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demesne.pix.dto.MemberInfoDTO;
import com.demesne.pix.service.MemberInfoService;


@RestController
@RequestMapping
public class MemberInfoController {
	
	@Autowired
	private MemberInfoService memberInfoService;
	
	@RequestMapping(value = "getUser/{userName}", method = RequestMethod.GET)
	public ResponseEntity<?> getMemberInfo(@PathVariable("userName") String userName) {
		return memberInfoService.getMemberInfo(userName);
	}
	
	@RequestMapping(value = "getAllUser", method = RequestMethod.GET)
	public ResponseEntity<?> getAllMemberInfo() {
		return memberInfoService.getAllMemberInfo();
	}
	
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ResponseEntity<?> postMemberInfo(@RequestBody MemberInfoDTO memberInfoDTO) {
		return memberInfoService.postMemberInfo(memberInfoDTO);
	}
	
	@RequestMapping(value = "deleteUser/{userName}", method = RequestMethod.PUT) 
		public ResponseEntity<?> deleteMemberInfo(@PathVariable("userName") String userName) {
			return memberInfoService.deleteMemberInfo(userName);
	}
	
	@RequestMapping(value = "editUser" , method = RequestMethod.PUT)
	public ResponseEntity<?> editMemberInfo(@RequestBody MemberInfoDTO memberInfoDTO){
		return memberInfoService.editMemberInfo(memberInfoDTO);
	}
    
}
