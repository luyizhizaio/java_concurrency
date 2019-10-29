package com.kyrie.rocksdb;

import org.rocksdb.Options;
import org.rocksdb.RocksDB;
import org.rocksdb.RocksIterator;

/**
 * 入门案例
 */
public class Test {

	static{
		RocksDB.loadLibrary();
	}
	static RocksDB rocksDB; 
//
	static final String path = "D:\\github\\easyJava\\rocksdb\\test";
	public static void main(String[] args) throws Exception {
		Options options = new Options();  //数据库设置
		options.setCreateIfMissing(true);  
		rocksDB = RocksDB.open(options, path);

		byte[] key = "Hello".getBytes();
		byte[] value = "World".getBytes();

		byte[] key2 = "Hello2".getBytes();
		byte[] value2 = "World2".getBytes();



		//保存数据
		rocksDB.put(key,value);
		rocksDB.put(key2,value2);

		//读取数据
		byte[] getValue = rocksDB.get(key);
		System.out.println(new String(getValue));

		//遍历所有key-value
		RocksIterator iter = rocksDB.newIterator();
		for(iter.seekToFirst(); iter.isValid(); iter.next()) {  
			System.out.println("iter key:" + new String(iter.key()) + ", iter value:" + new String(iter.value()));  
		}

	}
}