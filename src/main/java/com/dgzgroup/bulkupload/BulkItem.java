package com.dgzgroup.bulkupload;

public class BulkItem {

      
      private String policyNum;
      private String policyName;
      private String primaryEmail;
      private String secondaryEmail;
      private String accountNum;
      
	
	public String getPolicyNum() {
		return policyNum;
	}
	public void setPolicyNum(String policyNum) {
		this.policyNum = policyNum;
	}
	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPrimaryEmail() {
		return primaryEmail;
	}
	public void setPrimaryEmail(String primaryEmail) {
		this.primaryEmail = primaryEmail;
	}
	public String getSecondaryEmail() {
		return secondaryEmail;
	}
	public void setSecondaryEmail(String secondaryEmail) {
		this.secondaryEmail = secondaryEmail;
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	@Override
	public String toString() {
		return "BulkItem [policyNum=" + policyNum + ", policyName="
				+ policyName + ", primaryEmail=" + primaryEmail
				+ ", secondaryEmail=" + secondaryEmail + ", accountNum="
				+ accountNum + "]";
	}
      
      
}
