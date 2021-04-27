package md.testsceduler.service.impl;

import com.google.gson.Gson;
import md.testsceduler.dto.requestSave.PaymentDto;
import md.testsceduler.entity.PaymentEntity;
import md.testsceduler.service.ModelMapperService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@Service("modelMapper")
public class ModelMapperServiceImpl implements ModelMapperService {
    final Logger logger = Logger.getLogger(ModelMapperServiceImpl.class);

    @Override
    public String decodeBase64(String encodeString) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodeString);
        return new String(decodedBytes);
    }

    @Override
    public List fromStringToList(String input) {
        logger.info("start realize from string to object");
        if (input != null || input != "") {
            Gson gson = new Gson();
            return gson.fromJson(input, ArrayList.class);
        } else {
            return null;
        }

    }

    @Override
    public List<PaymentDto> ListMapToListDto(List list) {
        for (int i = 0; i < list.size(); i++) {
            Map map = (Map) list.get(i);


        }

        return null;
    }

    @Override
    public PaymentEntity FromMapToEntity(Map map) {
        logger.info("start realize from map to entity");
        PaymentEntity paymentEntity = new PaymentEntity();
        map.forEach((key, value) ->
        {
            if (key != null || key != "") {
                if (key=="id"||key.equals("id")) {
                    paymentEntity.setTransactionId((String) value);
                }
                else if (key.equals("ts"))
                {
                    paymentEntity.setDate((String) value);
                }
                else if (key.equals("ty"))
                {
                    paymentEntity.setName((String) value);
                }
                else if (key.equals("pl"))
                {
                    paymentEntity.setPayload(decodeBase64((String) value));
                }
            }


        });

        return paymentEntity;
    }


}
