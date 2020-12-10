package com.example.kakeibo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kakeibo.entity.KakeiboData;
import com.example.kakeibo.entity.KakeiboUser;
import com.example.kakeibo.repository.KakeiboDataRepository;
import com.example.kakeibo.repository.KakeiboUserRepository;

/**
 * トップ画面サービスクラス
 * @author nanak
 *
 */
@Service
@Transactional
public class TopService {

	@SuppressWarnings("unused")
	@Autowired
	private KakeiboUserRepository kakeiboUserRepository;

	@SuppressWarnings("unused")
	@Autowired
	private KakeiboDataRepository kakeiboDataRepository;

	/**
	 * @return
	 */
	public KakeiboUser getUser(){
		return kakeiboUserRepository.getUser();

	}

	/**
	 * @param id
	 * @return
	 */
	public List<KakeiboData> getDataList(String id) {
		return kakeiboDataRepository.getDataList(id);
	}

}
