package esperer.empersand.global.error.exception

import esperer.empersand.global.error.ErrorCode

open class BasicException(val errorCode: ErrorCode) : RuntimeException(errorCode.message)