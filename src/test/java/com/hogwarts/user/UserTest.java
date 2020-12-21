package com.hogwarts.user;

import com.hogwarts.apiobject.TokenHelper;
import com.hogwarts.apiobject.UserObject;
import com.hogwarts.utils.FakerUtils;
import io.qameta.allure.Epic;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author fyh
 * @date 2020/12/21
 * @desc 用户测试
 */
@Epic("企业微信用户测试")
public class UserTest {

	private static String accessToken;

	@BeforeAll
	static void getAccessToken() {
		accessToken = TokenHelper.getToken();
	}

	@DisplayName("创建用户")
	@Test
	void createUserTest() {
		Response response = UserObject.create(FakerUtils.getRandomStr(10), accessToken);
		assertEquals("0", response.path("errcode").toString());
	}

	@Test
	void updateUserTest(){
		String userId = FakerUtils.getRandomStr(10);
		Response response = UserObject.create(userId, accessToken);
		assertEquals("0", response.path("errcode").toString());

		Response response1 = UserObject.update(userId, accessToken);
		assertEquals("0", response1.path("errcode").toString());
	}

	@Test
	void deleteUserTest(){
		String userId = FakerUtils.getRandomStr(10);
		Response response = UserObject.create(userId, accessToken);
		assertEquals("0", response.path("errcode").toString());

		Response response1 = UserObject.delete(userId, accessToken);
		assertEquals("0", response1.path("errcode").toString());
	}
}
