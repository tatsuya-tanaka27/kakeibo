package com.example.kakeibo.bean;

import java.io.Serializable;
import java.util.List;

import com.example.kakeibo.entity.KakeiboData;
import com.example.kakeibo.entity.KakeiboUser;

/**
 * 家計簿画面用のフォームクラス
 * @author nanak
 *
 */
public class KakeiboFormBean implements Serializable {

	/** 家計簿ユーザー情報 */
	private KakeiboUser kakeiboUser;

	/** 家計簿データリスト */
	private List<KakeiboData> kakeiboDataList;

	/**
	 * 家計簿ユーザー情報を取得
	 * @return kakeiboUser
	 */
	public KakeiboUser getKakeiboUser() {
		return kakeiboUser;
	}

	/**
	 * 家計簿ユーザー情報を設定
	 * @param kakeiboUser
	 */
	public void setKakeiboUser(KakeiboUser kakeiboUser) {
		this.kakeiboUser = kakeiboUser;
	}

	/**
	 * 家計簿データリストを取得
	 * @return kakeiboDataList
	 */
	public  List<KakeiboData> getKakeiboDataList() {
		return kakeiboDataList;
	}

	/**
	 * 家計簿データリストを設定
	 * @param kakeiboDataList
	 */
	public void setKakeiboDataList( List<KakeiboData> kakeiboDataList) {
		this.kakeiboDataList = kakeiboDataList;
	}

}
