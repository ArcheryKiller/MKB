package pavel.ivanov.mkb.data.response

data class MkbRequestApi(
    val code: Int,
    val downloadDate: String,
    val message: String?,
    val messageTitle: String?,
    val productState: Int,
    val ratesDate: String,
    val rid: String,
    val rates: List<Rate>
)