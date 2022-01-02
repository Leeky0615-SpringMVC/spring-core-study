package hello.proxy;

import hello.proxy.config.v1_config.InterfaceProxyConfig;
import hello.proxy.config.v2_config.ConcreteProxyConfig;
import hello.proxy.config.v2_dynamicProxy.DynamicProxyBasicConfig;
import hello.proxy.config.v2_dynamicProxy.DynamicProxyFilterConfig;
import hello.proxy.config.v3_proxyfactory.ProxyFactoryConfigV1;
import hello.proxy.config.v3_proxyfactory.ProxyFactoryConfigV2;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.bind.annotation.InitBinder;

// @Import({AppV1Config.class,AppV2Config.class})
// @Import(InterfaceProxyConfig.class) // 인터페이스 클래스 프록시 패턴 적용
// @Import(ConcreteProxyConfig.class) // 구체클래스 프록시 패턴 적용
// @Import(DynamicProxyBasicConfig.class) // 기본 동적 프록시 적용 (reflection)
// @Import(DynamicProxyFilterConfig.class) // 동적 프록시 필터 적용 (reflection)
// @Import(ProxyFactoryConfigV1.class) // proxyFactory -> 인터페이스(jdkDynamicProxy)
@Import(ProxyFactoryConfigV2.class) // proxyFactory -> 구체클래스(CGLIB)
@SpringBootApplication(scanBasePackages = "hello.proxy.app") //주의
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean
	public LogTrace logTrace(){
		return new ThreadLocalLogTrace();
	}

}


