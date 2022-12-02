package augustovictor.com.github.cloudwatchagentstatsdcollectd

import com.timgroup.statsd.NonBlockingStatsDClient
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/users")
class UserController(private val statsdClient: NonBlockingStatsDClient) {
    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping
    @RequestMapping("/login")
    fun login(@RequestBody loginSchemaDTO: LoginSchemaDTO): HttpStatus {
        return if (loginSchemaDTO.username == "firstuser" && loginSchemaDTO.password == "123") {
            logger.info("Correct credentials: $loginSchemaDTO")
            statsdClient.increment("users.login.success")
            HttpStatus.OK
        } else {
            logger.error("Wrong credentials: $loginSchemaDTO")
            statsdClient.increment("users.login.error")
            HttpStatus.UNAUTHORIZED
        }
    }
}