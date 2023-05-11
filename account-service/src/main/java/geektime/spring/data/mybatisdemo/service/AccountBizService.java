package geektime.spring.data.mybatisdemo.service;

import geektime.spring.data.mybatisdemo.model.Account;
import geektime.spring.data.mybatisdemo.vo.AccountVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountBizService {
    @Autowired
    AccountService accountService;

    public Account save(AccountVo accountVo) {
        Account account = Account.builder().name(accountVo.getName())
                .userId(accountVo.getUserId())
                .createBy(accountVo.getName())
                .updateBy(accountVo.getName())
                .build();
        int count = accountService.save(account);
        if(count>0){
            return account;
        }else{
            return null;
        }
    }

}
