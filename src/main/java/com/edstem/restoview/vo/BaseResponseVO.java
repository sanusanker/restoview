package com.edstem.restoview.vo;

	
	public class BaseResponseVO {

		private Boolean status;
		private String errMsg;
		public Boolean getStatus() {
			return status;
		}
		public void setStatus(Boolean status) {
			this.status = status;
		}
		public String getErrMsg() {
			return errMsg;
		}
		public void setErrMsg(String errMsg) {
			this.errMsg = errMsg;
		}
		
	}
