/**
 * Copyright (c) 2015-2016, BruceZCQ (zcq@zhucongqi.cn).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jfinal.ext2.plugin.activerecord.tx;

/**
 * 数据库事务处理
 * @author BruceZCQ
 */
public class DbTx {
	
	/**
	 * 处理数据库操作，包含事务处理
	 * @param tx
	 */
	public static void execute(Tx tx) {
		tx.execute();
	}
}
