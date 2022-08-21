package pavel.ivanov.mkb.data.api

data class Rate(
    val basic: String,
    val buy: String,
    val currMnemFrom: String,
    val currMnemTo: String,
    val deltaBuy: String,
    val deltaSale: String,
    val from: Int,
    val name: String,
    val sale: String,
    val to: Int,
    val tp: Int
)