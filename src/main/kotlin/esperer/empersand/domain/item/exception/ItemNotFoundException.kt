package esperer.empersand.domain.item.exception

import esperer.empersand.global.error.ErrorCode
import esperer.empersand.global.error.exception.BasicException

class ItemNotFoundException : BasicException(ErrorCode.ITEM_NOT_FOUND) {
}