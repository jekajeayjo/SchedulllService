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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentEntity that = (PaymentEntity) o;
        return id.equals(that.id) &&
                date.equals(that.date) &&
                name.equals(that.name) &&
                payload.equals(that.payload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, name, payload);
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "id=" + id +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", payload='" + payload + '\'' +
                '}';
    }
}
