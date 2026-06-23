package com.wanted.springevent.section03.listener;

import com.wanted.springevent.certificate.entity.Certificate;
import com.wanted.springevent.certificate.repository.CertificateRepository;
import com.wanted.springevent.certificate.service.CertificateService;
import com.wanted.springevent.enrollment.entity.Enrollment;
import com.wanted.springevent.enrollment.repository.EnrollmentRepository;
import com.wanted.springevent.section03.event.Section03CourseCompletedEvent;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.UUID;

@Slf4j
@Component
public class Section03CertificateEventListener {

    private final CertificateService certificateService;

    public Section03CertificateEventListener(
            CertificateService certificateService
    ) {
        this.certificateService = certificateService;
    }

    /* hi.
    *   Listener 클래스의 책임은 Event 를 전달받고, 언제 실행하며,
    *   어느 처리자에게 Event 를 넘길지를 정하는 역할을 하게 된다.
    *   ---
    *   AFTER_COMMIT 의 의미
    *   - 수강 완료 트랜젝션이 정상 COMMIT 된 뒤에만 실행이 된다.
    *   - 따라서 수강 완료 메서드가 ROLLBACK 되면 해당 Listener는 동작하지 않는다.
    *   ---
    *   왜 이런 것을 생각해야 하나?
    *   - 수료증 발급은 반드시 수강 완료가 DB에 INSERT가 된 후에만 의미가 있다.
    *  */

    // @TransactionalEventListener : 서비스로직이 성공한 뒤에 실행되도록 함
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT) // phase: 트랜잭션의 경계
    public void eventHandle(Section03CourseCompletedEvent event){
        certificateService.issueAfterCourseCompletion(
                event.enrollmentId(),
                event.courseTitle(),
                "AFTER-COMMIT"
        );
    }
}


