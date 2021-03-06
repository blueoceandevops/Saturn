/**
 * Copyright 2016 vip.com.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 *  the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * </p>
 **/

package com.vip.saturn.job.console.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5工具类
 *
 * @author timmy.hu
 */
public class MD5Utils {

	private static final Logger log = LoggerFactory.getLogger(MD5Utils.class);

	private static final String[] HEXS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e",
			"f"};

	private MD5Utils() {
	}

	public static String getMD5Code(byte[] bytes) {
		String resultString = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = byteToString(md.digest(bytes));
		} catch (NoSuchAlgorithmException ex) {
			log.warn("Exception: {}", ex);
		}
		return resultString;
	}

	private static String byteToArrayString(byte bByte) {
		int iRet = bByte;
		if (iRet < 0) {
			iRet += 256;
		}
		int iD1 = iRet / 16;
		int iD2 = iRet % 16;
		return HEXS[iD1] + HEXS[iD2];
	}

	private static String byteToString(byte[] bByte) {
		StringBuilder sBuilder = new StringBuilder();
		for (int i = 0; i < bByte.length; i++) {
			sBuilder.append(byteToArrayString(bByte[i]));
		}
		return sBuilder.toString();
	}
}