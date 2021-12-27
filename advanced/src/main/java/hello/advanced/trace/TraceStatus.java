package hello.advanced.trace;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public class TraceStatus {
// 로그를 시작할 때 상태 정보를 가지고 있음

    private TraceId traceId;
    private Long startTimeMs;
    private String message;
}
