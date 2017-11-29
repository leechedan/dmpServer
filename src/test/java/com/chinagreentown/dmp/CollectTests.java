/**
 * Copyright 2017 © hawkeyedata.com.cn Corp. All Rights Reserverd.
 * <p>
 * 广州鹰眼数据处理服务有限公司    http://www.hawkeyedata.com.cn/
 * <p>
 * Create Date : 2017/5/18 0018
 **/
package com.chinagreentown.dmp;

import com.chinagreentown.dmp.util.MapCollector;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 * @author <a href="mailto:hawkeye_ljc@126.com">李建超</a>
 */
public class CollectTests {

	public final static Logger logger = LoggerFactory.getLogger(CollectTests.class);

	@Test
	public void collTest() {
		Map<byte[], byte[]> map = new HashMap<>();
		for(int i=0; i!=10; i++) {

			map.put(new String("asfa"+ i).getBytes(), new String("value"+i).getBytes());
		}
		//Map<String, byte[]> collect = map.entrySet().stream().collect(MapCollector.collector());
		logger.info("dsf");
	}

}
