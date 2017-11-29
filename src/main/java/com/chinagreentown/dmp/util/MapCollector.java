/**
 * Copyright 2017 © hawkeyedata.com.cn Corp. All Rights Reserverd.
 * <p>
 * 广州鹰眼数据处理服务有限公司    http://www.hawkeyedata.com.cn/
 * <p>
 * Create Date : 2017/5/18 0018
 **/
package com.chinagreentown.dmp.util;

import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.util.*;
import java.util.stream.Collector;

/**
 *
 * @author <a href="mailto:hawkeye_ljc@126.com">李建超</a>
 */
public class MapCollector {

	private Logger logger  = LoggerFactory.getLogger(MapCollector.class);

	private final Map<String, String> result = new HashMap<>();

	public void accept(Map.Entry<byte[], byte[]> entry) {
		String key = new String(entry.getKey(), Charset.forName("UTF-8"));
		String value = Bytes.toString(entry.getValue());
		Long valueLong = null;
		try {
			valueLong = Bytes.toLong(entry.getValue());
		} catch (IllegalArgumentException e){
			value = Bytes.toString(entry.getValue());
		}
		logger.info("output {} {}",valueLong, value);
		/*String key = entry.getKey().toString();
		String value = entry.getValue().toString();
		Set<String> overlapKeys = result.entrySet().stream()
				.filter(e -> e.getValue().stream().anyMatch(value::contains))
				.map(Map.Entry::getKey)
				.collect(Collectors.toSet());
		overlapKeys.stream().forEach(key::addAll);
		overlapKeys.stream().map(result::get).forEach(value::addAll);
		result.keySet().removeAll(overlapKeys);*/
		result.put(key, value);
	}

	public MapCollector combine(MapCollector other) {
		logger.info("---");
		//other.result.entrySet().forEach(this::accept);
		return this;
	}

	public static Collector<Map.Entry<byte[], byte[]>, MapCollector, Map<String,String>> collector() {
		return Collector.of(MapCollector::new, MapCollector::accept, MapCollector::combine, c -> c.result);
	}
}