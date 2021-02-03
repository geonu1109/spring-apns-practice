package geonu.name.apnspractice

import com.eatthepath.pushy.apns.PushNotificationResponse
import com.eatthepath.pushy.apns.util.SimpleApnsPushNotification
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/apns")
class ApnsController(
        val service: ApnsService
) {
    @PostMapping
    fun push(@RequestBody request: ApnsRequest): PushNotificationResponse<SimpleApnsPushNotification> {
        return this.service.push(request)
    }
}