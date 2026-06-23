package com.wanted.springevent.section03.service;

import com.wanted.springevent.enrollment.entity.Enrollment;
import com.wanted.springevent.enrollment.repository.EnrollmentRepository;
import com.wanted.springevent.section03.event.Section03CourseCompletedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
// private static final Logger log = LoggerFactory.getLogger(Section02CourseCompletionService.class);
// 이걸 생략해도 로그를 찍을 수 있게 하는 어노테이션 (@Slf4j)
@Service
public class Section03CourseCompletionService {

    private final EnrollmentRepository enrollmentRepository;
    // Event 발행자
    private final ApplicationEventPublisher publisher;

    // 생성자로 의존성 주입
    public Section03CourseCompletionService(
            EnrollmentRepository enrollmentRepository,
            ApplicationEventPublisher publisher
    ) {
        this.enrollmentRepository = enrollmentRepository;
        this.publisher = publisher;
    }

    /* hi.
    *   Section03 의 실행 시나리오
    *   publishEvent() 를 호출하는 시점은 @Transactional 내부에 감싸져 있다.
    *   단순히 Event를 분리하고 끝내는 것이 아닌, 후속작업 (Event) 의 실행 시점을
    *   제어하는 것이 중요하다. (ex) 수강 취소했는데 수료증이 발급되는 경우 막기)
    *   DB Commit 이 된 이후에 실행이 되어야 안전한 Event 작업은
    *   @TransactionalEventListener(AFTER_COMMIT) 으로 분리한다.
    *  */

    @Transactional
    public void completeCourse(Long enrollmentId){

        Enrollment enrollment = enrollmentRepository.findWithUserAndCourseByEnrollmentId(enrollmentId)
                .orElseThrow(() -> new IllegalArgumentException("수강 정보 찾을 수 없습니다!"));

        // 수강 완료
        enrollment.complete();

        log.info("[section03] Course 서비스는 수강 완료 후 이벤트를 발행한다.");

        // publisher 를 이용해서 "수강 완료" 이벤트 발행
        publisher.publishEvent(
                new Section03CourseCompletedEvent(
                        enrollment.getEnrollmentId(),
                        enrollment.getCourse().getTitle()
                )
        );
    }
}
