package geektime.spring.data.mybatisdemo.service;

import geektime.spring.data.mybatisdemo.model.Account;
import io.seata.integration.http.DefaultHttpExecutor;
import io.seata.integration.http.HttpExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;

@Service
@Slf4j
public class AccountRemoteService {

    public Account save() throws IOException {
        HttpExecutor httpExecutor= DefaultHttpExecutor.getInstance();
        Account account = httpExecutor.executeGet("http://localhost:8080", "/account/tcc/save/", new HashMap<>(), Account.class);
        log.info("save account: {}", account);
        return account;
    }
}
