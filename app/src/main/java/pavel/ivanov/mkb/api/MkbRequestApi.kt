package pavel.ivanov.mkb.api

data class MkbRequestApi(
    val code: Int,
    val downloadDate: String,
    val message: String,
    val messageTitle: String,
    val productState: Int,
    val rates: List<Rate>,
    val ratesDate: String,
    val rid: String
)