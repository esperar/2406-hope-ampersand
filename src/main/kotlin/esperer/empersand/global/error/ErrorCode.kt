package esperer.empersand.global.error

enum class ErrorCode(
    val message: String,
    val status: Int
) {
    INVALID_TOKEN_TYPE("유효하지 않은 토큰 타입 입니다.", 403),
    INVALID_TOKEN("유효하지 않은 토큰 입니다.", 403),
    EXPIRED_REFRESH_TOKEN("만료된 refreshToken 입니다.", 403),
    EXPIRED_ACCESS_TOKEN("만료된 accessToken 입니다.", 403),

    POST_NOT_FOUND("게시글을 찾을 수 없습니다.", 404),

    USER_NOT_FOUND("존재하지 않는 유저, 404"),

    INTERVAL_SERVER_ERROR("서버 오류 입니다.", 500),
}