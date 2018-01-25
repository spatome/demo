/**   
 * Copyright © 2017 恒朋科技. All rights reserved.
 * 
 * @Title: WxBill.java 
 * @Prject: demo-wx
 * @Package: com.spatome.util.wx 
 * @Description: TODO
 * @author: zhangwei   
 * @date: 2017年12月25日 上午10:49:40 
 * @version: V1.0   
 */
package com.spatome.util.wx;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: WxBill
 * @Description: TODO
 * @author: zhangwei
 * @date: 2017年12月25日 上午10:49:40
 */
public class WxBill {

	private String totalCount;
	private String totalAmount;
	private String totalBackAmount;
	private String totalRedPacketBackAmount;
	private String totalFee;
	
	private List<BillBean> list;

	public String getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}

	public String getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTotalBackAmount() {
		return totalBackAmount;
	}

	public void setTotalBackAmount(String totalBackAmount) {
		this.totalBackAmount = totalBackAmount;
	}

	public String getTotalRedPacketBackAmount() {
		return totalRedPacketBackAmount;
	}

	public void setTotalRedPacketBackAmount(String totalRedPacketBackAmount) {
		this.totalRedPacketBackAmount = totalRedPacketBackAmount;
	}

	public String getTotalFee() {
		return totalFee;
	}

	public void setTotalFee(String totalFee) {
		this.totalFee = totalFee;
	}

	public List<BillBean> getList() {
		if(list==null){
			list = new ArrayList<BillBean>();
		}
		return list;
	}

	public void setList(List<BillBean> list) {
		this.list = list;
	}

	public static class BillBean {
		// 交易时间
		private String onDate;
		// 公众账号ID
		private String appId;
		// 商户号
		private String mcdId;
		// 微信订单号
		private String wxOrderNo;
		// 商户订单号
		private String myOrderNo;
		// 用户标识
		private String userId;
		// 交易类型
		private String payType;
		// 交易状态
		private String payStatus;
		// 支付银行
		private String payBankNo;
		// 货币种类
		private String moneyType;
		// 总金额
		private String totalAmount;
		// 企业红包金额
		private String myRedPacketAmount;
		// 微信退款单号
		private String wxPayBackOrderNo;
		// 商户退款单号
		private String myPayBackOrderNo;
		// 退款金额
		private String payBackAmount;
		// 企业红包退款金额
		private String myRedPacketBackAmount;
		//退款状态
		private String payBackStatus;
		//退款类型
		private String payBackType;
		// 商品名称
		private String payItemName;
		// 手续费
		private String wxFee;
		// 费率
		private String wxFeeRate;

		public String getOnDate() {
			return onDate;
		}

		public void setOnDate(String onDate) {
			this.onDate = onDate;
		}

		public String getAppId() {
			return appId;
		}

		public void setAppId(String appId) {
			this.appId = appId;
		}

		public String getMcdId() {
			return mcdId;
		}

		public void setMcdId(String mcdId) {
			this.mcdId = mcdId;
		}

		public String getWxOrderNo() {
			return wxOrderNo;
		}

		public void setWxOrderNo(String wxOrderNo) {
			this.wxOrderNo = wxOrderNo;
		}

		public String getMyOrderNo() {
			return myOrderNo;
		}

		public void setMyOrderNo(String myOrderNo) {
			this.myOrderNo = myOrderNo;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getPayType() {
			return payType;
		}

		public void setPayType(String payType) {
			this.payType = payType;
		}

		public String getPayStatus() {
			return payStatus;
		}

		public void setPayStatus(String payStatus) {
			this.payStatus = payStatus;
		}

		public String getPayBankNo() {
			return payBankNo;
		}

		public void setPayBankNo(String payBankNo) {
			this.payBankNo = payBankNo;
		}

		public String getMoneyType() {
			return moneyType;
		}

		public void setMoneyType(String moneyType) {
			this.moneyType = moneyType;
		}

		public String getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(String totalAmount) {
			this.totalAmount = totalAmount;
		}

		public String getWxPayBackOrderNo() {
			return wxPayBackOrderNo;
		}

		public void setWxPayBackOrderNo(String wxPayBackOrderNo) {
			this.wxPayBackOrderNo = wxPayBackOrderNo;
		}

		public String getMyPayBackOrderNo() {
			return myPayBackOrderNo;
		}

		public void setMyPayBackOrderNo(String myPayBackOrderNo) {
			this.myPayBackOrderNo = myPayBackOrderNo;
		}

		public String getPayBackAmount() {
			return payBackAmount;
		}

		public void setPayBackAmount(String payBackAmount) {
			this.payBackAmount = payBackAmount;
		}

		public String getPayItemName() {
			return payItemName;
		}

		public void setPayItemName(String payItemName) {
			this.payItemName = payItemName;
		}

		public String getWxFee() {
			return wxFee;
		}

		public void setWxFee(String wxFee) {
			this.wxFee = wxFee;
		}

		public String getWxFeeRate() {
			return wxFeeRate;
		}

		public void setWxFeeRate(String wxFeeRate) {
			this.wxFeeRate = wxFeeRate;
		}

		public String getMyRedPacketAmount() {
			return myRedPacketAmount;
		}

		public void setMyRedPacketAmount(String myRedPacketAmount) {
			this.myRedPacketAmount = myRedPacketAmount;
		}

		public String getMyRedPacketBackAmount() {
			return myRedPacketBackAmount;
		}

		public void setMyRedPacketBackAmount(String myRedPacketBackAmount) {
			this.myRedPacketBackAmount = myRedPacketBackAmount;
		}

		public String getPayBackStatus() {
			return payBackStatus;
		}

		public void setPayBackStatus(String payBackStatus) {
			this.payBackStatus = payBackStatus;
		}

		public String getPayBackType() {
			return payBackType;
		}

		public void setPayBackType(String payBackType) {
			this.payBackType = payBackType;
		}

		@Override
		public String toString() {
			return "BillBean [onDate=" + onDate + ", appId=" + appId + ", mcdId=" + mcdId + ", wxOrderNo=" + wxOrderNo
					+ ", myOrderNo=" + myOrderNo + ", userId=" + userId + ", payType=" + payType + ", payStatus="
					+ payStatus + ", payBankNo=" + payBankNo + ", moneyType=" + moneyType + ", totalAmount="
					+ totalAmount + ", myRedPacketAmount=" + myRedPacketAmount + ", wxPayBackOrderNo="
					+ wxPayBackOrderNo + ", myPayBackOrderNo=" + myPayBackOrderNo + ", payBackAmount=" + payBackAmount
					+ ", myRedPacketBackAmount=" + myRedPacketBackAmount + ", payBackStatus=" + payBackStatus
					+ ", payBackType=" + payBackType + ", payItemName=" + payItemName + ", wxFee=" + wxFee
					+ ", wxFeeRate=" + wxFeeRate + "]";
		}
	}

	@Override
	public String toString() {
		return "WxBill [totalCount=" + totalCount + ", totalAmount=" + totalAmount + ", totalBackAmount="
				+ totalBackAmount + ", totalRedPacketBackAmount=" + totalRedPacketBackAmount + ", totalFee=" + totalFee
				+ ", list=" + list + "]";
	}

	public static void main(String[] args) {
		String wxContent = "﻿交易时间,公众账号ID,商户号,子商户号,设备号,微信订单号,商户订单号,用户标识,交易类型,交易状态,付款银行,货币种类,总金额,企业红包金额,微信退款单号,商户退款单号,退款金额,企业红包退款金额,退款类型,退款状态,商品名称,商户数据包,手续费,费率"
				+"`2017-12-18 07:34:21,`wx52aef4ac5f04e8cd,`1269536001,`0,`,`4200000031201712186240710040,`20171218073413581494,`o_CXdw9k8UofrTmiyQCz0i2An4Qw,`JSAPI,`SUCCESS,`CFT,`CNY,`2.00,`0.00,`0,`0,`0.00,`0.00,`,`,`支付扣款,`,`0.02000,`1.00%"
				+"`2017-12-18 17:55:05,`wx52aef4ac5f04e8cd,`1269536001,`0,`,`4200000050201712186629093973,`20171218175458489426,`o_CXdwx5TmMn3BpWe7kN46W-tu4c,`JSAPI,`SUCCESS,`CFT,`CNY,`2.00,`0.00,`0,`0,`0.00,`0.00,`,`,`支付扣款,`,`0.02000,`1.00%"
				+"总交易单数,总交易额,总退款金额,总企业红包退款金额,手续费总金额"
				+"`72,`582.00,`0.00,`0.00,`5.82000";
		String[] contentLines = wxContent.split("\r\n");

		for (String string : contentLines) {
			System.out.println("==:"+string);
		}
	}
}
