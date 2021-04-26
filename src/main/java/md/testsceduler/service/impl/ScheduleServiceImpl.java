package md.testsceduler.service.impl;

import md.testsceduler.dto.requestSave.PaymentDto;
import md.testsceduler.entity.PaymentEntity;
import md.testsceduler.repository.PaymentRepository;
import md.testsceduler.service.FileService;
import md.testsceduler.service.ModelMapperService;
import md.testsceduler.service.ScheduleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service("scheduleTest")
@EnableScheduling
public class ScheduleServiceImpl implements ScheduleService {
    final Logger logger = Logger.getLogger(ScheduleServiceImpl.class);

    FileService fileService;
    ModelMapperService modelMapperService;
    TaskScheduler taskScheduler;
    PaymentRepository paymentRepository;

    @Autowired
    public void setPaymentRepository(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @Autowired(required = false)
    public void setTaskScheduler(TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
    }

    @Autowired
    public void setFileService(FileService fileService) {
        this.fileService = fileService;
    }

    @Autowired
    public void setModelMapperService(ModelMapperService modelMapperService) {
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Object save(PaymentDto dto) {

        return null;
    }

    @Override
    @Scheduled(fixedRate = 60000)
    public void scheduleSave() {
        logger.info("start sync");

        for (Object bid : modelMapperService.fromStringToList(fileService.readFile())) {
            Map<String, Map> map = (Map) bid;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    for (Map.Entry<String, Map> entry : map.entrySet()) {

                        PaymentEntity paymentEntity = modelMapperService.FromMapToEntity(entry.getValue());
                        paymentRepository.save(paymentEntity);
                    }
                }
            };
            runnable.run();
        }
    }


}
