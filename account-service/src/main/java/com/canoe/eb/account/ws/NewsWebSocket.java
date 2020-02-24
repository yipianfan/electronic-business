package com.canoe.eb.account.ws;

import com.canoe.eb.account.bean.dto.News;
import com.canoe.eb.common.entity.ResEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NewsWebSocket {
    @Autowired
    private SimpMessagingTemplate smt;

    @RequestMapping("news/push")
    public ResEntity<Void> push(News news) {
        smt.convertAndSend("/news/client", news);
        return ResEntity.ok();
    }
}