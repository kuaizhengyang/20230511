package geektime.spring.data.mybatisdemo.service;

import geektime.spring.data.mybatisdemo.model.Account;
import geektime.spring.data.mybatisdemo.model.Order;
import io.seata.integration.http.DefaultHttpExecutor;
import io.seata.integration.http.HttpExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
@Slf4j
public class OrderRemoteService {

    public Order save() throws IOException {
        HttpExecutor httpExecutor= DefaultHttpExecutor.getInstance();
        Order order = httpExecutor.executeGet("http://localhost:8079", "/order/save/", new HashMap<>(), Order.class);
        log.info("save order: {}", order);
        return order;
    }
}
