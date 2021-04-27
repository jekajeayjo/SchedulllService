package md.testsceduler.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "PAYMENT_ENTITY")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigDecimal id;
    @Column(name = "TRANSACTION_ID")
    private BigDecimal transactionId;
    @Column(name = "DATE")
    private LocalDateTime date;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PAYLOAD")
    private String  payload;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public void setId(String id) {
        this.id = new BigDecimal(id);
    }
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public void setDate(String second) {
        this.date = LocalDateTime.ofEpochSecond(new Long(second), 0, ZoneOffset.UTC);;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public BigDecimal getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(BigDecimal transactionId) {
        this.transactionId = transactionId;
    }
    public void setTransactionId(String id) {
        this.transactionId = new BigDecimal(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentEntity that = (PaymentEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(transactionId, that.transactionId) &&
                Objects.equals(date, that.date) &&
                Objects.equals(name, that.name) &&
                Objects.equals(payload, that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, transactionId, date, name, payload);
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "id=" + id +
                ", transactionId=" + transactionId +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}
