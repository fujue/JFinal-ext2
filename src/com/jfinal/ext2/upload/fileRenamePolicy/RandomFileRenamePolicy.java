/**
 * 
 */
package com.jfinal.ext2.upload.fileRenamePolicy;

import java.io.File;

import com.jfinal.ext2.kit.RandomKit;


/**
 * @author BruceZCQ
 * 随机文件名
 * baseSaveDir/xxxxxx.jpg
 */
public class RandomFileRenamePolicy extends FileRenamePolicyWrapper {

	@Override
	public File nameProcess(File f, String name, String ext) {
		String path = f.getParent();
		this.setSaveDirectory(path);
		return (new File(path,RandomKit.randomMD5Str()+ext));
	}
}