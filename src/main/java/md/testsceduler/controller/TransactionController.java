package md.testsceduler.controller;

import md.testsceduler.dto.requestSave.PaymentDto;
import md.testsceduler.service.impl.PaymentServiceImpl;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TransactionController.URL_PREFIX)
public class TransactionController {
    public static final String URL_PREFIX = "/api";
    public static final String SAVE = "/save";
    public static final String SAVE_LIST = "/save_list";
    public static final String GET_ALL = "/get_all";
    final Logger logger = Logger.getLogger(TransactionController.class);
    PaymentServiceImpl paymentService;

    @Autowired
    public void setPaymentService(PaymentServiceImpl paymentService) {
        this.paymentService = paymentService;
    }

    @RequestMapping(method = RequestMethod.POST, value = SAVE)
    public Object save(@RequestBody PaymentDto dto) {
        return null;
    }

    @RequestMapping(method = RequestMethod.POST, value = SAVE_LIST)
    public Object saveList(@RequestBody Object dto) {
        return null;
    }

    @RequestMapping(method = RequestMethod.GET, value = GET_ALL)
    public Object getAll() {
        logger.info("get all transactions");
        return paymentService.getAllPaymentDto();
    }
}
