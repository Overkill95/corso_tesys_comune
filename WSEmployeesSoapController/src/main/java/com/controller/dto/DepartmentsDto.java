package com.controller.dto;



public class DepartmentsDto {
	   
		private Integer departmentId;
		private String departmentName;
		private String locationId;

		
		
		public Integer getDepartmentId() {
			return departmentId;
		}

		public void setDepartmentId(Integer departmentId) {
			this.departmentId = departmentId;
		}

		public String getDepartmentName() {
			return departmentName;
		}

		public void setDepartmentName(String departmentName) {
			this.departmentName = departmentName;
		}

		public String getLocationId() {
			return locationId;
		}

		public void setLocationId(String locationId) {
			this.locationId = locationId;
		}
}
