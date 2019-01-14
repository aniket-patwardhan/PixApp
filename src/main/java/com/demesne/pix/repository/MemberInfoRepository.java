package com.demesne.pix.repository;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.demesne.pix.jpa.MemberInfo;



public interface MemberInfoRepository extends CrudRepository<MemberInfo, String> {
	
	@Query("select mem from memberInfo mem "
			+ "where mem.userName = ?1 AND  mem.isRemoved = false")		
	  public Stream<MemberInfo> streamGetMemberInfo(String userName);

	@Query("select mem from memberInfo mem "
			+ "where mem.isRemoved = false")
	  public Stream<MemberInfo> streamGetAllMemberInfo();
	
	@Query("select mem from memberInfo mem " 
		 + " where mem.userName = ?1 " )
	  public MemberInfo streamDeleteMemberInfo(String userName);
	
	@Query("select mem from memberInfo mem " 
			 + " where mem.userName = ?1 " )
	  public MemberInfo streameditMemberInfo(String userName);
}
