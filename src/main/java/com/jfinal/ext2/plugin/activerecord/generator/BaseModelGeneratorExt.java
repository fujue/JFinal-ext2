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
package com.jfinal.ext2.plugin.activerecord.generator;

import java.util.ArrayList;
import java.util.List;

import com.jfinal.plugin.activerecord.generator.BaseModelGenerator;
import com.jfinal.plugin.activerecord.generator.ColumnMeta;
import com.jfinal.plugin.activerecord.generator.TableMeta;

/**
 * BaseModelGenerator Extension
 * 
 * @author BruceZCQ
 */
public class BaseModelGeneratorExt extends BaseModelGenerator {

	private List<String> columns = new ArrayList<String>();

	private List<String> modelClass = new ArrayList<String>();

	protected String baseModelClassName = null;
	protected String tablename = null;

	protected String tableTemplate = "\tpublic static final String table = \"%s\";\n\n";

	// generate tablename in model
	private boolean generateTableNameInModel = true;
	
	// generate table column name in model
	private boolean generateTableColumnNameInModel = true;
	
	protected String tableColumnNameTemplate = "\tpublic static final String %s = \"%s\";\n\n";

	public BaseModelGeneratorExt(String baseModelPackageName, String baseModelOutputDir) {
		super(baseModelPackageName, baseModelOutputDir);
	}

	/**
	 * Generate Table name in Model
	 * 
	 * @param generateTableNameInModel
	 */
	public void setGenerateTableNameInModel(boolean generateTableNameInModel) {
		this.generateTableNameInModel = generateTableNameInModel;
	}
	
	/**
	 * Generate table column name in model
	 * @param generateTableColumnNameInModel
	 */
	public void setGenerateTableColumnNameInModel(boolean generateTableColumnNameInModel) {
		this.generateTableColumnNameInModel = generateTableColumnNameInModel;
	}

	@Override
	protected void genBaseModelContent(TableMeta tableMeta) {
		this.baseModelClassName = tableMeta.baseModelName;
		this.tablename = tableMeta.name;
		super.genBaseModelContent(tableMeta);
	}

	@Override
	protected void genSetMethodName(ColumnMeta columnMeta, StringBuilder ret) {
		if (!this.modelClass.contains(this.baseModelClassName) && this.generateTableNameInModel) {
			this.modelClass.add(this.baseModelClassName);
			ret.append(String.format(tableTemplate, this.tablename));
		}
		if (this.generateTableColumnNameInModel && !this.columns.contains(this.tablename+columnMeta.name)) {
			this.columns.add(this.tablename+columnMeta.name);
			//add column name
			ret.append(String.format(this.tableColumnNameTemplate, columnMeta.name.toUpperCase(), columnMeta.name));
		}
		super.genSetMethodName(columnMeta, ret);
	}
}
