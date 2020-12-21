package com.hogwarts.apiobject;

import static io.restassured.RestAssured.given;

/**
 * @author fyh
 * @date 2020/12/21
 */
public class TokenHelper {

	public static String getToken(){
		return given()
				.param("corpid", "ww0596505f44736493")
				.param("corpsecret", "09s8oDrnIjhheZ0vmBSsVAWGnV7Rvf_ynD8BTDz84xI")
				.when()
				.get("https://qyapi.weixin.qq.com/cgi-bin/gettoken")
				.then()
				.extract().response().path("access_token");
	}
}
