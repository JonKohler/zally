package de.zalando.zally.integration.validation

import de.zalando.zally.integration.config.StringJsonUserType
import org.hibernate.annotations.Type
import org.hibernate.annotations.TypeDef
import org.hibernate.annotations.TypeDefs
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EntityListeners
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@TypeDefs(value = TypeDef(name = "StringJsonObject", typeClass = StringJsonUserType::class))
@EntityListeners(value = AuditingEntityListener::class)
@Entity
data class ApiValidation(

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "api_validation_id")
        var id: Long? = null,

        @ManyToOne
        @JoinColumn(name="pull_request_validation_id")
        var pullRequestValidation: PullRequestValidation? = null,

        var fileName: String? = null,

        var apiDefinition: String? = null,

        @Type(type = "StringJsonObject")
        var violations: String? = null
)