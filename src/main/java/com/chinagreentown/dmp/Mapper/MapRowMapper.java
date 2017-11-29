package com.chinagreentown.dmp.Mapper;

import com.chinagreentown.dmp.api.RowMapper;
import com.chinagreentown.dmp.pojo.PeopleDto;
import com.chinagreentown.dmp.util.MapCollector;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2017/4/8.
 */
public class MapRowMapper implements RowMapper<Map<String, String>> {
    private final static byte[] COLUMNFAMILY = "f".getBytes();
    private final static byte[] PHONE = "phone".getBytes();
    private final static byte[] AGE = "age".getBytes();

    @Override
    public Map<String, String> mapRow(Result result, int rowNum, String family) throws Exception {

        return result.getFamilyMap(family.getBytes()).entrySet().stream().collect(MapCollector.collector());
    }
}
