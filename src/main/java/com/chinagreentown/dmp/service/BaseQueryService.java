package com.chinagreentown.dmp.service;

import com.chinagreentown.dmp.pojo.UsrBasAttrPojo.attr;
import com.chinagreentown.dmp.pojo.UsrCNetBhvrPojo.bhvr;
import com.chinagreentown.dmp.pojo.UsrPoiInfoPojo.poi;
import com.chinagreentown.dmp.pojo.este_info.assc;
import com.chinagreentown.dmp.pojo.este_info.bas;
import org.apache.hadoop.hbase.filter.FilterList;

import java.util.List;

/**
 * Created by yun on 2017/4/17.
 *
 * @description 基础逻辑，获取habse 应用偏好表数据
 */
public interface BaseQueryService {

    /**
     * 返回   通信信息
     *
     * @param familly 列族
     * @param list    过滤器
     * @return 返回对象
     */
    List<com.chinagreentown.dmp.pojo.ComInfoPojo.com> getUsrCom(String familly, FilterList list);

    /**
     * 返回用户位置信息
     *
     * @param familly
     * @param list
     * @return
     */
    List<poi> getUsrPoiInfo(String familly, FilterList list);


    List<poi> getUsrPoiInfo(String familly, String column, FilterList list);

    /**
     * 获取用户基本信息
     *
     * @param familly
     * @param list
     * @return
     */
    List<attr> getUserAttr(String familly, FilterList list);

    /**
     * 分页方法
     *
     * @param startrow
     * @param familly
     * @param list
     * @return
     */
    List<attr> getUserAttr(String startrow, String familly, FilterList list);


    /**
     * @param family 获取列族
     * @param list   返回应用偏好
     * @return
     */
    List<bhvr> getUsrBhvr(String family, FilterList list);

    /**
     * 获取第一行rowKey
     *
     * @param tableName
     * @return
     */
    String getFirstData(String tableName);


    /**
     * 通过楼盘名获取成交用户列表
     *
     * @return
     */
    List<assc> getEsateAssc(String esateCode, FilterList list);

    /**
     * 获取楼盘的信息
     *
     * @param esateCode
     * @param list
     * @return
     */
    List<com.chinagreentown.dmp.pojo.este_info.bas> getEsateBas(String esateCode, FilterList list);


}
