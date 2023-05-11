package geektime.spring.data.mybatisdemo.service;

import geektime.spring.data.mybatisdemo.model.Account;
import io.seata.rm.tcc.api.BusinessActionContext;
import io.seata.rm.tcc.api.BusinessActionContextParameter;
import io.seata.rm.tcc.api.LocalTCC;
import io.seata.rm.tcc.api.TwoPhaseBusinessAction;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Slf4j
@Service
@LocalTCC
public class AccountTccService {
    @Autowired
    AccountService accountService;
    /**
     * 定义两阶段提交 name = 该tcc的bean名称,全局唯一 commitMethod = commit 为二阶段确认方法 rollbackMethod = rollback 为二阶段取消方法
     * useTCCFence=true 为开启防悬挂
     * BusinessActionContextParameter注解 传递参数到二阶段中
     *
//     * @param params  -入参
     * @return String
     */
    @TwoPhaseBusinessAction(name = "accountTccService", commitMethod = "commit", rollbackMethod = "rollback")
    public void save(@BusinessActionContextParameter(paramName = "account") Account account) {
        int count = accountService.save(account);
        log.info("Tcc Save {} Account: {}", count, account);
    }

    /**
     * 确认方法、可以另命名，但要保证与commitMethod一致 context可以传递try方法的参数
     *
     * @param context 上下文
     * @return boolean
     */
    public void commit(BusinessActionContext context) {
        log.info("预留资源真正处理,或者发出mq消息和redis入库");
//        throw new RuntimeException("报个错看看");
    }

    /**
     * 二阶段取消方法
     *
     * @param context 上下文
     * @return boolean
     */
    public void rollback(BusinessActionContext context) {
        log.info("预留资源释放,或清除一阶段准备让二阶段提交时发出的消息缓存");
    }
}
