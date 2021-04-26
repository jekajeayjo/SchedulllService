package md.testsceduler.dto.requestSave;

import md.testsceduler.entity.PaymentEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Queue;

public class PaymentDto {
    private BigDecimal id;
    private String ts;
    private String ty;
    private String payload;

    public PaymentDto() {
    }

    public PaymentDto(PaymentEntity entity) {
        setId(entity.getId());
        setPayload(entity.getPayload());
        setTs(entity.getDate().toString());
        setTy(entity.getName());
    }
    public PaymentDto(BigDecimal id, String ts, String ty, String payload) {
        this.id = id;
        this.ts = ts;
        this.ty = ty;
        this.payload = payload;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getTy() {
        return ty;
    }

    public void setTy(String ty) {
        this.ty = ty;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }
}
