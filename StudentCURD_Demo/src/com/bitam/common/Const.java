package com.bitam.common;

public class Const {

	public static enum Sex{
		FAMALE("男"),MALE("女");
		
		private String sex;
		Sex(String sex) {
			this.sex = sex;
		}
		
		public String getSex() {
			return sex;
		}

		
		
	}
}
