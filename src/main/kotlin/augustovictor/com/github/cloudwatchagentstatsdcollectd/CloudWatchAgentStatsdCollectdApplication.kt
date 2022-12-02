package augustovictor.com.github.cloudwatchagentstatsdcollectd

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CloudWatchAgentStatsdCollectdApplication

fun main(args: Array<String>) {
	runApplication<CloudWatchAgentStatsdCollectdApplication>(*args)
}
