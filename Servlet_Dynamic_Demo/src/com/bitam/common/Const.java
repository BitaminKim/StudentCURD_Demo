package com.bitam.common;

public class Const {

	public static enum Sex{
		FAMALE("Famale"),MALE("Male");
		
		private String sex;
		Sex(String sex) {
			this.sex = sex;
		}
		
		public String getSex() {
			return sex;
		}

		
		
	}
}
