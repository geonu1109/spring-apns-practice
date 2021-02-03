package geonu.name.apnspractice

import com.eatthepath.pushy.apns.ApnsClientBuilder
import com.eatthepath.pushy.apns.PushNotificationResponse
import com.eatthepath.pushy.apns.util.SimpleApnsPayloadBuilder
import com.eatthepath.pushy.apns.util.SimpleApnsPushNotification
import org.springframework.stereotype.Service
import java.io.File

@Service
class ApnsService {

    fun push(request: ApnsRequest): PushNotificationResponse<SimpleApnsPushNotification> {
        val apnsClient = ApnsClientBuilder()
                .setApnsServer(ApnsClientBuilder.PRODUCTION_APNS_HOST)
                .setClientCredentials(File("./src/main/resources/cert/${request.certFilename}"), request.certPassword)
                .build()

        val payload = SimpleApnsPayloadBuilder()
                .setAlertTitle(request.title)
                .setAlertBody(request.body)
                .setSound("default")
                .build()

        val pushNotification = SimpleApnsPushNotification(request.apnsToken, request.bundleId, payload);

        return apnsClient.sendNotification(pushNotification).get()
    }
}