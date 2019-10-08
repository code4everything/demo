package org.code4everything.demo.springboot.rabbitmq.dao;

import cn.hutool.core.util.ObjectUtil;
import org.code4everything.demo.springboot.rabbitmq.domain.MsgLog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 这里只是模拟数据库操作
 *
 * @author pantao
 * @since 2019/10/8
 */
@Repository
public class MsgLogDAO {

    private final Map<String, MsgLog> msgLogMap = new ConcurrentHashMap<>(16);

    public void saveMsgLog(MsgLog msgLog) {
        msgLogMap.put(msgLog.getId(), msgLog);
    }

    public void plusRetryById(String id) {
        MsgLog msgLog = msgLogMap.get(id);
        if (ObjectUtil.isNotNull(msgLog)) {
            msgLog.setRetryCount(msgLog.getRetryCount() + 1);
        }
    }

    public void updateStatusById(String id, Character status) {
        MsgLog msgLog = msgLogMap.get(id);
        if (ObjectUtil.isNotNull(msgLog)) {
            msgLog.setStatus(status);
        }
    }

    public List<MsgLog> listByStatus(Character status) {
        List<MsgLog> msgLogs = new ArrayList<>();
        msgLogMap.forEach((k, v) -> {
            if (v.getStatus().equals(status)) {
                msgLogs.add(v);
            }
        });
        return msgLogs;
    }
}
