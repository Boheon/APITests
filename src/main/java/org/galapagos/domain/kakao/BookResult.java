package org.galapagos.domain.kakao;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class BookResult {
    @SerializedName("documents")
    List<Book> books;

    @SerializedName("meta")
    Meta meta;
}
