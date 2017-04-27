package com.chinagreentown.dmp.controller;

import com.chinagreentown.dmp.Constant.Result;
import com.chinagreentown.dmp.pojo.salescenter.BaseInfo;
import com.chinagreentown.dmp.pojo.salescenter.Phone;
import com.chinagreentown.dmp.pojo.salescenter.SalesLabel;
import com.chinagreentown.dmp.service.QueryService;
import com.chinagreentown.dmp.util.FakeData;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * Created by admin on 2017/3/29.
 * 智慧案场相关接口
 */

@RestController
@RequestMapping("salescenter")
public class SalesCenterController {


    @Autowired
    private QueryService query;

    /**
     * wifi上报
     *
     * @param phonenum
     * @param token
     * @param phonebrand
     * @param macaddress
     * @param salescenterid
     * @param time
     * @return ResponseEntity<BaseInfo>
     */
    @RequestMapping(value = "/wifi", method = RequestMethod.POST)
    public ResponseEntity<BaseInfo> wifiReport(@RequestParam(value = "phonenum", required = false) String phonenum,
                                               @RequestParam(value = "token") String token,
                                               @RequestParam(value = "phonebrand") String phonebrand,
                                               @RequestParam(value = "macaddress") String macaddress,
                                               @RequestParam(value = "salescenterid") String salescenterid,
                                               @RequestParam(value = "time") String time) {
        try {
            BaseInfo baseInfo = new BaseInfo();
            baseInfo.setPhonenum("15079123333");
            baseInfo.setSalesnum("15079123563");
            // 对象创建成功，响应201
            return ResponseEntity.status(HttpStatus.CREATED).body(baseInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 查询出错，响应500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * wifi上报
     *
     * @param phonenum
     * @param token
     * @param phonebrand
     * @param macaddress
     * @param salescenterid
     * @param time
     * @return ResponseEntity<BaseInfo>
     * @Date 时间容日期  20170410
     * @version 1.0
     */
    @RequestMapping(value = "/wifi/v1.0", method = RequestMethod.POST)
    public ResponseEntity<Object> wifiReportV1(@RequestParam(value = "phonenum", required = false) String phonenum,
                                               @RequestParam(value = "token") String token,
                                               @RequestParam(value = "phonebrand") String phonebrand,
                                               @RequestParam(value = "mac") String macaddress,
                                               @RequestParam(value = "salescenterid") String salescenterid,
                                               @RequestParam(value = "time") String time) {
        try {
            HashMap<String, String> map = Maps.newHashMap();
            if (token.equals("test") && null != phonebrand && null != salescenterid && null != time && null != macaddress) {
                BaseInfo baseInfo = new BaseInfo();
                if (null == phonenum || phonenum.isEmpty()) {
                    return ResponseEntity.ok(Result.SuccessEmpty());
                }
                String ma5Phone = FakeData.getMa5Phone(phonenum);
                if (!ma5Phone.isEmpty()) {
                    long l = Long.parseLong(phonenum);
                    baseInfo.setPhonenum(ma5Phone);
                    Long i = l % 199;
                    baseInfo.setSalesnum(FakeData.getPhoneList2().get(i.intValue() % 5));
                    // 对象创建成功，响应201
                    return ResponseEntity.ok(Result.Success(baseInfo));
                } else if (ma5Phone.isEmpty()) {

                }
                return ResponseEntity.ok(Result.SuccessEmpty());
            }
            map.put("Reason", "parameter error");
            //参数错误
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 查询出错，响应500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 车牌上报
     *
     * @param phonenum
     * @param token
     * @param platenum
     * @param salescenterid
     * @param time
     * @return ResponseEntity<BaseInfo>
     */
    @RequestMapping(value = "/licencePlate", method = RequestMethod.POST)
    public ResponseEntity<BaseInfo> licencePlate(@RequestParam(value = "phonenum", required = false) String phonenum,
                                                 @RequestParam(value = "token") String token,
                                                 @RequestParam(value = "platenum") String platenum,
                                                 @RequestParam(value = "salescenterid") String salescenterid,
                                                 @RequestParam(value = "time") String time) {
        try {
            BaseInfo baseInfo = new BaseInfo();
            baseInfo.setPhonenum("15079123362");
            baseInfo.setSalesnum("15079123523");
            // 对象创建成功，响应201
            return ResponseEntity.status(HttpStatus.CREATED).body(baseInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 查询出错，响应500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 车牌上报
     *
     * @param phonenum      电话号码
     * @param token         校验参数
     * @param platenum      车牌号码
     * @param salescenterid
     * @param time          时间
     * @return ResponseEntity<BaseInfo>
     * @Version 1.0
     * @Date 时间格式20170410
     */
    @RequestMapping(value = "/licencePlate/v1.0", method = RequestMethod.POST)
    public ResponseEntity<Object> licencePlateV1(@RequestParam(value = "phonenum", required = false) String phonenum,
                                                 @RequestParam(value = "token") String token,
                                                 @RequestParam(value = "platenum") String platenum,
                                                 @RequestParam(value = "salescenterid") String salescenterid,
                                                 @RequestParam(value = "time") String time) {
        try {
            HashMap<String, String> map = Maps.newHashMap();
            if (token.equals("test") && null != platenum && null != salescenterid && null != time) {
                BaseInfo baseInfo = new BaseInfo();
                if (null == phonenum || phonenum.isEmpty()) {
                    return ResponseEntity.ok(Result.SuccessEmpty());
                }
                String ma5Phone = FakeData.getMa5Phone(phonenum);
                if (!ma5Phone.isEmpty()) {
                    long l = Long.parseLong(phonenum);
                    baseInfo.setPhonenum(ma5Phone);
                    Long i = l % 199;
                    baseInfo.setSalesnum(FakeData.getPhoneList2().get(i.intValue() % 5));
                    // 对象创建成功，响应201
                    return ResponseEntity.ok(Result.Success(baseInfo));
                } else if (ma5Phone.isEmpty()) {

                }
                return ResponseEntity.ok(Result.SuccessEmpty());
            }
            map.put("Reason", "parameter error");
            //参数错误
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(map);

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 查询出错，响应500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


    /**
     * 人脸上报
     *
     * @param phonenum
     * @param token
     * @param salescenterid
     * @param time
     * @return ResponseEntity<BaseInfo>
     */
    @RequestMapping(value = "/face", method = RequestMethod.POST)
    public ResponseEntity<BaseInfo> face(@RequestParam(value = "phonenum", required = false) String phonenum,
                                         @RequestParam(value = "token") String token,
                                         @RequestParam(value = "salescenterid") String salescenterid,
                                         @RequestParam(value = "time") String time) {
        try {
            BaseInfo baseInfo = new BaseInfo();
            baseInfo.setPhonenum("15079121234");
            baseInfo.setSalesnum("15079156677");
            // 对象创建成功，响应201
            return ResponseEntity.status(HttpStatus.CREATED).body(baseInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 查询出错，响应500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 人脸上报
     *
     * @param phonenum
     * @param token
     * @param salescenterid
     * @param time
     * @return ResponseEntity<BaseInfo>
     * @Version 1.0
     * @Date 时间格式20170410
     */
    @RequestMapping(value = "/face/v1.0", method = RequestMethod.POST)
    public ResponseEntity<Object> faceV1(@RequestParam(value = "phonenum", required = true) String phonenum,
                                         @RequestParam(value = "token") String token,
                                         @RequestParam(value = "salescenterid") String salescenterid,
                                         @RequestParam(value = "time") String time
    ) {
        try {
            HashMap<String, String> map = Maps.newHashMap();
            if (token.equals("test") && null != salescenterid && null != time) {
                BaseInfo baseInfo = new BaseInfo();
                if (null == phonenum || phonenum.isEmpty()) {
                    phonenum = FakeData.getPhoneList().get((int) (Long.parseLong(phonenum) % 5));
                }
                String ma5Phone = FakeData.getMa5Phone(phonenum);
                if (!ma5Phone.isEmpty()) {
                    long l = Long.parseLong(phonenum);
                    baseInfo.setPhonenum(ma5Phone);
                    Long i = l % 199;
                    baseInfo.setSalesnum(FakeData.getPhoneList2().get(i.intValue() % 5));
                    // 对象创建成功，响应201
                    return ResponseEntity.ok(Result.Success(baseInfo));
                } else if (ma5Phone.isEmpty()) {

                }
                return ResponseEntity.ok(Result.SuccessEmpty());
            }
            map.put("Reason", "parameter error");
            //参数错误
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 查询出错，响应500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 查询标签
     *
     * @param phonenum
     * @param token
     * @return ResponseEntity<SalesLabel>
     */
    @RequestMapping(value = "/label", method = RequestMethod.GET)
    public ResponseEntity<SalesLabel> getSalesLabel(@RequestParam(value = "phonenum") String phonenum,
                                                    @RequestParam(value = "token") String token) {
        try {
            SalesLabel salesLabel = new SalesLabel();
            salesLabel.setSex("男");
            salesLabel.setAge("25-30");
            salesLabel.setApppreference("生育");
            salesLabel.setBear("生育");
            salesLabel.setHascar("有车");
            salesLabel.setLive("西湖区");
            salesLabel.setWork("滨江区");
            salesLabel.setPurchasepurpose("学区");
            salesLabel.setMarriage("已婚");
            Phone phone = new Phone();
            phone.setBrand("xiaomi");
            phone.setModel("hongmi222");
            phone.setPrice("3000-4000");
            salesLabel.setPhone(phone);
            // // 查询成功，响应200
            return ResponseEntity.ok(salesLabel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 查询出错，响应500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }


    /**
     * 查询标签
     *
     * @param phonenum
     * @param token
     * @return ResponseEntity<SalesLabel>
     * @Version 1.0
     * @date 时间格式20170410
     */
    @RequestMapping(value = "/label/v1.0", method = RequestMethod.POST)
    public ResponseEntity<Object> getSalesLabelV1(@RequestParam(value = "phonenum") String phonenum,
                                                  @RequestParam(value = "token") String token,
                                                  @RequestParam(value = "date") String date) {
        try {
            List<Object> list = Lists.newArrayList();
            HashMap<Object, Object> objectObjectHashMap = Maps.newHashMap();
            if (null != phonenum && token.equals("test") && null != date) {
                String[] phone = phonenum.split(",");
                for (String str : phone) {
                    if (str.length() == 11) {
                        String ma5Phone = FakeData.getMa5Phone(str);
                        if (!ma5Phone.isEmpty()) {
                            list.add(query.getuUerInfo(str));
//                        list.put(ma5Phone, query.getuUerInfo(str));
                        } else {
//                        list.put(str, FakeData.HttpStr.PHONEERROR.toString());
                        }
                    } else if (str.length() == 32) {
                        list.add(query.getuUerInfo("18968102733"));
                    }
                }
                if (!list.isEmpty()) {
                    return ResponseEntity.ok(Result.Success(list));
                } else {
                    return ResponseEntity.ok(Result.SuccessEmpty());
                }
            }
            //参数错误
            objectObjectHashMap.put("Reason", "parameter error");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(objectObjectHashMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 查询出错，响应500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
