package md.testsceduler.repository;

import md.testsceduler.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, BigDecimal> {
}
