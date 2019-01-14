package com.demesne.pix.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.demesne.pix.dto.MemberInfoDTO;
import com.demesne.pix.jpa.MemberInfo;
import com.demesne.pix.mapper.EntityModelMapper;
import com.demesne.pix.repository.MemberInfoRepository;


@Service
public class MemberInfoService {
	
	@Autowired
	private MemberInfoRepository memberInfoRespository;
	
	@Autowired
	private EntityManager entityManager;
	
	@Transactional
	public ResponseEntity<?> getMemberInfo(String userName) {
		ResponseEntity<List<MemberInfoDTO>> responseEntity;
		try {
			Stream<MemberInfo> memberInfos = memberInfoRespository.streamGetMemberInfo(userName);
			List<MemberInfoDTO> memberInfoDTOs = memberInfos.map(EntityModelMapper::memberEntityToModel).collect(Collectors.toList());
			responseEntity = ResponseEntity.ok(memberInfoDTOs);
		} catch (Exception ex) {
			responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(null);
		}
			
		return responseEntity;
		}
	
	@Transactional
	public ResponseEntity<?> getAllMemberInfo() {
		ResponseEntity<List<MemberInfoDTO>> responseEntity;
		try {
			Stream<MemberInfo> memberInfos = memberInfoRespository.streamGetAllMemberInfo();
			List<MemberInfoDTO> memberInfoDTOs = memberInfos.map(EntityModelMapper::memberEntityToModel).collect(Collectors.toList());
			responseEntity = ResponseEntity.ok(memberInfoDTOs);
		} catch (Exception ex) {
			responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body(null);
		}
			
		return responseEntity;
		}
	
	
	@Transactional
	public ResponseEntity<?> postMemberInfo(MemberInfoDTO memberInfoDTO) {
		ResponseEntity<?> responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		MemberInfo memberInfo = new MemberInfo();
		try {
           
			memberInfo.setUserName(memberInfoDTO.getUserName());
			memberInfo.setFirstName(memberInfoDTO.getFirstName());
			memberInfo.setMiddleName(memberInfoDTO.getMiddleName());
			memberInfo.setLastName(memberInfoDTO.getLastName());
			memberInfo.setEmail(memberInfoDTO.getEmail());
			memberInfo.setPassword(memberInfoDTO.getPassword());
			memberInfo.setPhone(memberInfoDTO.getPhone());
			memberInfo.setSex(memberInfoDTO.getSex());
			memberInfo.setDob(memberInfoDTO.getDob());
			memberInfo.setRemoved(false);
		
            entityManager.persist(memberInfo);  
		
            responseEntity = ResponseEntity.ok(EntityModelMapper.memberEntityToModel(memberInfo));
           }catch (Exception ex) {
        	   responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
           }
           return responseEntity;
}
	
	@Transactional
	public ResponseEntity<?> deleteMemberInfo(String userName) {
		 ResponseEntity<?> responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		MemberInfo memberInfo =memberInfoRespository.streamDeleteMemberInfo(userName);
		try {
			memberInfo.setRemoved(true);
            responseEntity = ResponseEntity.ok(EntityModelMapper.memberEntityToModel(memberInfo));
           }catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
                                }
			
		return responseEntity;
		}
	
	@Transactional
	public ResponseEntity<?> editMemberInfo(MemberInfoDTO memberInfoDTO) {
		 ResponseEntity<?> responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		MemberInfo memberInfo =memberInfoRespository.streameditMemberInfo(memberInfoDTO.getUserName());
		try {
			memberInfo.setFirstName(memberInfoDTO.getFirstName());
			
			entityManager.merge(memberInfo);
            responseEntity = ResponseEntity.ok(EntityModelMapper.memberEntityToModel(memberInfo));
           }catch (Exception e) {
            responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
                                }
			
		return responseEntity;
		}
	
}
           

	

	
	



