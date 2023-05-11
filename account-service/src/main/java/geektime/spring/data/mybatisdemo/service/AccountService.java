package geektime.spring.data.mybatisdemo.service;

import geektime.spring.data.mybatisdemo.mapper.AccountMapper;
import geektime.spring.data.mybatisdemo.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;

    public int save(Account account){
        return accountMapper.save(account);
    }

    public Account findById(long id){
        return accountMapper.findById(id);
    }
}
