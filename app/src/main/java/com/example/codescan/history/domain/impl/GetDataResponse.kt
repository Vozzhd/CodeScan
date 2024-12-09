package com.example.codescan.history.domain.impl

import com.example.codescan.root.network.retrofit.Response

class GetDataResponse(
    val dataEntries: BoxDataDtoArray
) : Response()
