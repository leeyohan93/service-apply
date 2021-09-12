package apply.application

import apply.domain.applicant.Applicant
import apply.domain.cheater.Cheater
import java.time.LocalDateTime
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank

data class CheaterData(
    @field:NotBlank
    @field:Email
    val email: String,

    @field:NotBlank
    var description: String
)

data class CheaterResponse(
    val id: Long,
    val createdDateTime: LocalDateTime,
    val description: String,
    val email: String,
    val name: String?
) {
    constructor(cheater: Cheater, applicant: Applicant?) : this(
        cheater.id,
        cheater.createdDateTime,
        cheater.description,
        cheater.email,
        applicant?.name
    )
}