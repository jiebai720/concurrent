package com.bb;

import java.io.Serializable;


/**
 * 
 * @author Baijie
 *
 */
public class CardMarketInfoBean implements Serializable{


	//活动名称 用于页面展示
	private String activityName;
	//活动编码
	private String activityNum;
	//活动开始时间
	private String actBeginTime;
	//活动截止时间
	private String actEndTime;
	//卡券面额
	private String cardDenomination;
	//品类编码
	private String categoryNum;
	//品类名称，用于页面展示：流量券  话费券
	private String categoryName;
	//卡券内容
	private String cardContent;
	//卡券说明
	private String cardExplain;
	//活动状态  0：正常  1：下线
	private int actStatus;

	public int getActStatus() {
		return actStatus;
	}

	public void setActStatus(int actStatus) {
		this.actStatus = actStatus;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getActivityNum() {
		return activityNum;
	}

	public void setActivityNum(String activityNum) {
		this.activityNum = activityNum;
	}

	public String getActBeginTime() {
		return actBeginTime;
	}

	public void setActBeginTime(String actBeginTime) {
		this.actBeginTime = actBeginTime;
	}

	public String getActEndTime() {
		return actEndTime;
	}

	public void setActEndTime(String actEndTime) {
		this.actEndTime = actEndTime;
	}

	public String getCardDenomination() {
		return cardDenomination;
	}

	public void setCardDenomination(String cardDenomination) {
		this.cardDenomination = cardDenomination;
	}

	public String getCategoryNum() {
		return categoryNum;
	}

	public void setCategoryNum(String categoryNum) {
		this.categoryNum = categoryNum;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCardContent() {
		return cardContent;
	}

	public void setCardContent(String cardContent) {
		this.cardContent = cardContent;
	}

	public String getCardExplain() {
		return cardExplain;
	}

	public void setCardExplain(String cardExplain) {
		this.cardExplain = cardExplain;
	}








}
