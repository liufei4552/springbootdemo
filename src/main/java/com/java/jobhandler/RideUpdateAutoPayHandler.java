package com.java.jobhandler;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import com.xxl.job.core.log.XxlJobLogger;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
* 功能描述: 代叫车自动扣款
 * @param
* @return:
* @Author: liufei
* @Date: 2020/1/13 10:34
*/
@JobHandler(value="RideUpdateAutoPayHandler")
@Component
@Slf4j
public class RideUpdateAutoPayHandler extends IJobHandler {
    /*@Autowired
    private PayService payService;
    @Resource
    private RideOrderMapper rideOrderMapper;*/

    private static final Logger logger = LoggerFactory.getLogger(RideUpdateAutoPayHandler.class);

    @Override
    public ReturnT<String> execute(String s) throws Exception {
        log.info("测试调度.................................");
       /* logger.info("代叫车自动扣款");
        XxlJobLogger.log("代叫车自动扣款");
        //查询未支付订单进行支付
        List<TaxiRideOrderVo> taxiRideOrderVoList=rideOrderMapper.selectUpdateNotPayList();
        if(CollectionUtils.isNotEmpty(taxiRideOrderVoList)){
                //循环支付
            for (TaxiRideOrderVo item:taxiRideOrderVoList) {
                PayQuery payQuery=new PayQuery();
                payQuery.setOrderNo(item.getOrderNo());
                payQuery.setUserId(item.getUserId());
                payQuery.setDeductionMark("System deduction");
                try {
                    ServerResponse serverResponse=payService.userPay(payQuery);
                    if(serverResponse.isSuccess()){
                        logger.info("代叫自动扣款完成................");
                    }else {
                        logger.info("代叫自动扣款失败message:{}................",serverResponse.getMsg());
                    }
                }catch (ApiException e){
                    logger.info("代叫自动扣款出现未知错误................");
                    e.printStackTrace();
                    continue;
                }
            }
        }*/
        return SUCCESS;
    }
}
