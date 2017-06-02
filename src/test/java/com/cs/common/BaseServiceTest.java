package com.cs.common;

import com.cs.service.TransactionService;
import com.cs.service.UserService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

/**
 * Created by olgac on 01/06/2017.
 */
@MockBean({UserService.class, TransactionService.class})
@SpringBootTest
public abstract class BaseServiceTest extends BaseSpringTest {
}