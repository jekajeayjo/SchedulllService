package md.testsceduler.service;

import md.testsceduler.dto.requestSave.PaymentDto;


public interface ScheduleService {
    Object save(PaymentDto dto);

    void scheduleSave();
}
