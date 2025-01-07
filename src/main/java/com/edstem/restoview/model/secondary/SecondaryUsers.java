package com.edstem.restoview.model.secondary;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users", schema = "restaurantManagement")
public class SecondaryUsers {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "user_id", nullable = false)
	    private Short userId;

	    @Column(name = "user_name", length = 50)
	    private String userName;

	    @Column(name = "password", length = 150)
	    private String password;

	    @Column(name = "last_updated_by_login_id")
	    private Short lastUpdatedByLoginId;

		public Short getUserId() {
			return userId;
		}

		public void setUserId(Short userId) {
			this.userId = userId;
		}

		public String getUserName() {
			return userName;
		}

		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public Short getLastUpdatedByLoginId() {
			return lastUpdatedByLoginId;
		}

		public void setLastUpdatedByLoginId(Short lastUpdatedByLoginId) {
			this.lastUpdatedByLoginId = lastUpdatedByLoginId;
		}

		public SecondaryUsers() {
			super();
		}
	    
	    
}
