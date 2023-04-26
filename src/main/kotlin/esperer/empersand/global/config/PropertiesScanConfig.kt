package esperer.empersand.global.config

import esperer.empersand.global.security.token.JwtProperties
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.context.annotation.Configuration

@ConfigurationPropertiesScan(
    basePackageClasses = [
        JwtProperties::class
            ]
)
@Configuration
class PropertiesScanConfig {
}