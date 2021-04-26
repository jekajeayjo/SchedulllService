package md.testsceduler.service.impl;

import md.testsceduler.dto.requestSave.PaymentDto;
import md.testsceduler.entity.PaymentEntity;
import md.testsceduler.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentServiceImpl {

    private PaymentRepository paymentRepository;

    @Autowired
    public void setPaymentRepository(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
    public List<PaymentDto> getAllPaymentDto()
    {
        return paymentRepository.findAll().stream().map(entity->new PaymentDto(entity)).collect(Collectors.toList());
    }
}
