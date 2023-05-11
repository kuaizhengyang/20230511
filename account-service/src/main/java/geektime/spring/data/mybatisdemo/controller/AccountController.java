package geektime.spring.data.mybatisdemo.controller;

import geektime.spring.data.mybatisdemo.model.Account;
import geektime.spring.data.mybatisdemo.service.AccountBizService;
import geektime.spring.data.mybatisdemo.service.AccountTccService;
import geektime.spring.data.mybatisdemo.vo.AccountVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@Slf4j
public class AccountController {
    @Autowired
    private AccountBizService accountBizService;

    @Autowired
    private AccountTccService accountTccService;

    @GetMapping("/save")
    public Account save(AccountVo accountVo){
        try {
            Account account = accountBizService.save(accountVo);
            return account;
        }catch (Exception e){
            log.error("账户存储异常",e);
        }
        return null;
    }

    @GetMapping(path ="/tcc/save", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Account tccSave(AccountVo accountVo) {
        Account account = Account.builder().name(accountVo.getName())
                .userId(accountVo.getUserId())
                .createBy(accountVo.getName())
                .updateBy(accountVo.getName())
                .build();
        accountTccService.save(account);
        return account;
    }

}
