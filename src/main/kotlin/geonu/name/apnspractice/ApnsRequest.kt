package geonu.name.apnspractice

data class ApnsRequest(
        val bundleId: String,
        val certFilename: String,
        val certPassword: String,
        val apnsToken: String,
        val title: String,
        val body: String
)