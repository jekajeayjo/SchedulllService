package md.testsceduler.service;

import md.testsceduler.dto.requestSave.PaymentDto;
import md.testsceduler.entity.PaymentEntity;

import java.util.List;
import java.util.Map;

public interface ModelMapperService {
    String decodeBase64(String encodeString);

    List fromStringToList(String input);

    List<PaymentDto> ListMapToListDto(List list);

     PaymentEntity FromMapToEntity(Map map);

}
