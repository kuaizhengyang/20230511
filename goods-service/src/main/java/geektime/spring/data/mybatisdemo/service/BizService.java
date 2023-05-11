package geektime.spring.data.mybatisdemo.service;

import geektime.spring.data.mybatisdemo.model.Account;
import geektime.spring.data.mybatisdemo.model.Order;
import io.seata.integration.http.DefaultHttpExecutor;
import io.seata.integration.http.HttpExecutor;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.joda.money.CurrencyUnit;
import org.joda.money.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
@Slf4j
public class BizService {

    @Autowired
    OrderRemoteService orderService;
    @Autowired
    AccountRemoteService accountRemoteService;

    @GlobalTransactional
    public void save() throws IOException {
        Order o = orderService.save();
        log.info("Save Order: {}", o);

        Account c = accountRemoteService.save();
        log.info("Save Account: {}", c);
    }
}
