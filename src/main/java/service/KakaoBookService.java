package service;



import org.galapagos.domain.kakao.BookResult;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface KakaoBookService {
  String BASE_URL = "https://dapi.kakao.com/";


  @GET("v3/search/book")
  @Headers({ "Authorization: KakaoAK 428d97534b7bfb2d6a63f7bbd791026e"})
  Call<BookResult> searchBook(@Query("query") String query, @Query("size") int size, @Query("page") int page);

  public static KakaoBookService getService(){
      Retrofit retrofit = new Retrofit.Builder()
              .baseUrl(BASE_URL)
              .addConverterFactory(GsonConverterFactory.create())
              .build();

      return retrofit.create(KakaoBookService.class);
  }

}
