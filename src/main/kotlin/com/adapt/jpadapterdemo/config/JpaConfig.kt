package com.adapt.jpadapterdemo.config

import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaRepositories(basePackages = ["com.adapt.jpadapterdemo.repository"])
class JpaConfig
