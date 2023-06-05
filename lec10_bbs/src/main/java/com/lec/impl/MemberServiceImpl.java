package com.lec.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.lec.domain.member.Member;
import com.lec.repository.MemberRepository;
import com.lec.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberRepository memberRepository;	
	
	public Member getMember(Member member) {
		Optional<Member> findMember = memberRepository.findById(member.getId());
		if(findMember.isPresent())
			return findMember.get();
		else return null;
	}
	
	@Override
	public long getTotalRowCount(Member member) {
		return memberRepository.count();
	}

	@Override // https://howtodoinjava.com/spring-boot2/pagination-sorting-example/
	public Page<Member> getMemberList(Pageable pageable, String searchType, String searchWord) {		
		if(searchType.equalsIgnoreCase("id")) {
			return memberRepository.findByIdContaining(searchWord, pageable);
		} else {
			return memberRepository.findByNameContaining(searchWord, pageable);
		}
	}

	@Override
	public void insertMember(Member member) {
		memberRepository.save(member);
	}
	
	@Override
	public void deleteMember(Member member) {
		memberRepository.deleteById(member.getId());
	}

	@Override
	public void updateMember(Member member) {
		memberRepository.save(member);		
	}
}
