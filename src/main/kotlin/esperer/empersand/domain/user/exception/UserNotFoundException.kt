package esperer.empersand.domain.user.exception

import esperer.empersand.global.error.ErrorCode
import esperer.empersand.global.error.exception.BasicException

class UserNotFoundException : BasicException(ErrorCode.USER_NOT_FOUND)