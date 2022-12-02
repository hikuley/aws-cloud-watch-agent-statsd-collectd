package augustovictor.com.github.cloudwatchagentstatsdcollectd

import com.timgroup.statsd.NonBlockingStatsDClient
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class StatsDClientAdapter(
        @Value("\${statsd.prefix}") val  statsdPrefix: String,
        @Value("\${statsd.host}") val  statsdHost: String,
        @Value("\${statsd.port}") val  statsdPort: String
) {
    @Bean
    fun configure() = NonBlockingStatsDClient(statsdPrefix, statsdHost, statsdPort.toInt())
}